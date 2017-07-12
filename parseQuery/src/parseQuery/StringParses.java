package parseQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParses {
	QueryParameter queryParameter;

	public StringParses () {
		queryParameter = new QueryParameter();
	}
	public void createQuery(String queryline) {
		
		String splitQuery[];
		if (queryline.contains("where")) 
		{
			splitQuery = queryline.split("where");
			this.whereClause(splitQuery[0]);

			
			
		}
		else
		{
			this.querySelectToFrom(queryline);
		}
	}
	
	public void querySelectToFrom(String parameter) {

		String pattern = "select(.*)from(.*)";
		Pattern r = Pattern.compile(pattern);

		// Now create matcher object.

		List<String> fieldlist = new ArrayList<>();
		String filename = null;
		Matcher m = r.matcher(parameter);

		if (m.find()) {
			if (m.group(1).contains("*")) {
				fieldlist.add(m.group(1));
			} else {
				String[] fielditem = m.group(1).split(",");
				for (String field : fielditem) {
					fieldlist.add(field);

				}

			}

			filename = m.group(2);
			for (String f : fieldlist) {
				System.out.println(f);
			}
			System.out.println(filename);

			queryParameter.setFields(fieldlist);
			queryParameter.setFilePath(filename);
			
			
		}
	}
	
	
	private void whereClause(String whereParam) {
		// TODO Auto-generated method stub

		String pattern = "(.*)";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(whereParam);
		String[] whereArray = null;

		String whereString = null;
		Criteria criteria = new Criteria();

		if (m.find()) {
			whereString = m.group(1);
			System.out.println(whereString);

			whereArray = whereString.split(" ");
			for (String condition : whereArray) {
				// System.out.println(c);
				if (!(condition.equals("and") || condition.equals("or"))) {
					String pattern1 = "(([A-Z])\\w+)$";
					Pattern p = Pattern.compile(pattern1);
					Matcher m1 = p.matcher(condition);
					if (m.find()) {
						String searchValue = m.group();
						criteria.setValue(searchValue);
						// System.out.println(column);
					}
					String pattern2 = "(([A-Z])\\w+)";
					Pattern p1 = Pattern.compile(pattern2);
					Matcher m2 = p1.matcher(condition);
					if (m1.find()) {
						String searchColumn = m.group();
						// System.out.println(column);
						criteria.setColumn(searchColumn);

					}

				}
			}

		}

	}
	private void orderby(String orderbyParam) {

		String pattern = "(.*)";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(orderbyParam);

		String orderbyString = null;

		if (m.find()) {
			orderbyString = m.group(1);

		}
		System.out.println(orderbyString);
		queryParameter.setOrderby(orderbyString);

	}

	
	
	

}
