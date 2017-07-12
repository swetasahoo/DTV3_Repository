package com.niit.munging;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class QueryParser {
	QueryParameter queryParameter;

	public QueryParser() {
		queryParameter = new QueryParameter();
	}

	public QueryParameter createQuery(String queryline) {
		
		String splitQuery[];
		if (queryline.contains("where")) 
		{
			splitQuery = queryline.split("where");
			 return this.whereClause(splitQuery[1]);

				
		}
		
			return this.querySelectToFrom(queryline);
		
	
		
	
		
	}

	public QueryParameter querySelectToFrom(String parameter) {

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
					fieldlist.add(field.trim());

				}

			}

			filename = m.group(2);

		
			queryParameter.setFields(fieldlist);
			queryParameter.setFilePath(filename.trim());
		
		}
		return  queryParameter;
	}

	public QueryParameter whereClause(String whereParam) {
		// TODO Auto-generated method stub

		String pattern = "(.*\\S)";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(whereParam);


		String whereString = null;
		//Criteria criteria = new Criteria();

		if (m.find()) {
			whereString = m.group(1);
			
			queryParameter.setExpressions(whereString.trim());

		}
		return queryParameter;

	}

	private void groupbyClause(String groupByParam) {
		String pattern = "(.*)";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(groupByParam);

		String groupByString = null;

		if (m.find()) {
			groupByString = m.group(1);

		}

		System.out.println(groupByString);
		queryParameter.setHaving(groupByString);

	}

	private void havingClause(String havingParam) {
		// TODO Auto-generated method stub

		String pattern = "(.*)";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(havingParam);

		String havingString = null;

		if (m.find()) {
			havingString = m.group(1);

		}
System.out.println(havingString);
		queryParameter.setHaving(havingString);

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
