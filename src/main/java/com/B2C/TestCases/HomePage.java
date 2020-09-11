package com.B2C.TestCases;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;
import org.testng.ITestResult;

import com.B2C.Core.ReporterClass;
import com.B2C.Core.WebModuleDriver;
import com.B2C.Core.ObjectRepository;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import net.sourceforge.tess4j.*;
import java.io.*;

public class HomePage extends WebModuleDriver
{
	ObjectRepository obj = new ObjectRepository();
	static Screen s = new Screen();
	String sPath = System.getProperty("user.dir");
	public void search(String Productname) throws Exception
	{
		uiDriver.SetValueForTextBox("Search", Productname);
		Thread.sleep(5000);
		uiDriver.TakeScreenshot("Search Product");
		uiDriver.ClickOnButtonorLink("Addbasket");
		Thread.sleep(2500);
		uiDriver.hoverClickWebelement("Checkout1");
		Thread.sleep(1500);
		uiDriver.ClickOnButtonorLink("Checkout2");
		Thread.sleep(1500);
	}
	
	public void MultiProdsearch(String Productname1, String Productname2) throws Exception
	{
		uiDriver.SetValueForTextBox("Search", Productname1);
		Thread.sleep(5000);
		uiDriver.TakeScreenshot("Search Product");
		uiDriver.ClickOnButtonorLink("Addbasket");
		Thread.sleep(2000);
		uiDriver.hoverClickWebelement("ContinueShopping");
		Thread.sleep(1500);
		uiDriver.ClickOnButtonorLink("BasketIcon");
		Thread.sleep(1500);
		uiDriver.SetValueForTextBox("Search", Productname2);
		Thread.sleep(5000);
		uiDriver.ClickOnButtonorLink("Addbasket");
		Thread.sleep(1500);
		uiDriver.hoverClickWebelement("Checkout1");
		Thread.sleep(3000);
		uiDriver.ClickOnButtonorLink("Checkout2");
		Thread.sleep(1500);
	}
	
	
	public void Payment(String CardNumber, String NameonCard, String Expirationdate, String SecurityCode, String SameasShippingAddress) throws IOException, URISyntaxException, Exception
	{
		uiDriver.MouseScrolldown(300);
		Thread.sleep(3000);
		uiDriver.driver.switchTo().frame(1);
		//uiDriver.SetValueForTextBox("CardNumber",utilFunctions.loadProps().get(CardNumber).toString());
		uiDriver.SetValueforTextboxusingactions("CardNumber",utilFunctions.loadProps().get(CardNumber).toString());
		//actions.click(cardnumber).sendKeys(sdata)
		uiDriver.driver.switchTo().defaultContent();
		Thread.sleep(3000);
		uiDriver.driver.switchTo().frame(2);
		uiDriver.SetValueForTextBox("NameonCard",utilFunctions.loadProps().get(NameonCard).toString());
		uiDriver.driver.switchTo().defaultContent();
		Thread.sleep(3000);
		uiDriver.driver.switchTo().frame(3);
		//uiDriver.SetValueForTextBox("Expirationdate",utilFunctions.loadProps().get(Expirationdate).toString());
		//uiDriver.SetValueForTextBox("Expirationdate","11/22");
		uiDriver.SetValueforTextboxusingactions("Expirationdate",utilFunctions.loadProps().get(Expirationdate).toString());
		uiDriver.driver.switchTo().defaultContent();
		Thread.sleep(3000);
		uiDriver.driver.switchTo().frame(4);
		uiDriver.SetValueForTextBox("SecurityCode",utilFunctions.loadProps().get(SecurityCode).toString());
		uiDriver.driver.switchTo().defaultContent();
		
		uiDriver.ClickOnButtonorLink("SameasShippingAddress");
		uiDriver.TakeScreenshot("Payment");
		uiDriver.ClickOnButtonorLink("Paynow");
		Thread.sleep(30000);
		String Ordernumber=uiDriver.GetTextandStoreinVariable("Ordernumber");
		System.out.println("Ordernumber: " +Ordernumber);
		ReporterClass.logger.log(Status.INFO, "Ordernumber:" + Ordernumber + " ");
		String Thanksmsg=uiDriver.GetTextandStoreinVariable("Thanksmsg");
		System.out.println("Thanksmsg: " +Thanksmsg);
		ReporterClass.logger.log(Status.INFO, "Thanks message:" + Thanksmsg + " ");
		String Ordermsg=uiDriver.GetTextandStoreinVariable("Ordermsg");
		System.out.println("Ordermsg: " +Ordermsg);
		if(Ordermsg.equalsIgnoreCase("Your order is confirmed"))
		{
			ReporterClass.logger.log(Status.PASS, "Order Placed Successfully");
		}
		else
		{
			ReporterClass.logger.log(Status.FAIL, "Failed to place the order");
		}
			
		uiDriver.TakeScreenshot("Order screenshot");
		
	}
	
	
    public void ClickandCollectInStore(String Email,String Fname, String Lname, String PostalCode) throws IOException, URISyntaxException, Exception
    {
    uiDriver.SetValueForTextBox("EmailInfo",utilFunctions.loadProps().get(Email).toString());
    uiDriver.ClickOnButtonorLink("ClickandCollectInStore_Radiobutton");
    Thread.sleep(5000);
    uiDriver.SetValueForTextBox("PostalCode",utilFunctions.loadProps().get(PostalCode).toString());
    Thread.sleep(5000);
    uiDriver.ClickkeydownandPressEnter("PostalCode");
    uiDriver.ClickOnButtonorLink("ChoosethisStore");
    Thread.sleep(2000);
    uiDriver.SetValueForTextBox("Firstname",utilFunctions.loadProps().get(Fname).toString());
    uiDriver.SetValueForTextBox("Lastname",utilFunctions.loadProps().get(Lname).toString());
    Thread.sleep(3000);
    uiDriver.ClickOnButtonorLink("ContinueToCollection");
    Thread.sleep(3000);
    uiDriver.ClickOnButtonorLink("ContinuetoPayment");
    }

