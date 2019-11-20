package com.apipostproject.JiraAPIAutomation;

import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import files.Jirareuseablemethod;
import files.resources;


import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;



public class Jiraissueputmethod {

	@Test
	public static void issueput() throws IOException
	{
		Properties env1 = Jirareuseablemethod.Jiraenvironment();
		RestAssured.baseURI= env1.getProperty("ENVURL");
		
		given().header("Content-Type","application/json").
		header("Cookie","SessionID=" +Jirareuseablemethod.jirapostcookies()).log().all().
	
		
		when().put(resources.putjirissue()).
		then().statusCode(200).log().all().extract().response();
		
		
	}
		
	
}
