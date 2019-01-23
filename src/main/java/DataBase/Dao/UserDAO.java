package DataBase.Dao;

import DataBase.model.User;

public interface UserDAO {

	boolean addUser(User user);
	boolean deleteUser(int a);
	boolean updateUser(User user,int a);
	User userFindByID(int a);
}
