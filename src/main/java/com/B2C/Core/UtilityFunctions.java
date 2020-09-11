package com.B2C.Core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class UtilityFunctions 
{
	public  enum Mode {ALPHA, ALPHANUMERIC, NUMERIC}
	
	public String GenerateRandomNumber()
	{
		Date date = new Date() ;
		SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyHHmmss") ;
		String ramnumber = dateFormat.format(date);
		System.out.println("GenerateRandomNumber "+ramnumber);
		return ramnumber;

	}
	
	public String GenerateRandom(int length,Mode mode)
    {
          StringBuffer buffer = new StringBuffer();
          String characters = "";

          switch(mode)
          {
          
          case ALPHA:
                 characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
                 break;
          
          case ALPHANUMERIC:
                 characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
                 break;
    
          case NUMERIC:
                 characters = "1234567890";
              break;
          }
          
          int charactersLength = characters.length();

          for (int i = 0; i < length; i++) 
          {
                 double index = Math.random() * charactersLength;
                 buffer.append(characters.charAt((int) index));
          }
          return buffer.toString();
          
    }
	
	
	public String getValuesFromPropertiesFile(String propertiesFileName,String key)
	{

		try
		{
			File file = new File(this.getClass().getResource("/"+propertiesFileName+".properties").toURI());
			FileInputStream fis = new FileInputStream(new File(file.toString()));
			Properties prop=new Properties();
			prop.load(fis);
			return prop.get(key).toString();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public Properties loadProps() throws IOException, URISyntaxException
	{
		
		FileInputStream fis = new FileInputStream(new File(this.getClass().getResource("/config.properties").toURI()));
		Properties config = new Properties();
		config.load(fis);
		return config;
	}

}
