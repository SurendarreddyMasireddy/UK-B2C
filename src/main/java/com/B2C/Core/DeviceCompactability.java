package com.B2C.Core;

import java.net.MalformedURLException;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;

public class DeviceCompactability
{
	public static RemoteWebDriver remote;
	
	public static final String USERNAME = "Prolifics_Sauce01";
	
	public static final String ACCESS_KEY = "28e6ab37-1177-4b11-af93-f30b663b2168";
											
	public static final String SauceLabsURL ="https://"+USERNAME+":"+ACCESS_KEY+"@ondemand.saucelabs.com:443/wd/hub";
	
	
	
	public RemoteWebDriver Android() throws MalformedURLException
	{		
		DesiredCapabilities caps = DesiredCapabilities.android();
		caps.setCapability("username", USERNAME);
		caps.setCapability("accessKey", ACCESS_KEY);
		caps.setCapability("appiumVersion", "1.9.1");
		caps.setCapability("deviceName","Samsung Galaxy S9 Plus HD GoogleAPI Emulator");
		caps.setCapability("deviceOrientation", "portrait");
		caps.setCapability("browserName", "Chrome");
		caps.setCapability("platformVersion", "8.0");
		caps.setCapability("platformName","Android");
		caps.setCapability("name", "Testing on Chrome in Android Phone");
		remote = new RemoteWebDriver(new java.net.URL(SauceLabsURL), caps);	
		return remote;
	}
	
	public RemoteWebDriver Android_Tab() throws MalformedURLException
	{
		DesiredCapabilities caps = DesiredCapabilities.android();
		caps.setCapability("appiumVersion", "1.9.1");
		caps.setCapability("deviceName","Samsung Galaxy Tab A 10 GoogleAPI Emulator");
		caps.setCapability("deviceOrientation", "landscape");
		caps.setCapability("browserName", "Chrome");
		caps.setCapability("platformVersion", "8.1");
		caps.setCapability("platformName","Android");
		caps.setCapability("name", "Testing on Chrome in Android Tab");	
		remote = new RemoteWebDriver(new java.net.URL(SauceLabsURL), caps);		 
		return remote;
	}
	
	public RemoteWebDriver Iphone() throws MalformedURLException	
	{		
		DesiredCapabilities caps = DesiredCapabilities.iphone();
		caps.setCapability("appiumVersion", "1.9.1");
		caps.setCapability("deviceName","iPhone 8 Plus Simulator");
		caps.setCapability("deviceOrientation", "portrait");
		caps.setCapability("platformVersion","12.0");
		caps.setCapability("platformName", "iOS");
		caps.setCapability("browserName", "Safari");
		caps.setCapability("name", "Testing on Safari in Iphone");
		remote = new RemoteWebDriver(new java.net.URL(SauceLabsURL), caps);		
		return remote;
	}
	
	public RemoteWebDriver Ipad() throws MalformedURLException
	{
		DesiredCapabilities caps = DesiredCapabilities.iphone();
		caps.setCapability("appiumVersion", "1.13.0");
		caps.setCapability("deviceName","iPad (5th generation) Simulator");
		caps.setCapability("deviceOrientation", "portrait");
		caps.setCapability("platformVersion","12.2");
		caps.setCapability("platformName", "iOS");
		caps.setCapability("browserName", "Safari");
		caps.setCapability("name", "Testing on Safari in Ipad");
		remote = new RemoteWebDriver(new java.net.URL(SauceLabsURL), caps);	
		return remote;
	}
	
	public RemoteWebDriver Mac_Firefox() throws MalformedURLException
	{
		DesiredCapabilities caps = DesiredCapabilities.firefox();
		caps.setCapability("platform", "macOS 10.14");
		caps.setCapability("version", "68.0");
		caps.setCapability("name", "Testing on Firefox 68 in MacOS");
		remote = new RemoteWebDriver(new java.net.URL(SauceLabsURL), caps);		
		return remote;
	}
	
	public RemoteWebDriver Mac_Chrome() throws MalformedURLException
	{
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		caps.setCapability("platform", "macOS 10.14");
		caps.setCapability("version", "75.0");
	    caps.setCapability("name", "Testing on Chrome in MacOS");
		remote = new RemoteWebDriver(new java.net.URL(SauceLabsURL), caps);		
		return remote;
	}
	
	public RemoteWebDriver Mac_Safari() throws MalformedURLException
	{
		
		/*
		 * MutableCapabilities sauceOptions = new MutableCapabilities();
		 * 
		 * SafariOptions browserOptions = new SafariOptions();
		 * browserOptions.setCapability("platformName", "macOS 10.14");
		 * browserOptions.setCapability("browserVersion", "latest");
		 * browserOptions.setCapability("sauce:options", sauceOptions);
		 */
		
		DesiredCapabilities caps = DesiredCapabilities.safari();
		caps.setCapability("platform", "macOS 10.14");
		caps.setCapability("version", "12.0");
		SafariOptions safariOptions = new SafariOptions();
		caps.setCapability(SafariOptions.CAPABILITY,safariOptions);
	    caps.setCapability("name", "Testing on Safari in MacOS");
		remote = new RemoteWebDriver(new java.net.URL(SauceLabsURL), caps);	
		return remote;
	}
	
	public RemoteWebDriver Windows10_Firefox() throws MalformedURLException
	{
		DesiredCapabilities caps = DesiredCapabilities.firefox();
		caps.setCapability("platform", "Windows 10");
		caps.setCapability("version", "68.0");
	    caps.setCapability("name", "Testing on Firefox in windows 10");
		remote = new RemoteWebDriver(new java.net.URL(SauceLabsURL), caps);	
		return remote;
	}
	
	public RemoteWebDriver Windows10_Chrome() throws MalformedURLException
	{
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		caps.setCapability("platform", "Windows 10");
		caps.setCapability("version", "75.0");
		caps.setCapability("name", "Testing on chrome in Windows 10");
		remote = new RemoteWebDriver(new java.net.URL(SauceLabsURL), caps);	
		return remote;
	}
	
	public RemoteWebDriver Windows7_Firefox() throws MalformedURLException
	{
		DesiredCapabilities caps = DesiredCapabilities.firefox();
		caps.setCapability("platform", "Windows 7");
		caps.setCapability("version", "38");
		caps.setCapability("name", "Testing on Firefox 68 in windows 7");
		remote = new RemoteWebDriver(new java.net.URL(SauceLabsURL), caps);		
		return remote;
	}
	
	public RemoteWebDriver Windows7_Chrome() throws MalformedURLException
	{
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		caps.setCapability("platform", "Windows 7");
		caps.setCapability("version", "75.0");
		caps.setCapability("name", "Testing on chrome in Windows 7");
		remote = new RemoteWebDriver(new java.net.URL(SauceLabsURL), caps);		
		return remote;
	}
	
	public RemoteWebDriver Windows_IE() throws MalformedURLException
	{
		DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
		caps.setCapability("platform", "Windows 8.1");
		caps.setCapability("version", "11");
		caps.setCapability("name", "Testing on IE 11");
		remote = new RemoteWebDriver(new java.net.URL(SauceLabsURL), caps);		 
		return remote;
	}
}
