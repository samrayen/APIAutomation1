package com.apipostproject.JiraAPIAutomation;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.Jirareuseablemethod;
import files.Jirapayload;
import files.resources;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


public class Jirapostmethod1 {

	@Test(dataProvider="Samson")
	public static void jirapostexecution(String summary1, String description1) throws IOException
	{
		Properties testpro = Jirareuseablemethod.Jiraenvironment();
		RestAssured.baseURI = testpro.getProperty("ENVURL");
		
		Response testhappy= given().header("Content-Type", "application/json").
				header("Cookie","JSESSIONID="+Jirareuseablemethod.jirapostcookies()).
				body(Jirapayload.postfinalload1(summary1, description1)).when().log().all().
				post(resources.jirapostresource1()).
				then().statusCode(201).log().all().
				extract().response();
		JsonPath testhappy3= Jirareuseablemethod.jsonresponse(testhappy);
					String testhappy4= testhappy3.get("status");
			
	}
	
	@DataProvider(name="Samson")
	public static Object[][] postaparam( )
	{
		return new Object [][] {{"Issue jessie for adding comment", "Creating my wife bug"},{"Issue samson for adding comment", "Creating my husband bug"},{"Issue samantha for adding comment", "Creating my daughter bug"}};
		
	   
	}
	
}


