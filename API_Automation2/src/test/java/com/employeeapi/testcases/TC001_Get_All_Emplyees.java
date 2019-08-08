package com.employeeapi.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC001_Get_All_Emplyees extends TestBase {
	
	@BeforeClass
	public void getAllEmployees()
	{
		logger.info("***************  Started TC001_Get_All_Emplyees**************");
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httpRequest=RestAssured.given();
		response=httpRequest.request(Method.GET,"/employees");
		
	}
	
	@Test
	public void checkResponseBody()
	{
		logger.info("*************** Checking Response Body**************");
		String responseBody=response.getBody().asString();
		logger.info("Response Body-->"+responseBody);
		Assert.assertTrue(responseBody!=null);
	}
	
	@Test
	public void checkStatusCode()
	{
		logger.info("*************** Checking Status Code**************");
		int statuscode=response.getStatusCode();
		logger.info("Status Code is -->"+statuscode);
		Assert.assertEquals(statuscode, 200);
	}
	
	
	@Test
	public void checkResponseTime()
	{
		logger.info("*************** Checking Response Time**************");
		long ResTime=response.getTime();
		logger.info("Response Time is -->"+ResTime);
		if(ResTime>5000)
			logger.warn("Response Time is greater than 2000");
		Assert.assertTrue(ResTime<5000);
	}
	
	
	@Test
	public void checkStatusLine()
	{
		logger.info("*************** Checking Status Line **************");
		String statusLine=response.getStatusLine();
		logger.info("Status Line is -->"+statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}
	
	@Test
	public void checkContentType()
	{
		logger.info("*************** Checking Content Type **************");
		String ContentType=response.header("Content-Type");
		logger.info("Content Type is -->"+ContentType);
		Assert.assertEquals(ContentType, "text/html; charset=UTF-8");
	}
	
	@Test
	public void checkServerType()
	{
		logger.info("*************** Checking Server Type **************");
		String ServerType=response.header("Server");
		logger.info("Server Type is -->"+ServerType);
		Assert.assertEquals(ServerType, "Apache");
	}
	
	@Test
	public void checkContentEncoding()
	{
		logger.info("*************** Checking Content Encoding **************");
		String ContentConcoding=response.header("content-encoding");
		logger.info("Content Concoding is -->"+ContentConcoding);
		Assert.assertEquals(ContentConcoding, "gzip");
	}
	
	@Test
	public void checkContentLength()
	{
		logger.info("*************** Checking Content Length **************");
		String ContentLength=response.header("Content-Length");
		logger.info("Content Length is -->"+ContentLength);
		if(Integer.parseInt(ContentLength)<100)
			logger.warn("Content Length is less than 100");
		Assert.assertTrue(Integer.parseInt(ContentLength)>100);
		
	}

	@Test
	public void checkCookies()
	{
		logger.info("*************** Checking Cookies **************");
		String cook=response.getCookie("PHPSESSID");
		logger.info("Cookies is -->"+cook);
		//Assert.assertEquals(ContentConcoding, "gzip");
	}
	
	@AfterClass
	public void teardown()
	{
		logger.info("***************  Finished TC001_Get_All_Emplyees**************");
	}
}
