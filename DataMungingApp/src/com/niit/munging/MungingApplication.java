package com.niit.munging;

import java.util.Scanner;



public class MungingApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter a query");
		Scanner s=new Scanner(System.in);
		String queryline=s.nextLine();
		
		
		QueryParser queryParser=new QueryParser();		
		
		queryParser.createQuery(queryline);
	}

}
