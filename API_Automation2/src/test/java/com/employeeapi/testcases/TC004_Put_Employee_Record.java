package com.employeeapi.testcases;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;
import com.employeeapi.utilities.RestUtils;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC004_Put_Employee_Record extends TestBase{
	String empName=RestUtils.empname();
	String empSal=RestUtils.empsal();
	String empAge=RestUtils.empage();
	
	@BeforeClass
	public void CreateEmployee() throws InterruptedException
	{
	logger.info("***************  Started TC0043_Put_Employee_Record**************");
	RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
	httpRequest=RestAssured.given();
	System.out.println(empName+"......."+empSal+"..............."+empAge);
	JSONObject json=new JSONObject();
	json.put("name",empName);
	json.put("salary",empSal);
	json.put("age",empAge);
	httpRequest.header("Content-Type","Application/json");
	httpRequest.body(json.toJSONString());
	response=httpRequest.request(Method.PUT,"/update"+empID);
	System.out.println(response.getBody().asString());
	
	Thread.sleep(10000);
	System.out.println(response.getBody().asString());
	System.out.println(response.getStatusCode());
	System.out.println(response.getStatusLine());
	}
	
	
	@Test
	public void checkResponseBody()
	{
		String respbody=response.getBody().asString();
		System.out.println(respbody);
		//Assert.assertTrue(respbody.contains(empName));
		//Assert.assertTrue(respbody.contains(empSal));
		//Assert.assertTrue(respbody.contains(empAge));
		
	}
}
