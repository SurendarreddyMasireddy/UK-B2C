package com.B2C.Core;

public class WebModuleDriver 
{
	public WebControls uiDriver;
	public ReporterClass reporter;
	public UtilityFunctions utilFunctions;
	public String user;
	protected String TestEnvironment =System.getProperty("instance");
	protected String device = System.getProperty("device");
	protected String browser = System.getProperty("browser");
	
	public WebModuleDriver() 
	{
		uiDriver = new WebControls();
		reporter = new ReporterClass();
		utilFunctions = new UtilityFunctions();
		
	}
	
}
