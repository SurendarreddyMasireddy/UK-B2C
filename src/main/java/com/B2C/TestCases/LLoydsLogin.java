package com.B2C.TestCases;

import java.net.URISyntaxException;
import java.util.List;

import org.openqa.selenium.By;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import java.awt.Robot;

import com.B2C.Core.ObjectRepository;
import com.B2C.Core.ReporterClass;
import com.B2C.Core.WebModuleDriver;
import com.aventstack.extentreports.Status;
import com.sun.glass.events.KeyEvent;

public class LLoydsLogin extends WebModuleDriver
{
	String url = null,msg;
	ObjectRepository obj = new ObjectRepository();
	static Screen s = new Screen();
	
	public void NavigateandLoginB2C(String Email,String Pwd) throws Exception
	{
		uiDriver.navitagetoURL(utilFunctions.loadProps().get("Admin").toString());
	    Thread.sleep(500);
//	    uiDriver.SetValueForTextBox("Password",utilFunctions.loadProps().get(password).toString());
//	    Thread.sleep(500);
	    uiDriver.SetValueForTextBox("Email",utilFunctions.loadProps().get(Email).toString());
	    Thread.sleep(4000);
	    uiDriver.ClickOnButtonorLink("Next");
        Thread.sleep(500);
	    uiDriver.SetValueForTextBox("pwd",utilFunctions.loadProps().get(Pwd).toString());
	    Thread.sleep(1500);
	    uiDriver.ClickOnButtonorLink("login");
        Thread.sleep(1500);
        uiDriver.ClickOnButtonorLink("Online_Store");
        Thread.sleep(500);
        uiDriver.ClickOnButtonorLink("Themes");
        Thread.sleep(5000);
        int AdminPageiframesize = uiDriver.driver.findElements(By.tagName("iframe")).size();
        System.out.println("AdminPageiframesize: " +AdminPageiframesize);
        uiDriver.driver.switchTo().frame(0);
        uiDriver.hoverClickWebelement("View");
        Thread.sleep(500);
//	    uiDriver.ClickOnButtonorLink("SignIn");
//	    Thread.sleep(500);  
	}
	

	}
