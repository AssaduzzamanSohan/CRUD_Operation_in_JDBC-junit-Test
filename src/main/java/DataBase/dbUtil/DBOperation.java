package DataBase.dbUtil;

import DataBase.Service.UserDAOImpl;
import DataBase.dbUtil.*;
import DataBase.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DBOperation {
	

	public static boolean Create() {
		Connection connection =  DBConnection.getConnection();
		try {
			System.out.println("Creating table in given database...");
			 Statement stmt = connection.createStatement();
		      
		    String sql = "CREATE TABLE T_Employee_Details" +
		                 "(eId INTEGER not NULL, " +
		                 " eName VARCHAR(255), " + 
		                 " eSalary INTEGER, " +                    
		                 " ePassword VARCHAR(255), " + 
		                 " PRIMARY KEY ( eId ))"; 

		    stmt.executeUpdate(sql);
		    return true;
		}
		catch(Exception e) {
			log.error("Connection error: " + e.getMessage());
		}
		return false;
		
	}
	
	
	public static int FindMaxSalary() {
		Connection connection =  DBConnection.getConnection();
		int max=0,x;
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM dbo.T_Employee_Details");
			while (rs.next()) {
				x = rs.getInt("eSalary");
				if(x>max) max=x;
			}
			return max;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return max;
	}
	
	public static int FindMinSalary() {
		Connection connection =  DBConnection.getConnection();
		int min=999999999,x;
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM dbo.T_Employee_Details");
			while (rs.next()) {
				x = rs.getInt("eSalary");
				if(x<min) min=x;
			}
			return min;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return min;
	}
	
	public static int FindAvgSalary() {
		Connection connection =  DBConnection.getConnection();
		int sum=0,x=0;
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM dbo.T_Employee_Details");
			while (rs.next()) {
				sum += rs.getInt("eSalary");
				x++;
			}
			return sum/x;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return sum/x;
	}
	
	public static int FindSecondMaxSalary() {
		Connection connection =  DBConnection.getConnection();
		
		int max = FindMaxSalary();
		
		int second_max=0,x;
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM dbo.T_Employee_Details");
			while (rs.next()) {
				x = rs.getInt("eSalary");
				if(x<max && x>second_max) second_max=x;
			}
			return second_max;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return second_max;
	}
	
	public static int useOfLIKE() throws SQLException { // start with s
		Connection connection =  DBConnection.getConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM dbo.T_Employee_Details WHERE eName LIKE 's%'");
		int x=0;
		while (rs.next()) {
			x++;
		}
		return x;
	}
	
	public static int useOfWildCard() throws SQLException { // start any char a to y
		Connection connection =  DBConnection.getConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM dbo.T_Employee_Details WHERE eName LIKE '[a-y]%'");
		int x=0;
		while (rs.next()) {
			x++;
		}
		return x;
	}
	
//	public static void main(String[] args) throws SQLException {
//		Connection connection =  DBConnection.getConnection();
//		
//		System.out.println("connection Catalog==="+connection.getCatalog()+"\n");
//		System.out.println("getClass==="+connection.getClass()+"\n");
//		System.out.println("getMetaData==="+connection.getMetaData()+"\n");
//
//		//Create();
//		
//		UserDAOImpl uDAOi = new UserDAOImpl();
//		
//		User user1 = new User(10,"Sohan", 10000, "password123");
//		User user2 = new User(2,"Tonmoy", 10000, "password12");
//		User user3 = new User(3,"Tanbir", 10000, "password1");
//		User user1_change = new User("Sohan", 100, "password");
//		uDAOi.addUser(user1);
//		uDAOi.addUser(user2);
//		uDAOi.addUser(user3);
//		uDAOi.updateUser(user1_change, 1);
//		uDAOi.deleteUser(1);
//		
//		User us = uDAOi.userFindByID(1);
//		//System.out.println(us.getId()+" "+us.getName()+" "+us.getSalary()+" "+us.getPassword());
//	}

	


}
