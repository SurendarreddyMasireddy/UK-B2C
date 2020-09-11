package com.B2C.Lloyds;

import java.awt.Robot;

import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

import com.B2C.TestCases.BaseTest;
import com.B2C.TestCases.Fulfillment;
import com.B2C.TestCases.HomePage;
import com.B2C.TestCases.LLoydsLogin;

public class FulfillmentStandardDelivery extends BaseTest
{
	
 Fulfillment ff = new Fulfillment();
	 
	
	@Test
	public void StandardDelivery() throws Exception
	{
		// TODO Auto-generated method stub
			Thread.sleep(9000);
			Robot r = new Robot();
			
			ff.NavigateandLoginFulfillment();
			ff.selectStandardDeliveryMethod();
			ff.Orders();
			ff.Batch();
			ff.ConfirmOrder();
	}
	 
		/*public static void main(String[] args) throws Exception
		{
			
	
			// TODO Auto-generated method stub
			Thread.sleep(9000);
			Robot r = new Robot();
			
			ff.NavigateandLoginFulfillment();
			ff.selectStandardDeliveryMethod();
			ff.Orders();
			ff.Batch();
			ff.ConfirmOrder();
			
			
	//		 Pattern batchId = new Pattern("F:\\Automation_Selenium\\B2CDemo\\Images\\BatchId_Label.PNG");
	//		 Pattern batches = new Pattern("F:\\Automation_Selenium\\B2CDemo\\Images\\Batches.PNG");
	//		 Pattern enterid = new Pattern("F:\\Automation_Selenium\\B2CDemo\\Images\\Enterbatchid.PNG");
	//		 Pattern search = new Pattern("F:\\Automation_Selenium\\B2CDemo\\Images\\Search.PNG");
	//	     Pattern confirm = new Pattern("F:\\Automation_Selenium\\B2CDemo\\Images\\Confirmbatch.PNG");
	//	     Pattern complete = new Pattern("F:\\Automation_Selenium\\B2CDemo\\Images\\Completeorder.PNG");
	//		 String imgPath = hp.takeScreenshot(batchId);
	//		String batchid =  hp.getImgText​(imgPath);
	//		
	//		System.out.println("BatchIDtext = "+batchid);
	//	
	//		s.click(batches);
	//	    Thread.sleep(10000);
	//	    s.type(enterid,batchid);
	//	    Thread.sleep(500);
	//	    s.click(search);
	//	    Thread.sleep(10000);
	//	    s.mouseDown(1000);
	//	    s.click(confirm);
	//	    Thread.sleep(10000);
	//	    s.mouseDown(1000);
	//	    s.click(complete);
	//	    Thread.sleep(10000);
	
	}*/
}
