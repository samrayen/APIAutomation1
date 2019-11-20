package com.apipostproject.JiraAPIAutomation;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import files.Jirareuseablemethod;

import files.resources;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


import static io.restassured.RestAssured.*;

public class Jirapostmethod2 {

	public static String testhappy3;

	
	@Test
	public static void jirapostexecution() throws IOException
	{
		Properties testpro = Jirareuseablemethod.Jiraenvironment();
		RestAssured.baseURI = testpro.getProperty("ENVURL");
		
		Response testhappy=   given().header("Content-Type", "application/json").
				header("Cookie","JSESSIONID="+Jirareuseablemethod.jirapostcookies()).
				body(Jirareuseablemethod.externalpost("E:\\apieclipsejee930\\eclipse-workspace\\JiraAPIAutomation\\src\\test\\java\\staticpayloadd\\Jsonpost.json")).when().log().all().
				post(resources.jirapostresource1()).
				then().statusCode(201).log().all().
				extract().response();
		
		String testhappy1 = testhappy.asString();
		JsonPath testhappy2 = new JsonPath(testhappy1);
		testhappy3= testhappy2.get("id");
		System.out.println("status result : " +testhappy3);
		
	
		
	}
	
	
	  
	
	
}


