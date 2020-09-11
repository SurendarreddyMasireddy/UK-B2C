
	package com.B2C.TestCases;

import java.awt.Robot;

import org.openqa.selenium.Keys;
import org.sikuli.script.Key;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

import com.B2C.Core.ReporterClass;
import com.B2C.Core.WebControls;
import com.B2C.Core.WebModuleDriver;
import com.aventstack.extentreports.Status;
import com.sun.corba.se.impl.orb.ORBConfiguratorImpl.ConfigParser;
import com.sun.glass.events.KeyEvent;

public class Fulfillment extends WebModuleDriver {
	
//	private static final Object FulfillmentUname = null;
//	private static final Object FulfillmentPassword = null;
	//private static final String FulfillmentURL = null;
	static Screen s = new Screen();
	 WebControls wb = new WebControls();
	 HomePage hp = new HomePage();
	 String sPath = System.getProperty("user.dir");
	
	 
	 
	 public void NavigateandLoginFulfillment() throws Exception
		{
		 
			   Pattern chrome = new Pattern(sPath+"\\Images\\GoogleChrome.PNG");
		       Pattern progressbar = new Pattern(sPath+"\\Images\\CitrixProgressBar.PNG");
		       Pattern username = new Pattern(sPath+"\\Images\\UserName.PNG");
		       Pattern pasword = new Pattern(sPath+"\\Images\\Password.PNG");
		       Pattern login = new Pattern(sPath+"\\Images\\Login.PNG");
		       
		       wb.navitage2URL(navitagetoURL(utilFunctions.loadProps().get("FulfillmentURL").toString()));
		        Thread.sleep(500);
		      // s.type("FulfillmentURL")
		       //ReporterClass.logger.log(Status.PASS, "Successfully Navigated to  URL");
		        reporter.logger.log(Status.PASS,"Successfully navigated to URL");
				Thread.sleep(1000); 
				Robot r = new Robot();
				//Robot r = null;
				r.keyPress(KeyEvent.VK_ENTER);
				Thread.sleep(200);
				r.keyRelease(KeyEvent.VK_ENTER); 
				Thread.sleep(15000);
				 
			   
				// enter username , passowrd and click login
				
				 wb.SetValueForTextBox(username,utilFunctions.loadProps().get("FulfillmentUname").toString());
			     Thread.sleep(500);
			
				//String Uname = navitagetoURL(utilFunctions.loadProps().get(FulfillmentUname).toString());
//				System.out.println("Uname" + Uname);
//				s.type(username,Uname);
//		        Thread.sleep(500);
//		
			   //s.type(username, "admin@mohc.net");		       		        
			    wb.SetValueForTextBox(pasword,utilFunctions.loadProps().get("FulfillmentPassword").toString());
		        Thread.sleep(1500);
		        //s.capture().save(path, name)
		       // wb.TakeScreenshot("login");
		        
		       // Thread.sleep(500);
			    wb.ClickOnElement(login , "Login Button");
			    Thread.sleep(30000);
			    
		}



		private String navitagetoURL(String string) {
		// TODO Auto-generated method stub
		return string ;
	}

