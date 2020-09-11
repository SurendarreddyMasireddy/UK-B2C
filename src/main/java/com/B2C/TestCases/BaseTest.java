package com.B2C.TestCases;

import java.lang.reflect.Method;
import java.net.MalformedURLException;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.B2C.Core.ReporterClass;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class BaseTest extends ReporterClass
{
   String Browser;
   String TestBed;
   String Instance;
   String Device;
   String ApplicationType;
	
   @BeforeSuite
   public void beforeSuite() throws Exception
    {
	   ReportConfiguration();
    }
   
   
   @BeforeTest
   public void beforeTest() throws MalformedURLException
   {
	   Browser = System.getProperty("browser");
	   TestBed = System.getProperty("testbed");	 
	   Device  = System.getProperty("device");	 
	   ApplicationType = System.getProperty("applicationType");
	   if(ApplicationType.equalsIgnoreCase("web"))
	   {
		   initilize(Browser,TestBed,Device);
	   }
   }
   
    	
    @BeforeMethod
    public void getTestMethodName(Method method)
	{
    	StartReport(method);
	}
    
    
    @AfterMethod
    public void getStatusofTests(ITestResult result) throws Exception
    {
    	getResult(result);
    }
   
    
    @AfterTest
    public void afterTest()
    {
    	//endTest();
    }
    
}
