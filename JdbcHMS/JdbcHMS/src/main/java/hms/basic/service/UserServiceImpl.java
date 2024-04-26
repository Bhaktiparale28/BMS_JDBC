package hms.basic.service;

import java.sql.SQLException;
import java.util.List;
import hms.basic.dao.IUserDAO;
import hms.basic.dao.UserDAO;
import hms.basic.exception.InvalidAgeException;
import hms.basic.bean.User;
public class UserServiceImpl implements IUserService
{
 IUserDAO userDAO=new UserDAO();
 public int insertUser(User user)throws InvalidAgeException
 {
 return userDAO.insertUser(user);
 }

 public int updateUser(User user)throws SQLException
 {
 return userDAO.updateUser(user);
 }

 public int deleteUser(int id)throws SQLException
 {
 return userDAO.deleteUser(id);
 }

 public List<User> getAllRecords()throws SQLException
 {
 return userDAO.getAllRecords();
 }

 public List<User> getAllRecordsBysize(String size)throws SQLException
 {
 return userDAO.getAllRecordsBysize(size);
 }

 public List<User> getAllNamesSortedOrder()throws SQLException
 {
 return userDAO.getAllNamesSortedOrder();
 }

 public boolean getUserId(int id)throws SQLException
 {
 return userDAO.getUserId(id);
 }

}










