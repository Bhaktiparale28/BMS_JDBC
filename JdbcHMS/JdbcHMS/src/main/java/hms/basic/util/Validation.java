package hms.basic.util;

public class Validation {
//public static final String regularExpression = "^[A-Za-z]{2,29}$";
//public static final String regularExpression = "^[\\p{L} .'-]+$";
public static final String regularExpression ="^[A-Za-z]{1,}[\\.]{0,1}[\\s]{0,1}[A-Za-z]{0,}[\\s]{0,1}[A-Za-z]{0,}$";
public static final String rgExpression="/^(\\d{1,}) [a-zA-Z0-9\\s]+(\\,)? [a-zA-Z]+(\\,)? [A-Z]{2}[0-9]{5,6}$/\r\n";
public static final String ageExpression="^[0-9]{1,3}$";
public static final String regxEmail="^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
	      + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
public static final String roomExpression ="^[A-Za-z]{1,}[\\\\.]{0,1}[\\\\s]{0,1}[A-Za-z]{0,}[\\\\s]{0,1}[A-Za-z_-]{0,}$";
public static final String MobileNum="^\\d[0-9]{1,10}$";
public static final String regxPass="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#!$%^&+=])(?=\\S+$).{8,20}$";
public static final String regxProductName="^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$";
public static final String addrExpression =   "^[A-Za-z]{1,}[\\.]{0,1}[\\s]{0,1}[A-Za-z]{0,}[\\s]{0,1}[A-Za-z]{0,}$";                //"^[A-Za-z0-9'\\\\.\\\\-\\\\s,]\r\n";
	
		
	
		
		


}



