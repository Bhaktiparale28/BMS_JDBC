 package hms.basic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hms.basic.exception.InvalidAgeException;
import hms.basic.bean.Address;
import hms.basic.bean.User;
import hms.basic.util.DBUtil;

public class UserDAO implements IUserDAO
{
 Connection con;
 PreparedStatement preparedStatement;
 Statement statement;
 String qry="";
 public int insertUser(User user)throws InvalidAgeException
 {
 int id=0,i=0;
  con=DBUtil.getConnection();
 try {
  con.setAutoCommit(false);

  //create table user(id int auto_increment primary key,name varchar(25),age int,email varchar(25),password varchar(25),addr varchar(100),MobileNumber bigint);

 qry="insert into user(NAME,AGE,EMAIL,password,addr,MobileNumber) values(?,?,?,?,?,?)";
 preparedStatement= con.prepareStatement(qry);
 preparedStatement.setString(1, user.getName());
 preparedStatement.setInt(2, user.getAge());
 preparedStatement.setString(3, user.getEmail());
 preparedStatement.setString(4, user.getpassword());
 preparedStatement.setString(5, user.getAddr());
 preparedStatement.setString(6, user.getMobileNumber());
  i=preparedStatement.executeUpdate();

 Address address=user.getAddress();
 qry="select max(id) from user";
 statement=con.createStatement();
 ResultSet rs=statement.executeQuery(qry);
 if(rs.next())
 {

  id=rs.getInt(1);

 }

 else

 {

  id=id+1;

 }

 address.setUserId(id);

 //create table address(userid int,productname varchar(25),size varchar(25),price varchar(25),color varchar(25), constraint fk_key foreign key(userid) references user(id));

 qry="insert into address(userid,productname,size,price,color) values(?,?,?,?,?)";
 preparedStatement= con.prepareStatement(qry);
 preparedStatement.setInt(1, address.getUserId());
 preparedStatement.setString(2, address.getproductname());
 preparedStatement.setString(3, address.getsize());
 preparedStatement.setString(4, address.getprice());
 preparedStatement.setString(5, address.getcolor());
 int j=preparedStatement.executeUpdate();
 if(i==1 && j==1)
 {

  con.commit();

 }

 else

 {

  con.rollback();

 }

 con.close();

 }catch (Exception e) {

  e.printStackTrace();

 }

 return i;

 }

 public boolean getUserId(int id)throws SQLException
 {

 con=DBUtil.getConnection();
 qry="select id from user where id=?";
 preparedStatement=con.prepareStatement(qry);
 preparedStatement.setInt(1, id);
 ResultSet rs=preparedStatement.executeQuery();
 if(rs.next())
 {

  return true;

 }

 else

 {

  return false;

 }

 }

 public int updateUser(User user)throws SQLException
 {
 con=DBUtil.getConnection();
 con.setAutoCommit(false);
 qry="update user set email=?,password=?,mobileNumber=?,addr=? where ID=?";
 preparedStatement= con.prepareStatement(qry);
 preparedStatement.setString(1, user.getEmail());
 preparedStatement.setString(2, user.getpassword());
 preparedStatement.setString(3, user.getMobileNumber());
 preparedStatement.setString(4, user.getAddr());
// preparedStatement.setString(5, user.getAddr());
 int i=preparedStatement.executeUpdate();

 Address address=user.getAddress();

 //System.out.println(user.getId()+" "+user.getEmail()+" "+address.getUserId()+" "+address.getproductname()+" "+address.getsize()+" "+address.getprice()+" "+address.getcolor());

 qry="update address set productname=?,size=?,price=?,color=? where USERID=?";
 preparedStatement= con.prepareStatement(qry);
 preparedStatement.setString(1, address.getproductname());
 preparedStatement.setString(2, address.getsize());
 preparedStatement.setString(3, address.getprice());
 preparedStatement.setString(4, address.getcolor());
 preparedStatement.setInt(5, address.getUserId());

 int j= preparedStatement.executeUpdate();
  if(i==1 && j>=1)
  {
  con.commit();

  }

  else

  {

  con.rollback();

  }

  con.close();

 return i;

 }

