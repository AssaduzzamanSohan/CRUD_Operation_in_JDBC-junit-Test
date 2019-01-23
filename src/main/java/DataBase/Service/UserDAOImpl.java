package DataBase.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DataBase.Dao.UserDAO;
import DataBase.dbUtil.DBConnection;
import DataBase.model.User;

public class UserDAOImpl implements UserDAO {

	@Override
	public boolean addUser(User user) {
		Connection connection = DBConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement(
					"INSERT INTO dbo.T_Employee_Details(eName, eSalary, ePassword,eID) VALUES (?,?, ?, ?)");
			// ps.setInt(0, user.getId());
			ps.setString(1, user.getName());
			ps.setInt(2, user.getSalary());
			ps.setString(3, user.getPassword());
			ps.setInt(4, user.getId());

			int i = ps.executeUpdate();
			if (i == 1) {
				return true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateUser(User user, int a) {
		Connection connection = DBConnection.getConnection();
		try {

			PreparedStatement ps = connection
					.prepareStatement("UPDATE dbo.T_Employee_Details SET eName=?, eSalary=?, ePassword=? WHERE eId=?");
			ps.setString(1, user.getName());
			ps.setInt(2, user.getSalary());
			ps.setString(3, user.getPassword());
			ps.setInt(4, a);
			int i = ps.executeUpdate();
			if (i == 1) {
				return true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteUser(int id) {
		Connection connection = DBConnection.getConnection();
		try {
			Statement stmt = connection.createStatement();
			int i = stmt.executeUpdate("DELETE FROM dbo.T_Employee_Details WHERE eId=" + id);
			if (i == 1) {
				return true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public User userFindByID(int id) {
		Connection connection = DBConnection.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM dbo.T_Employee_Details WHERE eId=" + id);
			if (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("eId"));
				user.setName(rs.getString("eName"));
				user.setPassword(rs.getString("ePassword"));
				user.setSalary(rs.getInt("eSalary"));
				return user;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
