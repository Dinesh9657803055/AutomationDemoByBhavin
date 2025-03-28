package Utility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Util {

	public static String randomAlphanumericString(int length) {
	    String alphanumericCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuv";
	 
	    StringBuffer randomString = new StringBuffer(length);
	    Random random = new Random();
	 
	    for (int i = 0; i < length; i++) {
	        int randomIndex = random.nextInt(alphanumericCharacters.length());
	        char randomChar = alphanumericCharacters.charAt(randomIndex);
	        randomString.append(randomChar);
	    }
	 
	    return randomString.toString();//random comment
	}
	
	
	public static String randomProductString()
	{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd_MM_yyHHmmss");
		String date = simpleDateFormat.format(new Date());
		return   "Product_"+ date;
	}
	
	public static String randomOrderString()
	{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd_MM_yyHHmmss");
		String date = simpleDateFormat.format(new Date());
		return   "AddressOne_"+ date;  
		
	}
}
