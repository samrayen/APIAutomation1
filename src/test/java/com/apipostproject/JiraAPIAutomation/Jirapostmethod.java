package com.apipostproject.JiraAPIAutomation;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import files.Jirareuseablemethod;
import files.Jirapayload;
import files.resources;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import files.Jirapayload;

import static io.restassured.RestAssured.*;


public class Jirapostmethod {

	@Test
	public static void jirapostexecution() throws IOException
	{
		Properties testpro = Jirareuseablemethod.Jiraenvironment();
		RestAssured.baseURI = testpro.getProperty("ENVURL");
		
		Response testhappy= given().header("Content-Type", "application/json").
				header("Cookie","JSESSIONID="+Jirareuseablemethod.jirapostcookies()).
				body("{"+
		    "\"fields\": {"+
		       "\"project\":{"+
		          "\"key\": \"JIRAAPI\""+
		       "},"+
		       "\"summary\": \"Issue 5 for adding comment\","+
		       "\"description\": \"Creating my second bug\","+
		       "\"issuetype\": {"+
		          "\"name\": \"Bug\""+
		       "}"+
		   "}}").when().log().all().log().all().
				post(resources.jirapostresource1()).
				then().statusCode(201).log().all().
				extract().response();
		
		String testhappy1 = testhappy.asString();
		JsonPath testhappy2 = new JsonPath(testhappy1);
		String testhappy3= testhappy2.get("status");
		System.out.println("status result : " +testhappy3);
		
	}
	
}
