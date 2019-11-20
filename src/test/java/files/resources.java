package files;
import com.apipostproject.JiraAPIAutomation.Jirapostmethod2;


public class resources {
	
	public static String jirapostresource()
	{
		String postjirsresource = "/rest/auth/1/session";
		return postjirsresource;
	}
	
	public static String jirapostresource1()
	{
		String postjirsresource1 = "/rest/api/2/issue";
		return postjirsresource1;
	
	}
	public static String postcommentenv2()
	{
		 String postenvcomment = "/rest/api/2/issue/"+Jirapostmethod2.testhappy3+"/comment";
		return postenvcomment;
	}

	
	public static String putjirissue()
	{
		String putj = "/rest/api/2/issue/"+Jirapostmethod2.testhappy3+"/comment";
		return putj;
	}
}
