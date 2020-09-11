package com.B2C.TestCases;

import java.io.IOException;
import java.net.URISyntaxException;

import com.B2C.Core.WebModuleDriver;

public class ShippingPage extends WebModuleDriver
{
	
	
	public void StandardShipping(String Email1,String Fname, String Lname, String Address1, String Address2, String City, String PostalCode) throws IOException, URISyntaxException, Exception
	{
	uiDriver.SetValueForTextBox("EmailInfo",utilFunctions.loadProps().get(Email1).toString());
	uiDriver.ClickOnButtonorLink("DeliverytoUKAddress_Radiobutton");
	uiDriver.SetValueForTextBox("Firstname",utilFunctions.loadProps().get(Fname).toString());
	uiDriver.SetValueForTextBox("Lastname",utilFunctions.loadProps().get(Lname).toString());
	uiDriver.SetValueForTextBox("Address1",utilFunctions.loadProps().get(Address1).toString());
	uiDriver.SetValueForTextBox("Address2",utilFunctions.loadProps().get(Address2).toString());
	uiDriver.SetValueForTextBox("City",utilFunctions.loadProps().get(City).toString());
	uiDriver.ClickOnButtonorLink("Country1");
	Thread.sleep(500);
	uiDriver.ClickOnButtonorLink("Country2");
	Thread.sleep(500);
	uiDriver.SetValueForTextBox("PostCode",utilFunctions.loadProps().get(PostalCode).toString());

	Thread.sleep(3000);
	uiDriver.ClickOnButtonorLink("Continuetoshopping");
	Thread.sleep(1500);
	//uiDriver.ClickOnButtonorLink("ShippingMethod_Standard");
	uiDriver.TakeScreenshot("Info");
	//uiDriver.ClickOnButtonorLink("DeliverytoUKAddress_Radiobutton");
	uiDriver.ClickOnButtonorLink("ContinuetoPayment");
	Thread.sleep(5000);
	
	
	}
	
	public void NextdayShipping(String Email1,String Fname, String Lname, String Address1, String Address2, String City, String PostalCode) throws IOException, URISyntaxException, Exception
	{
	uiDriver.SetValueForTextBox("EmailInfo",utilFunctions.loadProps().get(Email1).toString());
    uiDriver.ClickOnButtonorLink("DeliverytoUKAddress_Radiobutton");
	uiDriver.SetValueForTextBox("Firstname",utilFunctions.loadProps().get(Fname).toString());
	uiDriver.SetValueForTextBox("Lastname",utilFunctions.loadProps().get(Lname).toString());
	uiDriver.SetValueForTextBox("Address1",utilFunctions.loadProps().get(Address1).toString());
	uiDriver.SetValueForTextBox("Address2",utilFunctions.loadProps().get(Address2).toString());
	uiDriver.SetValueForTextBox("City",utilFunctions.loadProps().get(City).toString());
	//uiDriver.SetValueForList("Country1",List ByVisibleText,"Country2");
	uiDriver.ClickOnButtonorLink("Country1");
	Thread.sleep(500);
	uiDriver.ClickOnButtonorLink("Country2");
	Thread.sleep(500);
	uiDriver.SetValueForTextBox("PostCode",utilFunctions.loadProps().get(PostalCode).toString());
	Thread.sleep(3000);
	uiDriver.ClickOnButtonorLink("Continuetoshopping");
	Thread.sleep(1500);
	uiDriver.ClickOnButtonorLink("ShippingMethod_NextDay");
	uiDriver.TakeScreenshot("Info");
	//uiDriver.ClickOnButtonorLink("DeliverytoUKAddress_Radiobutton");
	uiDriver.ClickOnButtonorLink("ContinuetoPayment");
	
	}
	
	public void ClickandCollectInStore(String Email1,String Fname, String Lname,String Address1, String Address2, String City, String PostalCode) throws IOException, URISyntaxException, Exception
    {
    uiDriver.SetValueForTextBox("EmailInfo",utilFunctions.loadProps().get(Email1).toString());
    uiDriver.ClickOnButtonorLink("ClickandCollectInStore_Radiobutton");
    Thread.sleep(2000);
    uiDriver.MouseScrolldown(500);
    Thread.sleep(3000);
    uiDriver.SetValueForTextBoxkeydownpressenter("PostalCode",utilFunctions.loadProps().get(PostalCode).toString());
    Thread.sleep(5000);
    uiDriver.ClickkeydownandPressEnter("PostalCode");
    Thread.sleep(1000);
    uiDriver.MouseScrolldown(500);
    uiDriver.ClickOnButtonorLink("ChoosethisStore");
//    uiDriver.SetValueForTextBox("Firstname",utilFunctions.loadProps().get(Fname).toString());
//	uiDriver.SetValueForTextBox("Lastname",utilFunctions.loadProps().get(Lname).toString());
//	uiDriver.SetValueForTextBox("Address1",utilFunctions.loadProps().get(Address1).toString());
//	uiDriver.SetValueForTextBox("Address2",utilFunctions.loadProps().get(Address2).toString());
//	uiDriver.SetValueForTextBox("City",utilFunctions.loadProps().get(City).toString());
//	//uiDriver.SetValueForList("Country1",List ByVisibleText,"Country2");
//	uiDriver.ClickOnButtonorLink("Country1");
//	Thread.sleep(500);
//	uiDriver.ClickOnButtonorLink("Country2");
//	Thread.sleep(500);
//	uiDriver.SetValueForTextBox("PostCode",utilFunctions.loadProps().get(PostalCode).toString());
//	Thread.sleep(3000);
//	uiDriver.ClickOnButtonorLink("Continuetoshopping");
//	Thread.sleep(1500);
//	uiDriver.ClickOnButtonorLink("ShippingMethod_Click&Collect");
//	uiDriver.TakeScreenshot("Info");
//	//uiDriver.ClickOnButtonorLink("DeliverytoUKAddress_Radiobutton");
//	uiDriver.ClickOnButtonorLink("ContinuetoPayment");
    Thread.sleep(2000);
    uiDriver.SetValueForTextBox("Firstname",utilFunctions.loadProps().get(Fname).toString());
    uiDriver.SetValueForTextBox("Lastname",utilFunctions.loadProps().get(Lname).toString());
    Thread.sleep(3000);
    uiDriver.ClickOnButtonorLink("ContinueToCollection");
    Thread.sleep(3000);
    uiDriver.ClickOnButtonorLink("ContinuetoPayment");
    }
}
