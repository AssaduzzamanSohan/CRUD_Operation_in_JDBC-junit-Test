package DataBase.DataBase;


import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import DataBase.Service.UserDAOImpl;
import DataBase.dbUtil.DBConnection;
import DataBase.dbUtil.DBOperation;
import DataBase.model.User;


public class DataBaseTest {
	UserDAOImpl uDAOi = new UserDAOImpl();
	
	
	Connection connection =  DBConnection.getConnection();
    
	@Test
	public void Connectiontest() throws SQLException {
		String str = "DEV_TEST";
		assertEquals(str, connection.getCatalog()); // We can get DataBase name if and only if we get Connecter with DataBase
	}
	@Test
	public void testAddUser() {
		User user1 = new User(1,"Sohan", 100, "password123"); // existing user
		User user2 = new User(15,"Boss", 10, "passw"); // new user: give a unique ID 
		assertFalse(uDAOi.addUser(user1));
		assertTrue(uDAOi.addUser(user2));
	}

	@Test
	public void testUpdateUser() {
		User user1 = new User("Sohan", 10000, "nai");
		assertTrue(uDAOi.updateUser(user1, 1)); // give id of a existing user 
	}

	@Test
	public void testDeleteUser() {
		assertTrue(uDAOi.deleteUser(10)); // give id of a existing user 
	}

	@Test
	public void testUserFindByID() {
		assertNotNull(uDAOi.userFindByID(1)); // give id of a existing user 
		assertNull(uDAOi.userFindByID(10000)); // give a unique ID
	}
	
	
	
	@Test
	public void testFindMaxSalary() {
		int x=DBOperation.FindMaxSalary();
		assertEquals(10000000, x); // Giving 10000000 by checking, this is the maximum value in database
	}

	@Test
	public void testFindMinSalary() {
		int x=DBOperation.FindMinSalary();
		assertEquals(10, x); // Giving 10 by checking, this is the minimum value in database
	}

	@Test
	public void testFindAvgSalary() {
		int x=DBOperation.FindAvgSalary();
		assertEquals(627768, x); // Giving 627768 by checking, this is the average salary value in database
	}

	@Test
	public void testFindSecondMaxSalary() {
		int x=DBOperation.FindSecondMaxSalary();
		assertEquals(1000000, x); // Giving 1000000 by checking, this is the second maximum value in database
	}

	@Test
	public void testUseOfLIKE() throws SQLException {  // start with s
		int x=DBOperation.useOfLIKE();
		assertEquals(12, x); // Giving 12 by counting, number of eName starts with s is 12
	}

	@Test
	public void testUseOfWildCard() throws SQLException { // start any char a to y
		int x=DBOperation.useOfWildCard();
		assertEquals(18, x); // Giving 18 by counting, number of eName starts with a to y is 18
	}

	
}
