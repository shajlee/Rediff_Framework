package com.qa.rediff.utilities;

import java.util.Date;

public class Utilities_Rediff {

	public static String generateDateTimeStampEmail() {
		Date date = new Date();
		String timeStamp = date.toString().replace(" ", "_").replace(":", "_");
		return "chowdhurygs" +timeStamp+ "@rediffmail.com";
	}
	public static CharSequence generateDateTimeStampPassword() {
		Date date1 = new Date();
		String timeStamp1 = date1.toString().replace(" ", "_").replace(":", "_" );
		return "Shajlee" +timeStamp1+ "1@";
	}
	public static final int IMPLICIT_WAIT_TIME = 10;
	public static final int PAGELOAD_TIME = 10;
	
		
		
		
		
		
		
		

	}


