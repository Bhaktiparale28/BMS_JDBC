package hms.basic.main;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import hms.basic.exception.InvalidAgeException;
import hms.basic.bean.Address;
import hms.basic.bean.User;
import hms.basic.service.IUserService;
import hms.basic.service.UserServiceImpl;
import hms.basic.util.Validation;

public class Boutique {
	 public static void main(String[] args) throws Exception {
	 int id,age,choice;
	 String name,email,password,mobileNumber,productname,price,size,color,addr;
	Address address;
	 List<User> list;
	 Scanner in = new Scanner(System.in);
	 Scanner str = new Scanner(System.in);
	 while(true)

	 {
	  System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=- ");
	  System.out.println("               @:@:@:  WELCOME TO   :@:@:@:                 ");
	  System.out.println("          @@@    BOUTIQUE MANAGEMENT SYSTEM    @@@  ");
	  System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=- ");
	  System.out.println("Enter the Details for Your Dress Booking. ");
	  System.out.println("____________________________________________________________");
	  System.out.println("1. Insert New Order");
	  System.out.println("2. Modify the Existing Order");
	  System.out.println("3. Delete the Existing Order");
	  System.out.println("4. Show Existing Order");
	  System.out.println("5. Exit");
	  System.out.println("6. Sort data ByName");
	  System.out.println("7. Display Data By size");
	  System.out.print("Enter a choice: ");
	  choice = in.nextInt();
	  User user=new User();
	  IUserService userService=new UserServiceImpl();
	  int res=0;
	  System.out.println("----------------------------------------------------------------");
	  switch(choice){
	  case 1:
	  System.out.println("1. Insert New Data");
	  System.out.println("Enter Your Name : ");
	  name=str.nextLine();
	  System.out.println("Enter Your Age : ");
	  age=in.nextInt();
	  System.out.println("Enter Your Email : ");
	  email=str.nextLine();
	  System.out.println("Enter Your Address : ");
	  addr=str.nextLine();
	  System.out.println("Enter Your Password : ");
	  password=str.nextLine();
	  System.out.println("Enter Your Mobile Number :");
	  mobileNumber= str.nextLine();
	  System.out.println("Enter Your Product name :");
	  productname=str.nextLine();
	  System.out.println("Enter Your Size [S/M/L/XL/XXL]:");
	  size=str.nextLine();
	  System.out.println("Enter Your Price :");
	  price=str.nextLine();
	  System.out.println("Enter Your Color :");
	  color=str.nextLine();
	  int error=0;
	    if (name.matches(Validation.regularExpression)) {

	     user.setName(name);

	    } else {

	    error++;

	    System.out.println("Please Enter Proper Name");

	      }

	    if (String.valueOf(age).matches(Validation.ageExpression)) {
	      if (age<=0 || age>130) {

	       error++;

	       try {

	       throw new InvalidAgeException("Age Should Not Be More than 130 years or Negative Number Or Zero");

	    } catch (InvalidAgeException e) {

	    System.out.println(e.getMessage());

	    }

	      }

	      else

	      {

	       user.setAge(age);

	      }

	    } else {

	     System.out.println("Please Enter Proper Age");
	     error++;

	    }

	  if (email.matches(Validation.regxEmail)) {
	  user.setEmail(email);

	    } else {

	     System.out.println("Please Enter Proper Email");
	     error++;

	      }
	  if (addr.matches(Validation. addrExpression )) {
	
		  user.setAddr(addr);

		    } else {

		     System.out.println("Please Enter Proper Address");
		     error++;

		      }
	  
	  if (password.matches(Validation.regxPass)) {
		  
		  user.setpassword(password);

		    } else {

		     System.out.println("Please Enter Proper Password ");
		     error++;

		      }

	  if (mobileNumber.matches(Validation.MobileNum)) {
		  user.setMobileNumber(mobileNumber);

		    } else {

		     System.out.println("Mobile Number Should be of 10 digits only!! ");
		     error++;

		      }

	  address=new Address();
	 if(productname.matches(Validation.regxProductName))
	 {
	  address.setproductname(productname);
	 }
	 else
	 {
	  System.out.println("Please Enter Proper Product Name");
	  error++;
	 }

	 if(size.matches(Validation.regularExpression))

	 {
	  address.setsize(size);
	   }
	 else
	 {
	  System.out.println("Please Enter Proper size [S/M/L/XL/XXL]");
	  error++;
	 }

	 if(price.matches(Validation.MobileNum))
	 {
	  address.setprice(price);
	 }
	 else
	 {
	  System.out.println("Please Enter Proper Price in digits");
	  error++;
	 }
	 if(color.matches(Validation.regularExpression))
	 {
	  address.setcolor(color);
	 }
	 else
	 {
	  System.out.println("Please Enter Proper Color");
	  error++;
	 }
	 user.setAddress(address);
	 //address=user.getAddress();
	  if(error>0)
	  {
	   //System.out.println("Please Enter Proper Data");
	  }
	  else {
	  res=userService.insertUser(user);
	  }
	  if(res==1) {
	  System.out.println("Data Inserted Successfully");
	  }
	  break;
	  case 2:
	  System.out.println("2. Updating the Order");
	  System.out.println("Enter ID : ");
	  id=in.nextInt();
	  boolean b=userService.getUserId(id);
	  if(b) {
	  System.out.println("Enter Email : ");
	  email=str.nextLine();
	  System.out.println("Enter Password : ");
	  password=str.nextLine();
	  System.out.println("Enter Your Mobile Number : ");
	  mobileNumber=str.nextLine();
	  System.out.println("Enter Product Name :");
	  productname=str.nextLine();
	  System.out.println("Enter Size [S/M/L/XL/XXL] :");
	  size=str.nextLine();
	  System.out.println("Enter Price :");
	  price=str.nextLine();
	  System.out.println("Enter Color :");
	  color=str.nextLine();
	  int updateError=0;
	  address=new Address();
	  address.setUserId(id);
	  if(email.matches(Validation.regxEmail))
	  {
	   user.setEmail(email);
	  }
	  else
	  {
	   System.out.println("Please Enter Proper Email");
	   updateError++;
	  }
	  if(password.matches(Validation.regxPass))
	  {
	   user.setEmail(password);
	  }
	  else
	  {
	   System.out.println("Please Enter Proper password ");
	   updateError++;
	  }
	  if (mobileNumber.matches(Validation.MobileNum)) {
		  user.setMobileNumber(mobileNumber);
		    } else {
		     System.out.println("Mobile Number Should be of 10 digits only!! ");
		     updateError++;
		      }
	  if(productname.matches(Validation.regularExpression))
	   {address.setproductname(productname);
	   }
	  else
	  {
	   System.out.println("Please Enter Proper Product Name");
	   updateError++;
	  }
	  if(size.matches(Validation.regularExpression))
	  {
	  address.setsize(size);
	  }
	  else
	  {
	   System.out.println("Please Enter Proper Size [S/M/L/XL/XXL]");
	   updateError=5;
	  }
	  if(price.matches(Validation.MobileNum))
	  {
	  address.setprice(price);
	  }
	  else
	  {
	   System.out.println("Please Enter Proper price in digits");
	   updateError++;
	  }
	  if(color.matches(Validation.regularExpression))
	  {
	   address.setcolor(color);
	  }
	  else
	  {System.out.println("Please Enter Proper color");
	   updateError++;
	  }
	  user.setId(id);
	  user.setAddress(address);
	  if(updateError>0)
	  {
	   //System.out.println("Please Enter Proper Data");
	  }
	  else {
	   res=userService.updateUser(user);
	   }					
	   if(res==1) {
	  System.out.println("Order Updated Successfully");
	   }
	  }
	  else
	  {
	   System.out.println("Please Enter Id Which is in DataBase");
	  }
	  break;
	  case 3:
	  System.out.println("3. Deleting a Data");
	  System.out.println("Enter ID : ");
	  id=in.nextInt();
	  b=userService.getUserId(id);
	  if(b) {
	  res=userService.deleteUser(id);
	  if(res==1) {
	  System.out.println("Data Deleted Successfully");
	  }
	  }else
	  {
	   System.out.println("Please Enter Id Which is in the DataBase");
	  }
	  break;
	  case 4:
	  System.out.println("4. Display all Orders");
	   list= userService.getAllRecords();
	   System.out.println("Id"+"  "+"Name"+"  "+"Age"+"  "+"Email"+"  "+"Address"+"  "+"Password"+"  "+"Mobile number"+"  "+"Productname"+"  "+"size"+"  "+"price"+"  "+"color");
	   System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------");


	   for(User us:list)
	  {
	   address= us.getAddress();
	   System.out.println(us.getId()+" "+us.getName()+"  "+us.getAge()+"  "+us.getEmail()+"  "+us.getAddr()+" "+us.getpassword()+"  "+us.getMobileNumber()+"  "+address.getproductname()+"  "+address.getsize()+"  "+address.getprice()+"  "+address.getcolor());
	  }
	  break;
	  case 5:
	  System.out.println("Thank You");
	  System.exit(0);
	  break;
	  case 6:
	  System.out.println("6. Display all Records in Sorting Order By Name");
	  list= userService.getAllNamesSortedOrder();
	  System.out.println("Id"+"  "+"Name"+"  "+"Age"+"  "+"Email"+"  "+"Address"+" "+"Password"+"  "+"mobilenumber"+"  "+"Productname"+"  "+"size"+"  "+"price"+"  "+"color");
	  System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
	  for(User us:list)
	  {
	   address= us.getAddress();
	   System.out.println(us.getId()+" "+us.getName()+" "+us.getAge()+" "+us.getEmail()+" "+us.getAddr()+"  "+us.getpassword()+"  "+us.getMobileNumber()+" "+address.getproductname()+" "+address.getsize()+" "+address.getprice()+" "+address.getcolor());
	  }
	  break;
	  case 7:
	  System.out.println("Enter size : ");
	  size=str.nextLine();
	  System.out.println("7. Display all Records By size");
	  list= userService.getAllRecordsBysize(size);
	  System.out.println("Id"+"  "+"Name"+" "+"Age"+"  "+"Email"+"  "+"Address"+"  "+"password"+"  "+"mobilenumber"+"  "+"\tproductname"+"  "+"size"+"  "+"price"+"  "+"color");
	  System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------");

	  for(User us:list)
	   {
	   address= us.getAddress();
	   System.out.println(us.getId()+" "+us.getName()+" "+us.getAge()+" "+us.getEmail()+" "+us.getAddr()+"  "+us.getpassword()+" "+us.getMobileNumber()+" "+address.getproductname()+" "+address.getsize()+" "+address.getprice()+" "+address.getcolor());
	   }
	  break;
	  default:
	  System.out.println("Invalid Selection");
	  break;
	  }
	  System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
	 }

	 }

	} 
