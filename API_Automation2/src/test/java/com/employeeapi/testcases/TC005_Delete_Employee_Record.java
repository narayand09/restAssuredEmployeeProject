package com.employeeapi.testcases;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;

public class TC005_Delete_Employee_Record extends TestBase {
	
	@BeforeClass
	public void deleteRecord() throws InterruptedException
	{
	
	logger.info("***************  Started TC001_Get_All_Emplyees**************");
	RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
	httpRequest=RestAssured.given();
	response=httpRequest.request(Method.GET,"/employees");
	Thread.sleep(6000);
	JsonPath json=response.jsonPath();
	String empid=json.get("[2].id");
	System.out.println(response.getBody().asString());
	response=httpRequest.request(Method.DELETE,"/delete"+empid);
	
	}
	
	@Test
	public void CheckResponseBody()
	{
		String respbody=response.getBody().asString();
		System.out.println(respbody);
	}
}
