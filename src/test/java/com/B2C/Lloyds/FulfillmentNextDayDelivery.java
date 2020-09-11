package com.B2C.Lloyds;

import java.awt.Robot;

import org.testng.annotations.Test;

import com.B2C.TestCases.BaseTest;
import com.B2C.TestCases.Fulfillment;

public class FulfillmentNextDayDelivery extends BaseTest{
	
	 Fulfillment ff = new Fulfillment();
	 
		
		@Test
		public void NextdayDelivery() throws Exception
		{
			// TODO Auto-generated method stub
				Thread.sleep(9000);
				Robot r = new Robot();
				
				ff.NavigateandLoginFulfillment();
				ff.selectNextDayDeliveryMethod();
				ff.Orders();
				ff.Batch();
				ff.ConfirmOrder();
		}
		 

}