 public int deleteUser(int id)throws SQLException
 {

 con=DBUtil.getConnection();
 con.setAutoCommit(false);
 qry="delete from address where userID=?";
 preparedStatement= con.prepareStatement(qry);
 preparedStatement.setInt(1, id);
 int i=preparedStatement.executeUpdate();
 qry="delete from user where ID=?";
 preparedStatement= con.prepareStatement(qry);
 preparedStatement.setInt(1, id);
 int j=preparedStatement.executeUpdate();
 if(i>=1 && j>=1)
 {

  con.commit();

 }

 else
 {

  con.rollback();
 }

 con.close();
 return i;
 }

 public List<User> getAllRecords()throws SQLException
 {

 Statement stmt =DBUtil.getConnection().createStatement();
 qry="select user.id,user.name,user.age,"
  + "user.email,user.addr,user.password,user.mobilenumber, "
  + "addr.productname,addr.size,addr.price,"
  + "addr.color from user user join address addr on user.id=addr.userid;";
 ResultSet rs=stmt.executeQuery(qry);
 List<User> arrayList=new ArrayList<User>();
 while(rs.next())
 {
  User user=new User();
  Address address=new Address();
  user.setId(rs.getInt("ID"));
  user.setName(rs.getString("NAME"));
  user.setAge(rs.getInt("AGE"));
  user.setEmail(rs.getString("email"));
  user.setAddr(rs.getString("addr"));
  user.setpassword(rs.getString("password"));
  user.setMobileNumber(rs.getString("mobileNumber"));
  address.setproductname(rs.getString(8));
  address.setsize(rs.getString(9));
  address.setprice(rs.getString(10));
  address.setcolor(rs.getString(11));
  user.setAddress(address);
  arrayList.add(user);
 }

 return arrayList;

 }

 public List<User> getAllRecordsBysize(String size)throws SQLException

 {

 qry="select user.id,user.name,user.age,user.email,us.addr,user.password,user.mobilenumber,"
 		+ "addr.productname,addr.size,addr.price,addr.color "
 		+ "from user user join address addr where addr.size=? and user.id=addr.userid;";
 preparedStatement =DBUtil.getConnection().prepareStatement(qry);
 preparedStatement.setString(1, size);
 ResultSet rs=preparedStatement.executeQuery();
 List<User> arrayList=new ArrayList<User>();
 while(rs.next())
 {
  User user=new User();
  Address address=new Address();
  user.setId(rs.getInt("ID"));
  user.setName(rs.getString("NAME"));
  user.setAge(rs.getInt("AGE"));
  user.setEmail(rs.getString("email"));
  user.setAddr(rs.getString("Addr"));
  user.setpassword(rs.getString("password"));
  user.setMobileNumber(rs.getString("mobileNumber"));
  address.setproductname(rs.getString(8));
  address.setsize(rs.getString(9));
  address.setprice(rs.getString(10));
  address.setcolor(rs.getString(11));
  user.setAddress(address);
  arrayList.add(user);
 }

 return arrayList;

 }

 public List<User> getAllNamesSortedOrder()throws SQLException
 {

 Statement stmt =DBUtil.getConnection().createStatement();
 qry="select user.id,user.name,user.age,user.email,user.addr,user.password,user.mobilenumber,"
 		+ "addr.productname,addr.size,addr.price,addr.color from user"
 		+ " user join address addr on user.id=addr.userid order by user.name";
 ResultSet rs=stmt.executeQuery(qry);
 List<User> arrayList=new ArrayList<User>();
 while(rs.next())
 {
  User user=new User();
  Address address=new Address();
  user.setId(rs.getInt("ID"));
  user.setName(rs.getString("NAME"));
  user.setAge(rs.getInt("AGE"));
  user.setEmail(rs.getString("email"));
  user.setAddr(rs.getString("Addr"));
  user.setpassword(rs.getString("password"));
  user.setMobileNumber(rs.getString("mobilenumber"));
  address.setproductname(rs.getString(8));
  address.setsize(rs.getString(9));
  address.setprice(rs.getString(10));
  address.setcolor(rs.getString(11));
  user.setAddress(address);
  arrayList.add(user);
  }

 return arrayList;
 }

}







 