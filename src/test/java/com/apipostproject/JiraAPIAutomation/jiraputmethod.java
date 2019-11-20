package com.apipostproject.JiraAPIAutomation;
import files.Jirareuseablemethod;

import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;


import files.resources;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


import static io.restassured.RestAssured.given;


public class jiraputmethod {
	
	@Test
   public static void putmethodjira() throws IOException
   {
	   Properties putenv = Jirareuseablemethod.Jiraenvironment();
	   RestAssured.baseURI=putenv.getProperty("ENVURL");
	   
	   Response test111 =  given().header("Content-Type", "application/json").
				header("Cookie","JSESSIONID="+Jirareuseablemethod.jirapostcookies()).
	   body(Jirareuseablemethod.externalpost("E:\\apieclipsejee930\\eclipse-workspace\\JiraAPIAutomation\\src\\test\\java\\staticpayloadd\\postcomment.json")).log().all().
	   when().post(resources.postcommentenv2()).
	   then().assertThat().statusCode(201).log().all().extract().response();
	   
	   JsonPath trser1 = Jirareuseablemethod.jsonresponse(test111);
	   String sss = trser1.get("id");
	   System.out.println("done it samson:" +sss);
	   
	
	
	   
	   
   }
	

}
