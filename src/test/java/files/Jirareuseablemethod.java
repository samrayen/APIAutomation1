package files;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class Jirareuseablemethod {
	
	public static Properties Jiraenvironment() throws IOException
	{
		Properties Jiraprob = new Properties();
		FileInputStream JiraFIle = new FileInputStream("E:\\apieclipsejee930\\eclipse-workspace\\JiraAPIAutomation\\src\\test\\java\\files\\env.properties");
		Jiraprob.load(JiraFIle);
		return Jiraprob;
	}

	public static JsonPath jsonresponse(Response Jsonresp)
	{
		String respon1 = Jsonresp.asString();
		JsonPath respon2 = new JsonPath(respon1);
		return respon2;
	}
	
	public static String externalpost(String path)throws IOException
	{
		return new String(Files.readAllBytes(Paths.get(path)));
	 
	}

	
	public static String jirapostcookies() throws IOException
	{
		Properties Jirabaseurl = Jirareuseablemethod.Jiraenvironment();
		RestAssured.baseURI= Jirabaseurl.getProperty("ENVURL");
		Response respoo12 = given().header("content-type", "application/json").body(Jirapayload.cookiespayload()).
		when().log().all().post(resources.jirapostresource()).then().assertThat().statusCode(200).log().all().extract().response();
		
		JsonPath respoo2=  Jirareuseablemethod.jsonresponse(respoo12);
		String responsecookie = respoo2.get("session.value");
		System.out.println("Cookies response : " +responsecookie);
		return responsecookie;
		
	}
	
	public static String jsonstringconvert(String path) throws IOException
	{
	
			return new String(Files.readAllBytes(Paths.get(path)));
		
		}

	

	
	
	}