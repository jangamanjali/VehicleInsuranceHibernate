package com.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.dao.InsuranceDaoImpl;
import com.dao.UserDaoImpl;
import com.entity.Insurance;
import com.entity.User;


public class InsuranceService {
	public void viewInsuranceDetails() throws ClassNotFoundException, SQLException
	{
		List<Insurance>insuranceList=new  InsuranceDaoImpl().viewInsuranceDetails();
		for(Insurance i:insuranceList)
		{
			System.out.println("\n=============================User Data================");
			System.out.print(i.getId());
			System.out.println(" ");
			System.out.print(i.getInsuranceProvider());
			System.out.println(" ");
			System.out.print(i.getInsuranceNumber());
			System.out.println(" ");
			System.out.print(i.getValidDate());
		}
	}
	
	public void insertInsuranceDetails() throws ClassNotFoundException, SQLException
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the Insurance id");
		int id=sc.nextInt();
		System.out.println("enter the Insurance Provider Name");
		String insuranceprovider=sc.next();
		System.out.println("enter the Insurance Number");
		Long insurancenumber=sc.nextLong();
		System.out.println("enter the Validity Date");
		String validdate=sc.next();
		
		
		Insurance i=new Insurance();
		i.setId(id);
		i.setInsuranceProvider(insuranceprovider);
		i.setInsuranceNumber(insurancenumber);
		i.setValidDate(validdate);
		new InsuranceDaoImpl().insertInsuranceDetails(i);
	}

	public void UpdateInsurance() throws ClassNotFoundException, SQLException
	{
		Scanner sc=new Scanner(System.in);
		
		
		System.out.println("Enter the Insurance Provider Name");
		String insuranceProvider=sc.next();
		System.out.println("Enter the Insurance Number");
		long insuranceNumber=sc.nextLong();
		System.out.println("Enter the Validity Date");
		String validDate=sc.next();
		System.out.println("enter the Insurance Id");
		int id=sc.nextInt();
		
		
		
		Insurance i=new Insurance();
		i.setId(id);
		i.setInsuranceProvider(insuranceProvider);
		i.setInsuranceNumber(insuranceNumber);
		i.setValidDate(validDate);
	
		new InsuranceDaoImpl().updateInsurance(i);
	}
	
	
	public void deleteInsurance() throws ClassNotFoundException, SQLException
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Insurance Id");
		int id=sc.nextInt();
		
		Insurance i = new Insurance();
		i.setId(id);
		new InsuranceDaoImpl().deleteInsurance(i);
	}

	/*public void search() throws ClassNotFoundException, SQLException {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the userid");
		int userid=sc.nextInt();
		
		List<Insurance>insuranceList=new  InsuranceDaoImpl().viewInsuranceDetails();
		for(Insurance i:insuranceList)
		{
		System.out.print(i.getId());
		System.out.println(" ");
		System.out.print(i.getInsuranceProvider());
		System.out.println(" ");
		System.out.print(i.getInsuranceNumber());
		}
		/*Insurance i = new Insurance();
		i.setId(id);
		new InsuranceDaoImpl().viewInsuranceDetails();
	}*/
}
