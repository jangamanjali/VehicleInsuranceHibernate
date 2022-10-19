package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Insurance;
import com.entity.User;

public class InsuranceDaoImpl implements InsuranceDao
{

	public List<Insurance> viewInsuranceDetails() throws ClassNotFoundException, SQLException {
	
		ArrayList<Insurance>insuranceList=new ArrayList<Insurance>();
		Class.forName("com.mysql.jdbc.Driver");//load the driver
		//create the connection 
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/hibernatedb","Anjali","Anjali@8910");
		
		PreparedStatement statement =con.prepareStatement("select * from insurance");
		ResultSet rs=statement.executeQuery();
		
		while(rs.next())
		{
			Insurance i=new Insurance();
			i.setId(rs.getInt(1));
			System.out.println(" ");
			i.setInsuranceProvider(rs.getString(2));
			i.setInsuranceNumber(rs.getLong(3));//ValidDate
			i.setValidDate(rs.getString(4));
			insuranceList.add(i);
		
	}
		return insuranceList;
	}

	public void insertInsuranceDetails(Insurance i) throws ClassNotFoundException, SQLException {
		int row=0;
		Class.forName("com.mysql.jdbc.Driver");//load the driver
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/hibernatedb","Anjali","Anjali@8910");
		PreparedStatement statement =con.prepareStatement("insert into insurance values(?,?,?,?)");
		statement.setInt(1, i.getId());
		statement.setString(2, i.getInsuranceProvider());
		statement.setLong(3, i.getInsuranceNumber());
		statement.setString(4, i.getValidDate());
		
		row=statement.executeUpdate();
		
	}

	public void updateInsurance(Insurance i) throws ClassNotFoundException, SQLException {
		int row=0;
		Class.forName("com.mysql.jdbc.Driver");//load the driver
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/hibernatedb","Anjali","Anjali@8910");
		PreparedStatement statement =con.prepareStatement("update insurance set insuranceProvider=?,insuranceNumber=?,validDate=? where id=?");
		
		statement.setString(1, i.getInsuranceProvider());
		statement.setLong(2, i.getInsuranceNumber());
		statement.setString(3, i.getValidDate());
		statement.setInt(4, i.getId());
		row=statement.executeUpdate();
		
	}

	public void deleteInsurance(Insurance i) throws ClassNotFoundException, SQLException {
		int row=0;
		Class.forName("com.mysql.jdbc.Driver");//load the driver
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/hibernatedb","Anjali","Anjali@8910");
		PreparedStatement statement =con.prepareStatement("delete from insurance where id=?");
		
		
		statement.setInt(1, i.getId());
		row=statement.executeUpdate();
		
	}

	/*public void search(User userid) throws ClassNotFoundException, SQLException {
		int row=0;
		Class.forName("com.mysql.jdbc.Driver");//load the driver
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/hibernatedb","Anjali","Anjali@8910");
		PreparedStatement statement =con.prepareStatement("select * from UserData where userid=?");
		
		
		statement.setInt(1, userid.getUserId());
		statement.setString(1, userid.getUserName());
		statement.setString(1, userid.getPassword());
		
		row=statement.executeUpdate();
		
	}*/

	
}