    public void CollectInStorePayment(String CardNumber, String NameonCard, String Expirationdate, String SecurityCode, String Fname, String Lname, String Address1, String Address2, String City, String PostalCode) throws IOException, URISyntaxException, Exception
    {
        uiDriver.driver.switchTo().frame(1);
       // uiDriver.SetValueForTextBox("CardNumber",utilFunctions.loadProps().get(CardNumber).toString());
        uiDriver.SetValueforTextboxusingactions("CardNumber",utilFunctions.loadProps().get(CardNumber).toString());
        uiDriver.driver.switchTo().defaultContent();
       
        uiDriver.driver.switchTo().frame(2);
        uiDriver.SetValueForTextBox("NameonCard",utilFunctions.loadProps().get(NameonCard).toString());
        uiDriver.driver.switchTo().defaultContent();
       
        uiDriver.driver.switchTo().frame(3);
        //uiDriver.SetValueForTextBox("Expirationdate",utilFunctions.loadProps().get(Expirationdate).toString());
        uiDriver.SetValueforTextboxusingactions("Expirationdate",utilFunctions.loadProps().get(Expirationdate).toString());
        uiDriver.driver.switchTo().defaultContent();
       
        uiDriver.driver.switchTo().frame(4);
        uiDriver.SetValueForTextBox("SecurityCode",utilFunctions.loadProps().get(SecurityCode).toString());
        uiDriver.driver.switchTo().defaultContent();
       
        uiDriver.SetValueForTextBox("Fname",utilFunctions.loadProps().get(Fname).toString());
        uiDriver.SetValueForTextBox("Lname",utilFunctions.loadProps().get(Lname).toString());
        uiDriver.SetValueForTextBox("Add1",utilFunctions.loadProps().get(Address1).toString());
        uiDriver.SetValueForTextBox("Add2",utilFunctions.loadProps().get(Address2).toString());
        uiDriver.SetValueForTextBox("Cty",utilFunctions.loadProps().get(City).toString());
        uiDriver.ClickOnButtonorLink("Ctry1");
        Thread.sleep(500);
        uiDriver.ClickOnButtonorLink("Ctry2");
        Thread.sleep(500);
        System.out.println("PostalCode"+utilFunctions.loadProps().get(PostalCode).toString());
        uiDriver.SetValueForTextBox("PinCode",utilFunctions.loadProps().get(PostalCode).toString());
       
        Thread.sleep(3000);
        uiDriver.TakeScreenshot("Payment");
        uiDriver.ClickOnButtonorLink("Paynow");
        Thread.sleep(30000);
       
        String Ordernumber=uiDriver.GetTextandStoreinVariable("Ordernumber");
        System.out.println("Ordernumber: " +Ordernumber);
        ReporterClass.logger.log(Status.INFO, "Ordernumber:" + Ordernumber + " ");
        String Thanksmsg=uiDriver.GetTextandStoreinVariable("Thanksmsg");
        System.out.println("Thanksmsg: " +Thanksmsg);
        ReporterClass.logger.log(Status.INFO, "Thanks message:" + Thanksmsg + " ");
        String Ordermsg=uiDriver.GetTextandStoreinVariable("Ordermsg");
        System.out.println("Ordermsg: " +Ordermsg);
        if(Ordermsg.equalsIgnoreCase("Your order is confirmed"))
        {
            //ReporterClass.logger.log(Status.PASS, "Successfully Clicked on " + sElement + " Button\\Link");
            ReporterClass.logger.log(Status.PASS, "Order Placed Successfully");
        }
        else
        {
            ReporterClass.logger.log(Status.FAIL, "Failed to place the order");
        }
           
        uiDriver.TakeScreenshot("Order screenshot");
        
       
    }
    public void searchMultipleProducts() throws Exception
    {
        String Productname;
        uiDriver.driver.switchTo().frame(uiDriver.driver.findElement(By.xpath("//iframe[@id='admin-bar-iframe']")));
        Thread.sleep(2000);
        uiDriver.ClickOnButtonorLink("Hidebar");
        Thread.sleep(3000);
        uiDriver.driver.switchTo().defaultContent();
        Thread.sleep(3000);
        for(int i = 0; i < obj.getCellValue().size(); i++)
        {
            Productname = obj.getCellValue().get(i);
            uiDriver.SetValueForTextBox("Search", Productname);
            Thread.sleep(5000);
            uiDriver.TakeScreenshot("Search Product");
           // uiDriver.MouseScrolldown(500);
//            uiDriver.driver.switchTo().frame(uiDriver.driver.findElement(By.xpath("//iframe[@id='admin-bar-iframe']")));
//            Thread.sleep(2000);
//            uiDriver.ClickOnButtonorLink("Hidebar");
//            Thread.sleep(3000);
//            uiDriver.driver.switchTo().defaultContent();
//            Thread.sleep(3000);
            uiDriver.ClickOnButtonorLink("Addbasket");
            Thread.sleep(1500);
            uiDriver.hoverClickWebelement("Checkout1");
            Thread.sleep(1500);
        }
        uiDriver.MouseScrolldown(500);
        uiDriver.ClickOnButtonorLink("Checkout2");
      Thread.sleep(1500);
    }
  
