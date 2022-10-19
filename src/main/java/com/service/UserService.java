package com.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.dao.UserDaoImpl;
import com.entity.User;

public class UserService {
	public void viewData() throws ClassNotFoundException, SQLException
	{
		List<User>userlist=new  UserDaoImpl().viewUser();
		for(User u:userlist)
		{
			System.out.println("\n=============================User Data================");
			System.out.print(u.getUserId());
			System.out.println(" ");
			System.out.print(u.getUserName());
			System.out.println(" ");
			System.out.print(u.getPassword());
			
			
		}
	}
	
	public void insertUser() throws ClassNotFoundException, SQLException
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the userid");
		int userid=sc.nextInt();
		System.out.println("enter the username");
		String username=sc.next();
		System.out.println("enter the password");
		String password=sc.next();
		
		User u=new User();
		u.setUserId(userid);
		u.setUserName(username);
		u.setPassword(password);
		new UserDaoImpl().insertNewUser(u);
	}

	public void UpdateUser() throws ClassNotFoundException, SQLException
	{
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Username");
		String username=sc.next();
		System.out.println("Enter the Password");
		String password=sc.next();
		System.out.println("enter the userid");
		int userid=sc.nextInt();
		
		User u=new User();
		u.setUserName(username);
		u.setPassword(password);
		u.setUserId(userid);
		new UserDaoImpl().updateUser(u);
	}
	
	
	public void deleteUser() throws ClassNotFoundException, SQLException
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the userid");
		int userid=sc.nextInt();
		
		User u=new User();
		u.setUserId(userid);
		new UserDaoImpl().deleteUser(u);
	}


}
