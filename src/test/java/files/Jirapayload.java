package files;

public class Jirapayload {
	
	public static String cookiespayload()
	{
		String cookiess = 
			"{ \"username\": \"samson\", \"password\": \"Qwerty1!\" }";
			return 	cookiess;
				
	}
	
	public static String payloadpoststring()
	
	{
		String plodpostst = "{"+
			    "\"fields\": {"+
			       "\"project\":{"+
			          "\"key\": \"SAM\""+
			       "},"+
			       "\"summary\": \"Issue 1 for adding comment\","+
			       "\"description\": \"Creating my first bug\","+
			       "\"issuetype\": {"+
			          "\"name\": \"Bug\""+
			       "}";
		return plodpostst;
	}
	
public static String postfinalload1(String summary1, String description1 )
{
	
	
	String postexete = 
			
			"{"+
				    "\"fields\": {"+
				       "\"project\":{"+
				          "\"key\": \"JIRAAPI\""+
				       "},"+
				       "\"summary\": \""+summary1+"\","+
				       "\"description\": \""+description1+"\","+
				       "\"issuetype\": {"+
				          "\"name\": \"Bug\""+
				       "}"+
				   "}}";
	return postexete;
}

public static String putjiraupdate()
{
	String Jiraapiupdatestr = 
			"{\r\n    "
			+ "\"body\": \"JIRA API Update as per the samson request.\",\r\n    "
			+ "\"visibility\": "
			+ "{\r\n        \"type\": \"role\",\r\n       "
			+ " \"value\": \"Administrators\"\r\n    "
			+ "}\r\n}";
  return Jiraapiupdatestr;
}

}