    public void searchProduct() throws Exception
    {
        String Productname;
        List<String> values = obj.getCellValue();
        Productname = values.get(0).trim();
       Thread.sleep(15000);
        uiDriver.SetValueForTextBox("Search", Productname);
        Thread.sleep(5000);
        uiDriver.TakeScreenshot("Search Product");
        uiDriver.MouseScrolldown(300);
        Thread.sleep(2000);
        uiDriver.ClickOnButtonorLink("Addbasket");
        Thread.sleep(5000);
        //uiDriver.hoverClickWebelement("Hidebar");
        uiDriver.driver.switchTo().frame(uiDriver.driver.findElement(By.xpath("//iframe[@id='admin-bar-iframe']")));
        Thread.sleep(2000);
        uiDriver.ClickOnButtonorLink("Hidebar");
        Thread.sleep(3000);
        uiDriver.driver.switchTo().defaultContent();
        Thread.sleep(1000);
        //uiDriver.MouseScrolldown(500);
        uiDriver.hoverClickWebelement("Checkout1");
        Thread.sleep(5000);
        uiDriver.MouseScrolldown(500);
        uiDriver.ClickOnButtonorLink("Checkout2");
        Thread.sleep(1500);
    }
    
    public void Clickalert() throws URISyntaxException, Exception
    {
    ArrayList<String> tabs = new ArrayList<String> (uiDriver.driver.getWindowHandles());
    uiDriver.driver.switchTo().window(tabs.get(1));
    Thread.sleep(3000);
    int loginpageiframesize = uiDriver.driver.findElements(By.xpath("//iframe[@title='TrustArc Cookie Consent Manager']")).size();
    System.out.println("loginpageiframesize: " +loginpageiframesize);
    uiDriver.driver.switchTo().frame(uiDriver.driver.findElement(By.xpath("//iframe[@title='TrustArc Cookie Consent Manager']")));
    uiDriver.ClickOnButtonorLink("Agreeandproceed");
    Thread.sleep(3000);
    uiDriver.ClickOnButtonorLink("Closealert");
    uiDriver.driver.switchTo().defaultContent();
    }
   
    	
    

    public String getImgText​(String imgPath) throws TesseractException
    {
              String datapath = "F:\\Automation_Selenium\\B2CDemo\\tessdata";
               String language = "est";

               ITesseract instance = new Tesseract();
               instance.setDatapath(datapath);
               instance.setLanguage(language);
             File imageFile = new File(imgPath);
             String result = instance.doOCR(imageFile);
            System.out.println("result:"+result);
      return result;

  }

    public String takeScreenshot(Pattern batchID) throws FindFailed
    {
        Match m = s.find(batchID);
        m.highlight(2);
         Region id = new Region(m.getTopRight().getX(),m.getTopRight().getY(),50,20);
          id.highlight(2);
		String img = s.capture(id).save(sPath+"\\Images", "batchid");
          System.out.println("img:"+img);
		return img;
          
     }
 }

    
	
	


