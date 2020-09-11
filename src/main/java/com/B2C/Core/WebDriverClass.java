package com.B2C.Core;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.B2C.Core.ReporterClass;


public class WebDriverClass extends DeviceCompactability
{
    public static WebDriver driver;
    public static WebDriverWait customWait;
    public static final String USERNAME = "Prolifics_Sauce01";
	public static final String ACCESS_KEY = "28e6ab37-1177-4b11-af93-f30b663b2168";
    public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";
    public static ReporterClass reporter;
	private String browser;
	
	public void initilize(String browserName,String testbed,String device) throws MalformedURLException
	{
		browser=browserName;
		String sPath = System.getProperty("user.dir");
		
		//Initialize webDriver		
		if(driver == null)
		{			
			if(browserName.equalsIgnoreCase("chrome"))
			{
				  if(testbed.equalsIgnoreCase("saucelabs"))
				  {
					  if(device.equalsIgnoreCase("mobile")) {
						  driver = Android();
						}
					  else if(device.equalsIgnoreCase("tablet")) {
						 driver = Android_Tab();
					  }
					  else {
						  driver = Windows10_Chrome();
					  }
				  }
				  else
				  {
					 // ReporterClass.logger.log(Status.PASS, "Test running in Chrome browser");  
					  System.setProperty("webdriver.chrome.driver", sPath+"\\Drivers\\chromedriver.exe");
					  driver=new ChromeDriver();
				  }
			}
			else if(browserName.equalsIgnoreCase("firefox"))
			{
				if(testbed.equalsIgnoreCase("saucelabs"))
				  {
					driver = Windows10_Firefox();
				  }
				else
				{
		     
					//ReporterClass.logger.log(Status.PASS, "Test running in Firefox browser");
					System.setProperty("webdriver.gecko.driver", sPath+"\\Drivers\\geckodriver.exe");
					driver=new FirefoxDriver();
				}
				
			}
			else if(browserName.equalsIgnoreCase("Edge"))
			{
				if(testbed.equalsIgnoreCase("saucelabs"))
				{
					    DesiredCapabilities caps = DesiredCapabilities.edge();
				        caps.setCapability("platform", "Windows 10");
				        caps.setCapability("version", "17.17134");
				        driver = new RemoteWebDriver(new URL(URL), caps);
				}
				else{
	
					//ReporterClass.logger.log(Status.PASS, "Test running in Edge browser");
                    System.setProperty("webdriver.edge.driver", sPath+"\\Drivers\\MicrosoftWebDriver.exe");
					driver=new EdgeDriver();
				}
			   
			}
			else if(browserName.equalsIgnoreCase("IE") || browserName.equalsIgnoreCase("Internet Explorer"))
			{
				
	           if(testbed.equalsIgnoreCase("saucelabs"))
				{
				     DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
			         caps.setCapability("platform", "Windows 10");
			         caps.setCapability("version", "11");
			         driver = new RemoteWebDriver(new URL(URL), caps);
				}
				else
				{
                   //ReporterClass.logger.log(Status.PASS, "Test running in IE browser");
					System.setProperty("webdriver.ie.driver", sPath+"\\Drivers\\IEDriverServer.exe");
					driver=new InternetExplorerDriver();
					DesiredCapabilities cap = new DesiredCapabilities();
					cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
				}
			   
			}
			else if (browserName.equalsIgnoreCase("safari"))
			{
				if (testbed.equalsIgnoreCase("saucelabs"))
				{					
					if (device.equalsIgnoreCase("mobile"))
					{
						driver = Iphone();
					}
					else if (device.equalsIgnoreCase("tablet"))
					{
						driver = Ipad();
					}
					else
					{
						driver = Mac_Safari();
					}
				}
			}
		}
		//Perform Basic Operations
		driver.manage().deleteAllCookies();
		if (testbed.equalsIgnoreCase("local"))
			driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(150, TimeUnit.SECONDS);
		customWait = new WebDriverWait(driver,60);
	}
	
//	 public void endTest()
//	    {
//	    	driver.close();
//	    	if(!(browser.equalsIgnoreCase("firefox")))
//	    		driver.quit();
//		    driver = null;
//		    try {
//				Thread.sleep(10000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//	}
			
		  
	  //  }
}

