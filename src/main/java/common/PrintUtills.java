package common;

import org.testng.Reporter;

public class PrintUtills {
	
	
	
	public static void logMsg(String msg) 
	{
		System.out.println(msg);
		Reporter.log(msg);
		ExtentReport.logStep(msg, "PASS");
		
	}
	
	public static void logError(String msg) 
	{
		System.err.println(msg);
		SeleniumGenerics.sa.fail();
		Reporter.log(msg);
		ExtentReport.logStep(msg, "FAIL");
		
	}

	
}
