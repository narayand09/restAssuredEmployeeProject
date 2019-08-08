package com.employeeapi.utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {
	
	public static String empname()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(3);
		return ("Piyush"+generatedString);
	}
	
	public static String empsal()
	{
		String generatedString=RandomStringUtils.randomNumeric(5);
		return (generatedString);
	}

	public static String empage()
	{
		String generatedString=RandomStringUtils.randomNumeric(2);
		return (generatedString);
	}
}
