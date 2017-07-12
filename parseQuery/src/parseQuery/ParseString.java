package parseQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseString {

	QueryParameter queryParameter;

	public ParseString() {
		queryParameter = new QueryParameter();
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

	public void queryWhereClause(String param) {
		String pattern = "(.*)";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(param);

		String criteria = null;

		if (!(param.contains("group by")) && !(param.contains("order by"))) {
			if (m.find()) {
				criteria = m.group(1);

			}
			System.out.println("condition:" + criteria);

			List<String> criterialist = new ArrayList<>();
			criterialist.add(criteria);
			//queryParameter.setCriteria(criterialist);

			for (String expression : criterialist) {
				// System.out.println(c);
				if (!(expression.equals("and") || expression.equals("or"))) {
					String pattern1 = "(([A-Z])\\w+)$";
					Pattern p = Pattern.compile(pattern);
					Matcher m1 = p.matcher(expression);
					if (m.find()) {
						String value = m.group();
						// System.out.println(column);
					}
					String pattern2 = "(([A-Z])\\w+)";
					Pattern p1 = Pattern.compile(pattern1);
					Matcher m2 = p1.matcher(expression);
					if (m1.find()) {
						String column = m.group();
						// System.out.println(column);
					}

				}

			}

		} 
		if (param.contains("order by")) {
			String pattern1 = "(.*)";
			Pattern p1 = Pattern.compile(pattern1);
			Matcher m1 = r.matcher(param);
			if (m1.find()) {
				criteria = m1.group(1);
			}
			System.out.println("condition:" + criteria);
			String[] groupby = param.split("group by");

			ParseString.groupby(groupby[1]);

			if (groupby[1].contains("having")) {
				String[] having = groupby[1].split("having");
				ParseString.havingclause(having[1]);
			}
		}

	}

	public static void groupby(String param) {
		String pattern = "(.*)";

		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(param);
		String groupby = null;
		if (m.find()) {
			groupby = m.group(1);
		}
		System.out.println("group by:" + groupby);

	}

	public static void havingclause(String param) {
		String pattern = "(.*)";

		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(param);
		String having = null;
		if (m.find()) {
			having = m.group(1);
		}
		System.out.println("having clause:" + having);

	}
}
