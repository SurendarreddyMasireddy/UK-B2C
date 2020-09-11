package com.B2C.Core;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.api.robot.Key;
import org.sikuli.api.robot.KeyModifier;
import org.sikuli.script.Button;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class WebControls extends WebDriverClass 
{
	String[] temp;
	public boolean checkURL;
	ObjectRepository obj = new ObjectRepository();
	

	public enum LIST
	{
		ByValue, ByIndex, ByVisibleText
	};

	String browser = System.getProperty("browser");
	String device = System.getProperty("device");
	String applicationType = System.getProperty("applicationType");
	String sPath = System.getProperty("user.dir");
	Screen s = new Screen();
	public UtilityFunctions utilFunctions = new UtilityFunctions();

	public void navitagetoURL(String URL) {
		driver.get(URL);
		ReporterClass.logger.log(Status.PASS, "Successfully Navigated to  URL " + URL);
	}
	
	private WebElement FindElement(String locator, String property) {
		By byElement = null;
		WebElement webelement = null;

		switch (locator) {

		case "id": {
			byElement = By.id(property);
			break;
		}

		case "name": {
			byElement = By.name(property);
			break;
		}

		case "xpath": {
			byElement = By.xpath(property);
			break;
		}
		case "classname": {
			byElement = By.className(property);
			break;
		}
		case "linktext": {
			byElement = By.linkText(property);
			break;
		}
		case "tagname": {
			byElement = By.tagName(property);
			break;
		}
		case "paritallinktext": {
			byElement = By.partialLinkText(property);
			break;
		}
		case "cssSelector": {
			byElement = By.cssSelector(property);
			break;
		}
		default: 
			break;
	}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		webelement = driver.findElement(byElement);

		return webelement;
	}

	private WebElement getWebElement(String property) throws IOException, URISyntaxException 
	{
		String str = obj.getObjectProperties(property);
		temp = str.split(";");
		WebElement webelement = FindElement(temp[0], temp[1]);
		Assert.assertNotNull(webelement);
		return webelement;
	}

	
	public void SetValueForTextBox(String sElement, String pos, String sData) throws Exception
	{
		if (!(browser.equalsIgnoreCase("IE"))) {
			WebElement element = getWebElement(sElement, pos);
			
			if(device.equalsIgnoreCase("tablet"))
				ActionSendData(sElement,pos,sData);
			else {
				while (true) {
					try {
						element.clear();
						Thread.sleep(500);
						element.sendKeys(sData);
						break;
					} 
					catch (StaleElementReferenceException e) {
						System.out.println("catch block");

						continue;
					}
				}
			}
		}
		else
		{
			if(sElement.contains("ItemQty"))
				sElement = "AddQuantity";
			Pattern p = new Pattern(sPath + "\\Images\\" + sElement + ".png");
			s.click(p);
			s.type("a", KeyModifier.CTRL);
			s.type(Key.BACKSPACE);
			Thread.sleep(500);
			s.type(sData);
			Thread.sleep(1500);
		}
		ReporterClass.logger.log(Status.PASS, "Successfully entered value " + sData +" for TextBox " + sElement + pos );

	}
	
	public void SetValueForTextBoxkeydownpressenter(String sElement, String sData) throws Exception 
	{
		if (!(browser.equalsIgnoreCase("IE")))
		{
			WebElement element = getWebElement(sElement);
			element.click();
			Thread.sleep(500);
			element.sendKeys(Keys.DELETE);
			element.clear();
			element.sendKeys(sData);
			if(sElement=="Search")
			{
			element.sendKeys(Keys.ENTER);
			}
			 element.sendKeys(Keys.ARROW_DOWN);
		        Thread.sleep(2000);
		        element.sendKeys(Keys.ENTER);
		}
		else
		{
			Pattern p = new Pattern(sPath + "\\Images\\" + sElement + ".png");
			if(sElement.contains("AddQuantity"))
				p = new Pattern(sPath + "\\Images\\" + sElement + "IE.png");
			s.click(p);
			
			s.type("a", KeyModifier.CTRL);
			s.type(Key.BACKSPACE);
			Thread.sleep(500);
			s.type(sData);
			Thread.sleep(1500);
		}
		ReporterClass.logger.log(Status.PASS, "Successfully entered value " + sData + " for TextBox " + sElement);

	}
	
	
	public void SetValueForTextBox(String sElement, String sData) throws Exception 
	{
		if (!(browser.equalsIgnoreCase("IE")))
		{
			WebElement element = getWebElement(sElement);
			element.click();
			Thread.sleep(500);
			element.sendKeys(Keys.DELETE);
			element.clear();
			element.sendKeys(sData);
			if(sElement=="Search")
			{
			element.sendKeys(Keys.ENTER);
			}
		}
		else
		{
			Pattern p = new Pattern(sPath + "\\Images\\" + sElement + ".png");
			if(sElement.contains("AddQuantity"))
				p = new Pattern(sPath + "\\Images\\" + sElement + "IE.png");
			s.click(p);
			
			s.type("a", KeyModifier.CTRL);
			s.type(Key.BACKSPACE);
			Thread.sleep(500);
			s.type(sData);
			Thread.sleep(1500);
		}
		
		ReporterClass.logger.log(Status.PASS, "Successfully entered value " + sData + " for TextBox " + sElement);

	}

	
	
	public void scrollup() throws FindFailed 
	{
		if (browser.equalsIgnoreCase("ie")) 
		{
			Pattern p = new Pattern(sPath + "\\Images\\scrollup.png");
			s.wheel(p, Button.WHEEL_UP, 3);
		}
	}

	public void TakeScreenshot(String page) throws URISyntaxException, Exception 
	{
		//s.type(page);
		String screenshot = null;
		screenshot = ReporterClass.getScreenshot(page);
		if (!(screenshot == null)) 
		{
			ReporterClass.logger.log(Status.INFO, page + " Screenshot", MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot).build());
			System.out.println("Screenshot was taken");
		}
		else
			System.out.println("Screenshot was not taken");
		Thread.sleep(2000);
	}

	public void MouseScrollup(int pixels) throws FindFailed, Exception
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if(device.equalsIgnoreCase("local"))
			js.executeScript("window.scrollBy(" + pixels + ",0)");
	}

	public void MouseScrolldown(int pixels) throws FindFailed, Exception 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if(device.equalsIgnoreCase("local"))
			js.executeScript("window.scrollBy(0," + pixels + ")");
	}

	public void scrolldown() throws FindFailed, Exception 
	{
		if (browser.equalsIgnoreCase("ie"))
		{
			Pattern p = new Pattern(sPath + "\\Images\\scrolldown.png");
			s.wheel(p, Button.WHEEL_DOWN, 3);
			Thread.sleep(1000);
		}
	}

	public void setFocus(String sElement) throws URISyntaxException, Exception
	{
		WebElement element = getWebElement(sElement);
		element.click();
	}

	public String AlertText(String sElement) throws URISyntaxException, Exception 
	{
		String almessage = null;
		try 
		{
			WebElement element = getWebElement(sElement);
			almessage = element.getText();
			ReporterClass.logger.log(Status.PASS, "message is " + almessage);
		} 
		catch (NoAlertPresentException n) 
		{
			// System.out.println(n);
		}
		return almessage;
	}
	
	public void TapWebElement(String sElement, String pos) throws URISyntaxException, Exception 
	{
		WebElement element = getWebElement(sElement, pos);
		TouchActions action = new TouchActions(driver);
		action.singleTap(element);
		action.perform();
	}

	public void TapWebElement(String sElement) throws URISyntaxException, Exception 
	{
		WebElement element = getWebElement(sElement);
		TouchActions action = new TouchActions(driver);
		action.singleTap(element);
		action.perform();
	}
	
	

	public void SetValueForTextBox(Pattern sElement, String sData)
	{
	
	  try {
		s.type(sElement, sData);
		 ReporterClass.logger.log(Status.PASS, "Successfully entered value " + sData + " for TextBox " + sElement);
	} catch (FindFailed e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		ReporterClass.logger.log(Status.FAIL, "Element not Found");
	}
	 
	}
	
	public void navitage2URL(String URL) {
		s.type(URL);
		ReporterClass.logger.log(Status.PASS, "Successfully Navigated to  URL " + URL);
	}
	
	
	public void ClickOnElement(Pattern sElement, String sName)
	{
	
		try {
			s.click(sElement);
			ReporterClass.logger.log(Status.PASS, "Successfully Clicked on " + sName + " Button\\Link");
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			ReporterClass.logger.log(Status.FAIL, "Button\\Link not Found");
		}
		
	}
	

	public void ClickOnButtonorLink(String sElement, String pos) throws URISyntaxException, Exception
	{
		if (!browser.equalsIgnoreCase("IE")) {
			WebElement element = getWebElement(sElement, pos);
			element.click();
			ReporterClass.logger.log(Status.PASS, "Successfully Clicked on " + sElement + " Button\\Link");
		}
	}
	
	public void ClickOnButtonorLink(String sElement) throws URISyntaxException, Exception
	{
		WebElement element = getWebElement(sElement);
		element.click();

	//	 if (browser.equalsIgnoreCase("chrome") && sElement.equalsIgnoreCase("SignIn") && device.equalsIgnoreCase("local"))
	//	 element.click();
		ReporterClass.logger.log(Status.PASS, "Successfully Clicked on " + sElement + " Button\\Link");
		
		 /*
		 * else if(browser.equalsIgnoreCase("IE") &&
		 * sElement.equalsIgnoreCase("Sortdropdown")) { WebElement element =
		 * getWebElement(sElement); element.click();
		 * 
		 * if (!device.equalsIgnoreCase("local") && sElement.equalsIgnoreCase("SignIn"))
		 * element.click(); ReporterClass.logger.log(Status.PASS,
		 * "Successfully Clicked on " + sElement + " Button\\Link"); }
		 */
	}

	public void ClickOnDropDownIE(String sElement) throws FindFailed
	{
		Pattern p = new Pattern(sPath + "\\Images\\" + sElement + ".png");
		
		if(sElement.contains("AddQuantity"))
			p = new Pattern(sPath + "\\Images\\" + sElement + "IE.png");
		s.click(p);
	}
	
	public String verifyNewTab() throws Exception
	{
		Object[] Tabs = driver.getWindowHandles().toArray();
		driver.switchTo().window(Tabs[1].toString());
		String Title = driver.getTitle();
		
		return Title;
	}
	
	public void closeNewTab() throws Exception
	{
		Object[] Tabs = driver.getWindowHandles().toArray();
		driver.close();
		driver.switchTo().window(Tabs[0].toString());
	}
	
	public int Count(String sElement) throws Exception 
	{
		// count occurrences of the string
		int count = 0;
		
		if ((browser.equalsIgnoreCase("IE")) && sElement.equals("QuickOrder")) {
			try {
				// search for the String within the text
				String str = obj.getObjectProperties("QCRowIndex");
				temp = str.split(";");
				driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				List<WebElement> body = driver.findElements(By.xpath(temp[1]));
				count = body.size();
			} 
			catch (Exception e) {
				// TODO Auto-generated catch block
			}
		}
		else
		{
			try {
				// search for the String within the text
				String str = obj.getObjectProperties(sElement);
				temp = str.split(";");
				driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				List<WebElement> body = driver.findElements(By.xpath(temp[1]));
				count = body.size();
			} 
			catch (Exception e) {
				// TODO Auto-generated catch block
			}
		}
		return count;
	}

	public void SetValueForCheckBox(String sElement) throws URISyntaxException, Exception
	{
		boolean checkstatus;
		WebElement element = getWebElement(sElement);
		checkstatus = element.isSelected();
		if (checkstatus == true) {
			ReporterClass.logger.log(Status.PASS, sElement + " CheckBox is already checked");
		} else {
			element.click();
			ReporterClass.logger.log(Status.PASS, "Successfully Click on " + sElement + " CheckBox");
		}
	}

	public void SetValueForRadio(String sElement) throws URISyntaxException, Exception 
	{
		boolean checkstatus;
		if (!browser.equalsIgnoreCase("ie"))
		{
			WebElement element = getWebElement(sElement);
			checkstatus = element.isSelected();
			if (checkstatus == true)
			{
				ReporterClass.logger.log(Status.PASS, sElement + " RadioButton is already checked");
			} 
			else 
			{
				element.click();
				Thread.sleep(1000);
				element.click();
				ReporterClass.logger.log(Status.PASS, "Successfully Click on " + sElement + "  Radio Button");
			}

		} 
		else 
		{
			Pattern p = new Pattern(sPath + "\\Images\\" + sElement + ".png");
			s.click(p);
			ReporterClass.logger.log(Status.PASS, "Successfully Click on " + sElement + "  Radio Button");
		}
	}


	public void SetValueForList(String sElement, LIST list, String sData) throws Exception 
	{
		WebElement element = getWebElement(sElement);
		switch (list)
		{
			case ByValue: 
				Select list1 = new Select(element);
				list1.selectByValue(sData);
				ReporterClass.logger.log(Status.PASS, "Successfully Selected Value From " + sElement + " List Box " + "with value " + sData);
				break;

			case ByIndex: 
				int sdat = Integer.parseInt(sData);
				Select list2 = new Select(element);
				list2.selectByIndex(sdat);
				ReporterClass.logger.log(Status.PASS, "Successfully Selected Value From " + sElement + " List Box " + "with value " + sData);
				break;

			case ByVisibleText:
				Select list3 = new Select(element);
				list3.selectByVisibleText(sData);
				ReporterClass.logger.log(Status.PASS, "Successfully Selected Value From " + sElement + " List Box " + "with value " + sData);
				break;

			default: 
				throw new Exception();
		}
	}


	public boolean IsElementDisplayed(String sElement) throws Exception {
		boolean svalue = false;

		try {
			String str = obj.getObjectProperties(sElement);
			temp = str.split(";");
			WebElement webelement = FindElement(temp[0], temp[1]);
			svalue = webelement.isDisplayed();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		return svalue;
	}

	public boolean IsElementEnabled(String sElement) throws Exception {
		boolean svalue = false;

		try {
			String str = obj.getObjectProperties(sElement);
			temp = str.split(";");
			WebElement webelement = FindElement(temp[0], temp[1]);
			svalue = webelement.isEnabled();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		return svalue;
	}

	public String GetTextandStoreinVariable(String sElement) throws URISyntaxException, Exception {
		String appvalue = null;
		WebElement element = getWebElement(sElement);
		appvalue = element.getText();
		if (!sElement.equalsIgnoreCase("CartIconCount"))
			ReporterClass.logger.log(Status.PASS, "Successfully fetched Value From " + sElement); //+ " is " + appvalue);

		return appvalue;
	}

	public String checkAlert_Accept() {
		String almessage = null;
		try {
			Alert alert = driver.switchTo().alert();
			almessage = alert.getText();
			alert.accept();
			ReporterClass.logger.log(Status.PASS, " Alert is Present and Text is " + almessage);
		} catch (NoAlertPresentException n) {
			// System.out.println(n);
		}
		return almessage;
	}

	public String checkAlert_Dismiss() {
		String almessage = null;
		try {
			Alert alert = driver.switchTo().alert();
			almessage = alert.getText();
			alert.dismiss();
			ReporterClass.logger.log(Status.PASS, " Alert is Present and Text is " + almessage);
		} catch (NoAlertPresentException n) {
			// System.out.println(n);
		}
		return almessage;
	}

	public void switchToParentWindow() {
		driver.switchTo().defaultContent();
	}

	public void pressKeyEnter(String sElement) throws IOException, URISyntaxException, InterruptedException {
		if (!browser.equals("IE")) {
			WebElement element = getWebElement(sElement);
			element.sendKeys(Keys.ENTER);
		} else {
			Screen s = new Screen();
			s.type(Key.ENTER);
			Thread.sleep(1500);
		}
	}

	public void presstab(String sElement) throws IOException, URISyntaxException
	{
		WebElement element = getWebElement(sElement);
		element.sendKeys(Keys.TAB);
	}
	
	public void hoverClickWebelement(String sElement) throws InterruptedException, Exception, URISyntaxException {
		WebElement element = getWebElement(sElement);
		Actions builder = new Actions(driver);
		Action seriesOfActions = builder.moveToElement(element).click().build();
		seriesOfActions.perform();
		Thread.sleep(2000);
	}
	
	public void ActionSendData(String sElement,String pos, String sData) throws InterruptedException, Exception, URISyntaxException {
		WebElement element = getWebElement(sElement,pos);
		Actions builder = new Actions(driver);
		Action seriesOfActions = builder.moveToElement(element).click().sendKeys(sData).build();
		seriesOfActions.perform();
		Thread.sleep(2000);
	}
	
	public void hoverWebelement(String sElement) throws InterruptedException, Exception, URISyntaxException {
		WebElement element = getWebElement(sElement);
		Actions builder = new Actions(driver);
		Action seriesOfActions = builder.moveToElement(element).build();
		Thread.sleep(2000);
		seriesOfActions.perform();
		Thread.sleep(2000);
	}
	
	public void openNewTab() {
		((JavascriptExecutor) driver).executeScript("window.open()");

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
	}

	public String checkAlert(String sElement) throws URISyntaxException, Exception {
		String almessage = null;
		try {
			WebElement element = getWebElement(sElement);
			// Alert alert = driver.switchTo().alert();
			almessage = element.getText();
			boolean error = almessage.contains("Error");
			boolean success = almessage.contains("Success");
			if (error == true) {
				temp = almessage.split("Error");
				ReporterClass.logger.log(Status.PASS, " Error occured, message is " + temp[1]);
			} else {
				System.out.println("no error");
				if (success == true) {
					temp = almessage.split("Success");
					ReporterClass.logger.log(Status.PASS, " Success, message is " + temp[1]);
				} else
					System.out.println("no success");
			}
		} catch (NoAlertPresentException n) {
			// System.out.println(n);
		}
		return almessage;
	}

	public String GetOption(String sElement) throws Exception
	{
		// Assume driver initialized properly some where else
		WebElement element = getWebElement(sElement);
		Select sel = new Select(element);
		String option = sel.getFirstSelectedOption().getText();
		// String option = element.getAttribute("text");
		return option;
	}
	
	public String GetAttributeValue(String sElement, String attr) throws Exception
	{
		//Returns the required Attribute value of the selected WebElement
		WebElement element = getWebElement(sElement);
		String value = element.getAttribute(attr);
		
		return value;
	}
	
	public String GetAttributeValue(String sElement, String pos, String attr) throws Exception
	{
		//Returns the required Attribute value of the selected WebElement
		WebElement element = getWebElement(sElement, pos);
		String value = element.getAttribute(attr);
		
		return value;
	}

	public boolean IsElementDisplayed(String sElement, String pos) throws Exception
	{
		boolean svalue = false;

		try {
			String str = obj.getObjectProperties(sElement);
			temp = str.split(";");
			WebElement webelement = FindElement(temp[0], temp[1] + pos);
			svalue = webelement.isDisplayed();
		}
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
		}
		return svalue;
	}

	public boolean IsElementEnabled(String sElement, String pos) throws Exception
	{
		boolean svalue = false;

		try {
			String str = obj.getObjectProperties(sElement);
			temp = str.split(";");
			WebElement webelement = FindElement(temp[0], temp[1] + pos);
			svalue = webelement.isEnabled();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		return svalue;
	}

	public String GetTextandStoreinVariable(String sElement, String pos) throws URISyntaxException, Exception 
	{
		String appvalue = null;
		WebElement element = getWebElement(sElement, pos);
		appvalue = element.getText();
		ReporterClass.logger.log(Status.PASS, "Successfully fetched Value From " + sElement);
		return appvalue;
	}

	private WebElement getWebElement(String property, String pos) throws IOException, URISyntaxException 
	{
		String str = obj.getObjectProperties(property);
		temp = str.split(";");
		WebElement webelement = FindElement(temp[0], temp[1] + pos);
		Assert.assertNotNull(webelement);
		return webelement;
	}

	public void RemoveValueForCheckBox(String sElement) throws URISyntaxException, Exception 
	{
		boolean checkstatus;
		WebElement element = getWebElement(sElement);
		checkstatus = element.isSelected();
		if (checkstatus == true) 
		{
			element.click();
			ReporterClass.logger.log(Status.PASS, "Successfully Unchecked on " + sElement + " CheckBox");
		}
		/*
		 * else { ReporterClass.logger.log(Status.PASS, sElement +
		 * " CheckBox is already unchecked"); }
		 */
	}

	public void CheckURL(String Page) throws URISyntaxException, Exception 
	{
		if (!browser.equalsIgnoreCase("IE")) {
			String currURL = driver.getCurrentUrl();
			String URL = null;
			URL = utilFunctions.loadProps().get(Page).toString().trim();
			System.out.println("currURL- " + currURL);
			System.out.println("CheckURL- " + URL);
			Thread.sleep(1500);
			if (currURL.contains(URL)) 
			{
				ReporterClass.logger.log(Status.PASS, "Successfully navigated to " + Page + " Page");
				System.out.println("Successfully navigated to " + Page + " Page");
				checkURL=true;
			}
			else
			{
				ReporterClass.logger.log(Status.FAIL, "Error navigating to " + Page + " Page");
				System.out.println("Error navigating to " + Page + " Page");
				checkURL=false;
			}
		}
		Thread.sleep(1500);
	}

	public void PageReload() throws Exception
	{
		Actions builder = new Actions(driver);
		Action seriesOfActions = builder.sendKeys(Keys.F5).build();
		seriesOfActions.perform();
	}

	public String DoubleClickText(String sElement) throws URISyntaxException, Exception {
		WebElement element = getWebElement(sElement);
		Actions builder = new Actions(driver);
		Action seriesOfActions = builder.doubleClick(element).keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL)
				.build();
		seriesOfActions.perform();

		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		Transferable contents = clipboard.getContents(null);
		String text = (String) contents.getTransferData(DataFlavor.stringFlavor);
		ReporterClass.logger.log(Status.PASS, "Successfully fetched Value From " + sElement + " is " + text);
		return text;
	}
	
	public void ClickkeydownandPressEnter(String sElement) throws IOException, URISyntaxException, InterruptedException
    {
        WebElement element = getWebElement(sElement);
        element.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        element.sendKeys(Keys.ENTER);
    }
	
	
	public void  ScrollMouseDown(int buttons)
	{
		s.mouseDown(buttons);
	}
   public void SetValueforTextboxusingactions(String sElement, String sData) throws IOException, URISyntaxException {
	   WebElement element = getWebElement(sElement);
		Actions builder = new Actions(driver);
		//actions.click(cardnumber).sendKeys(sdata)
		System.out.println("sData"+sData);
		Action seriesOfActions = builder.click(element).sendKeys(sData).keyUp(Keys.CONTROL)
				.build();
		seriesOfActions.perform();
	   
   }

public void ScrollMouseright() {
	// TODO Auto-generated method stub
	//s.type(Keys.RIGHT);
	Actions action = new Actions(driver); 
	action.sendKeys(Keys.RIGHT).build().perform();
}
   }
//actions.click(cardnumber).sendKeys(sdata)

