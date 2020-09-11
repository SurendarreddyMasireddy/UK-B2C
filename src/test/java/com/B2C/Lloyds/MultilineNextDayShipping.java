package com.B2C.Lloyds;

import org.testng.annotations.Test;

import com.B2C.TestCases.BaseTest;
import com.B2C.TestCases.HomePage;
import com.B2C.TestCases.LLoydsLogin;
import com.B2C.TestCases.ShippingPage;

public class MultilineNextDayShipping extends BaseTest {
	LLoydsLogin sLogin = new LLoydsLogin();
	HomePage homePage = new HomePage();
	ShippingPage shippingpage= new ShippingPage();
	
	
	@Test(priority=1)
	public void NextdayShipping_Multiline() throws Exception
	{
		//Login to B2C Website
		sLogin.NavigateandLoginB2C("Email" ,"Pwd" );
		Thread.sleep(2000);
		homePage.Clickalert();
		Thread.sleep(2000);
		homePage.searchMultipleProducts();
		shippingpage.NextdayShipping("Email1", "Fname", "Lname", "Address1", "Address2","City", "PostalCode");
		Thread.sleep(2000);
		homePage.Payment("CardNumber", "NameonCard", "Expirationdate", "SecurityCode", "SameasShippingAddress");
	}
}


