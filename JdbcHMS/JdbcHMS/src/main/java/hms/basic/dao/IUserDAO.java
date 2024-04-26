package hms.basic.dao;

import java.sql.SQLException;
import java.util.List;
import hms.basic.exception.InvalidAgeException;
import hms.basic.bean.User;

public interface IUserDAO {
public int insertUser(User user)throws InvalidAgeException;
public int updateUser(User user)throws SQLException;
public int deleteUser(int id)throws SQLException;
public List<User> getAllRecords()throws SQLException;
public List<User> getAllRecordsBysize(String size)throws SQLException;
public List<User> getAllNamesSortedOrder()throws SQLException;
public boolean getUserId(int id)throws SQLException;

}


