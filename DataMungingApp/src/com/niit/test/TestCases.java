package com.niit.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.niit.munging.QueryParser;
import com.niit.munging.QueryParameter;



public class TestCases {

	@Test
	public void createSelectColumnListTestCase()
	{
	
	List<String> expected=new ArrayList<>();
	expected.add("a");
	expected.add("b");
	
			
	QueryParser parsesString=new QueryParser();
	QueryParameter queryParameter=parsesString.createQuery("select a,b,c from d:\\DTV3\\c.csv");
	
	
	List<String> actual= queryParameter.getFields();
  
	//Assert.assertEquals("test succeded",actual,columnlist);
	Assert.assertEquals("test succeded", expected, actual);
	
	
	}
	
	@Test
	public void createAllColumnListTestCase()
	{
	List<String> expected=new ArrayList<>();
	expected.add(" * ");
		
	QueryParser parsesString=new QueryParser();
	QueryParameter queryParameter=parsesString.createQuery("select * from d:\\DTV3\\c.csv");
	List<String> actual= queryParameter.getFields();
  
	//Assert.assertEquals("test succeded",actual,columnlist);
	Assert.assertEquals("test succeded", expected, actual);

	}
	
	@Test
	public void createwherClauseTestCase()
	{
	String expected="a>10";
		
	QueryParser parsesString=new QueryParser();
	QueryParameter queryParameter=parsesString.createQuery("select * from d:\\DTV3\\c.csv where a>10");
	
	String actualexpression=queryParameter.getExpressions();

	//Assert.assertEquals("test succeded",actual,columnlist);
	Assert.assertEquals("test succeded", expected, actualexpression);

	}
}
