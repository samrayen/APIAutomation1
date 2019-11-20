package com.apipostproject.JiraAPIAutomation;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import files.Jirareuseablemethod;
import io.restassured.RestAssured;

public class sessionidpost {
	
	@Test
	public static void session() throws IOException
	{
		
		Properties env1 = Jirareuseablemethod.Jiraenvironment();
		RestAssured.baseURI= env1.getProperty("ENVURL");
		
		given().header("Content-Type","application/json").body(
"{ \"username\": \"samson\", \"password\": \"Qwerty1!\" }").when().
		post("/rest/auth/1/session").then().statusCode(200).log().all().extract().response();
		
		
		
		
		
		
	}

}
