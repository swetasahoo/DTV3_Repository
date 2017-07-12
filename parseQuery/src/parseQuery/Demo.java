package parseQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter a query");
		Scanner s=new Scanner(System.in);
		String queryline=s.nextLine();
		
		
		ParsesString parseString=new ParsesString();		
		parseString.createQuery(queryline);
		/*
	      String pattern = "select (.*) from (.*)?where (.*)/*";

	      // Create a Pattern object
	      Pattern r = Pattern.compile(pattern);
	      QueryString q=new QueryString();
	      // Now create matcher object.
	      List<String> field=new ArrayList<>();
	      List<String> criteria=new ArrayList<>();
	      Matcher m = r.matcher(line);
	      if (m.find( )) {
	    	  String[] f=m.group(1).split(",");
	    	  String[] c=m.group(3).split(" ");
	    	  for(String s:f)
	    	  {
	    		  field.add(s);
	    		 System.out.println(s);
	    	  }
	    	  for(String s1:f)
	    	  {
	    		  criteria.add(s1);
	    	  }
	    	  q.setField(field);
	    	  q.setFilePath(m.group(2));
	    	  q.setCriteria(criteria);
	         System.out.println("Found value: " + m.group(1) );
	         System.out.println("Found value: " + m.group(2) );
	         System.out.println("Found value: " + m.group(3) );*/
	      
	}
	
	     

}
