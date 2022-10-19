package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.User;

public class UserDaoImpl implements UserDao{

	public List<User> viewUser() throws ClassNotFoundException, SQLException {
		ArrayList<User>userList=new ArrayList<User>();
		Class.forName("com.mysql.jdbc.Driver");//load the driver
		//create the connection 
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/hibernatedb","Anjali","Anjali@8910");
		
		//create the statement
		PreparedStatement statement =con.prepareStatement("select * from user");
		ResultSet rs=statement.executeQuery();
		
		while(rs.next())
		{
			User u=new User();
			
			System.out.println(" ");
			u.setUserId(rs.getInt(1));
			u.setUserName(rs.getString(2));
			u.setPassword(rs.getString(3));
			userList.add(u);
		
	}
		return userList;
	}

	public void insertNewUser(User u) throws ClassNotFoundException, SQLException {
		int row=0;
		Class.forName("com.mysql.jdbc.Driver");//load the driver
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/hibernatedb","Anjali","Anjali@8910");
		PreparedStatement statement =con.prepareStatement("insert into user values(?,?,?)");
		statement.setInt(1, u.getUserId());
		statement.setString(2, u.getUserName());
		statement.setString(3, u.getPassword());
		
		row=statement.executeUpdate();
		
	}

	public void updateUser(User u) throws ClassNotFoundException, SQLException {
		int row=0;
		Class.forName("com.mysql.jdbc.Driver");//load the driver
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/hibernatedb","Anjali","Anjali@8910");
		PreparedStatement statement =con.prepareStatement("update user set username=?,password=? where userid=?");
		;
		statement.setString(1, u.getUserName());
		statement.setString(2, u.getPassword());
		statement.setInt(3, u.getUserId());
		row=statement.executeUpdate();
		
	}

	public void deleteUser(User u) throws ClassNotFoundException, SQLException {
		int row=0;
		Class.forName("com.mysql.jdbc.Driver");//load the driver
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/hibernatedb","Anjali","Anjali@8910");
		PreparedStatement statement =con.prepareStatement("delete from user where userid=?");
		
		
		statement.setInt(1, u.getUserId());
		row=statement.executeUpdate();
		
	}

}