		//@Test(priority=1)
		public void selectStandardDeliveryMethod() throws Exception
		{
			Pattern update = new Pattern(sPath+"\\Images\\Update.PNG");
			Pattern create = new Pattern(sPath+"\\Images\\Create.PNG");
			Pattern standard = new Pattern(sPath+"\\Images\\Standard.PNG");
			Pattern deliverymethod = new Pattern(sPath+"\\Images\\DeliveryMethod.PNG");
			
			 wb.ClickOnElement(update, "Update Button");
		    Thread.sleep(1000);
		    wb.ClickOnElement(deliverymethod , "Delivery Method");
		    Thread.sleep(1000);
		    wb.ClickOnElement(standard, "Standard Option");
		    Thread.sleep(1000);
		    wb.ClickOnElement(create, "Create Button");
		    Thread.sleep(1000);
	    }
		
		
		public void selectNextDayDeliveryMethod() throws Exception
		{
			Pattern update = new Pattern(sPath+"\\Images\\Update.PNG");
			Pattern create = new Pattern(sPath+"\\Images\\Create.PNG");
			Pattern nextday = new Pattern(sPath+"\\Images\\NextDay.PNG");
			Pattern deliverymethod = new Pattern(sPath+"\\Images\\DeliveryMethod.PNG");
			
			 wb.ClickOnElement(update, "Update");
		    Thread.sleep(1000);
		    wb.ClickOnElement(deliverymethod, "Delivery Method");
		    Thread.sleep(1000);
		    wb.ClickOnElement(nextday ,"NextDay");
		    Thread.sleep(1000);
		    wb.ClickOnElement(create,"Create");
		    Thread.sleep(1000);
	}
		public void selectClickAndCollectDeliveryMethod() throws Exception
		{
			Pattern update = new Pattern(sPath+"\\Images\\Update.PNG");
			Pattern create = new Pattern(sPath+"\\Images\\Create.PNG");
			Pattern clickandcollect = new Pattern(sPath+"\\Images\\Click&Collect.PNG");
			Pattern deliverymethod = new Pattern(sPath+"\\Images\\DeliveryMethod.PNG");
			
			 wb.ClickOnElement(update, "Update");
		    Thread.sleep(1000);
		    wb.ClickOnElement(deliverymethod, "Delivery Method");
		    Thread.sleep(1000);
		    wb.ClickOnElement(clickandcollect, "Click and Collect");
		    Thread.sleep(1000);
		    wb.ClickOnElement(create,"Create");
		    Thread.sleep(1000);
	}
		
		public void Orders() throws Exception
		{
			Pattern orders = new Pattern(sPath+"\\Images\\Orders.PNG");
			Pattern orderid = new Pattern(sPath+"\\Images\\Orderid.PNG");
			
			wb.ClickOnElement(orders, "Orders");
		    Thread.sleep(10000);
//		    s.type(Key.PAGE_DOWN);
//		     Thread.sleep(2000);
		    wb.ClickOnElement(orderid, "OrderID");
		    Thread.sleep(15000);
	}
		public void Batch() throws Exception
		{
			Pattern batchId = new Pattern(sPath+"\\Images\\BatchId_Label.PNG");
			 Pattern batches = new Pattern(sPath+"\\Images\\Batches.PNG");
			 Pattern enterid = new Pattern(sPath+"\\Images\\Enterbatchid.PNG");
			 Pattern search = new Pattern(sPath+"\\Images\\Search.PNG");
			 
			 String imgPath = hp.takeScreenshot(batchId);
			 String batchid =  hp.getImgText​(imgPath);
			// wb.TakeScreenshot("Batch");
			 
//			 String imgPath1=wb.GetTextandStoreinVariable("imgPath");
//		        System.out.println("imgPath: " +imgPath1);
//		        ReporterClass.logger.log(Status.INFO, "imgPath:" + imgPath1 + " ");
				
				System.out.println("BatchIDtext = "+batchid);
				
				 wb.ClickOnElement(batches, "batches");
			    Thread.sleep(10000);
			    wb.SetValueForTextBox(enterid,batchid);
			    Thread.sleep(500);
			    wb.ClickOnElement(search, "Search");
			    Thread.sleep(10000);
		}
		
		
		public void ConfirmOrder() throws Exception
		{
			 Pattern confirm = new Pattern(sPath+"\\Images\\Confirmbatch.PNG");
		     Pattern complete = new Pattern(sPath+"\\Images\\Completeorder.PNG");
		     Pattern print = new Pattern(sPath+"\\Images\\Print.PNG");
		     Pattern printcopy = new Pattern(sPath+"\\Images\\PrintCopy.PNG");
		     //Pattern scroll = new Pattern("F:\\Automation_Selenium\\B2CDemo\\Images\\Scrolldown.PNG");
		    // wb.ScrollMouseDown(1000);
		     s.type(Key.PAGE_DOWN);
		     Thread.sleep(5000);
		    // s.type(Keys.RIGHT);
		    // wb.ScrollMouseright();
		     wb.ClickOnElement(confirm, "Confirm");
			 Thread.sleep(10000);
			 s.type(Key.PAGE_DOWN);
		     Thread.sleep(2000);
			 wb.ClickOnElement(complete, "Complete");
			 Thread.sleep(10000);
			 wb.ClickOnElement(print, "Print");
			 Thread.sleep(10000);
			 wb.ClickOnElement(printcopy, "PrintCopy");
			 Thread.sleep(10000);
			
		}
		
}
	
