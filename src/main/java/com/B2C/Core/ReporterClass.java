package com.B2C.Core;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
 
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
 
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
 
 
 
public class ReporterClass extends WebDriverClass
 
{
 
      public ExtentHtmlReporter htmlReporter;
 
      public static ExtentReports report;
 
       public static ExtentTest logger;
 
      public String directory;
 
      public static String sPath;
 
      public static String methodName;
 
      String className = this.getClass().getName();
 
      UtilityFunctions uFunctions = new UtilityFunctions();
 
      static Map<String, String> objectRepositoryData;
 
      static List<String> CellValue;
      
      
 
    
    public void ReportConfiguration() throws Exception
   {
 
      File currentDirectory = new File(new File(".").getAbsolutePath());
 
      String ramdom = uFunctions.GenerateRandomNumber();
 
    
 
      directory = currentDirectory.getCanonicalPath()+"\\target\\HtmlReports";
 
            System.out.println("Report File Path "+directory);
 
            File dir = new File(directory );
 
          if (!dir.exists())
 
          {
 
            dir.mkdirs();
 
          }
 
          
 
            File f = new File(currentDirectory.getCanonicalPath()+"\\target\\HtmlReports\\automationreport.html");
 
            File f2 = new File(currentDirectory.getCanonicalPath()+"\\target\\HtmlReports\\automationreport_"+ramdom+".html");
 
            if(f.exists())
 
            {
 
                  System.out.println("File existed");
 
                  f.renameTo(f2);
 
            }
 
            htmlReporter = new ExtentHtmlReporter(currentDirectory.getCanonicalPath()+"\\target\\HtmlReports\\automationreport.html");
 
                      
 
            report =  new ExtentReports();
 
        report.attachReporter(htmlReporter);
 
            report.setSystemInfo("Host Name", "SoftwareTestingMaterial");
 
            report.setSystemInfo("Environment", "Automation Testing");
 
            report.setSystemInfo("User Name", "Rajkumar SM");
 
        //loading the external xml file (i.e., extent-config.xml) which was placed under the base directory
 
        //You could find the xml file below. Create xml file in your project and copy past the code mentioned below
 
            htmlReporter.loadXMLConfig(new File(this.getClass().getResource("/extent-config.xml").toURI()));
 
            objectRepositoryData = setMapData().get("DataSheet");
 
            CellValue = getSearchData();
 
    }
 
  
 
      private Map<String,Map<String, String>> setMapData() throws URISyntaxException, IOException
 
      {
 
            System.getProperty("user.dir");
 
            Map<String, Map<String, String>> excelFileMap = new HashMap<String, Map<String,String>>();
 
            Map<String, String> dataMap = new HashMap<String, String>();
 
          
 
             FileInputStream file = new FileInputStream(new File(this.getClass().getResource("/objectrepository.xlsx").toURI()));
 
            Workbook workbook = new XSSFWorkbook(file);
 
            Sheet sheet = workbook.getSheetAt(0);
 
            
 
              int lastRow = sheet.getLastRowNum();
 
                        
 
              //Looping over entire row
 
              for(int i=1; i<=lastRow; i++)
 
              {
 
                    Row row = sheet.getRow(i);
 
                  
 
                    //1st Cell as Value
 
                    Cell valueCell = row.getCell(1);
 
                  
 
                    //0th Cell as Key
 
                    Cell keyCell = row.getCell(0);
 
                  
 
                    String value = valueCell.getStringCellValue().trim();
 
                    String key = keyCell.getStringCellValue().trim();
 
                  
 
                    //Putting key & value in dataMap
 
                    dataMap.put(key, value);
 
                  
 
                    //Putting dataMap to excelFileMap
 
                    excelFileMap.put("DataSheet", dataMap);
 
          }
 
              workbook.close();
 
            
 
            // TODO Auto-generated method stub
 
                  return excelFileMap;
 
   }
 
  
 
    
               
                private List<String> getSearchData() throws URISyntaxException, IOException
                {
                                Sheet sheet = null;
                                System.getProperty("user.dir");
                                List<String> excelFileList = new ArrayList<String>();
 
                                FileInputStream file = new FileInputStream(new File(this.getClass().getResource("/B2CTestData.xlsx").toURI()));
                               
                                Workbook workbook = new XSSFWorkbook(file);
                               
                                sheet = workbook.getSheetAt(0);
                               
                               
                                int lastRow = sheet.getLastRowNum();
                               
 
                                //Looping over entire row
                                for (int i = 1; i <= lastRow; i++)
                                {
                                                Row row = sheet.getRow(i);
                                                String value = null;
                                                Cell valueCell;
 
                                                // 0st Cell as Value
                                                valueCell = row.getCell(0);
                                               
                                                value = valueCell.getStringCellValue().trim();
                                               
                                                excelFileList.add(value);
                                }
        workbook.close();
 
        return excelFileList;
   }
 
  
 
    public void StartReport(Method method)
 
    {
 
            try {
 
                  logger = report.createTest((this.getClass().getSimpleName() +" :: "+  method.getName()),method.getName());
 
                  methodName = method.getName();
 
                  System.out.println("Method Name "+ methodName);
 
            } catch (Exception e) {
 
                  // TODO Auto-generated catch block
 
                  e.printStackTrace();
 
            }
 
      }
 

 
    public void getResult(ITestResult result) throws Exception
    {
    	String ApplicationType = System.getProperty("applicationType");
 
        if (result.getStatus() == ITestResult.FAILURE)
        {
        	if(ApplicationType.equalsIgnoreCase("citrix"))
        	{
        		logger.log(Status.FAIL,"Failed");
        	}
        	else
        	{
        		 String screenShot = getBase64Screenshot();
                 logger.log(Status.FAIL,result.getThrowable(),MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot).build());
        	}
           
        }
        else if (result.getStatus() == ITestResult.SKIP)
        {
            logger.log(Status.SKIP, "Test skipped " + result.getThrowable());
        }
        else if(result.getStatus() == ITestResult.SUCCESS)
        {
            logger.log(Status.PASS, "Test passed");
        }
        report.flush();
    }
 
  
 
    public static String getScreenshot(String name) throws IOException        //to take screenshot for every main page
 
    {
 
      SimpleDateFormat sdf2 = new SimpleDateFormat("yyMMMmmss");
 
        sdf2.setTimeZone(TimeZone.getTimeZone("PST"));
 
        String datetime = sdf2.format(new Date());
 
        System.out.println("timeStamp of screenshot: " + datetime);
 
        String encodedBase64 = null;
 
        FileInputStream fileInputStream = null;
 
        TakesScreenshot screenshot = (TakesScreenshot) driver;
 
        File source = screenshot.getScreenshotAs(OutputType.FILE);
 
        sPath = System.getProperty("user.dir");
 
        String destination =sPath+"\\Screenshots\\"+name+datetime+".jpg";
 
        File finalDestination = new File(destination);
 
        FileUtils.copyFile(source, finalDestination);
 
 
 
        try {
 
            fileInputStream =new FileInputStream(finalDestination);
 
            byte[] bytes =new byte[(int)finalDestination.length()];
 
            fileInputStream.read(bytes);
 
            encodedBase64 = new String(Base64.encodeBase64(bytes));
 
        }
 
        catch (FileNotFoundException e)
 
        {
 
            e.printStackTrace();
 
        }
 
        report.flush();
 
        return encodedBase64;
 
    }
 
    public String getBase64Screenshot() throws IOException
 
    {
 
      SimpleDateFormat sdf2 = new SimpleDateFormat("yyMMMmmss");
 
        sdf2.setTimeZone(TimeZone.getTimeZone("PST"));
 
        String datetime = sdf2.format(new Date());
 
        System.out.println("timeStamp: " + datetime);
 
        String encodedBase64 = null;
 
        FileInputStream fileInputStream = null;
 
        TakesScreenshot screenshot = (TakesScreenshot) driver;
 
        File source = screenshot.getScreenshotAs(OutputType.FILE);
 
        sPath = System.getProperty("user.dir");
 
        String destination =sPath+"\\Screenshots\\"+methodName+datetime+".jpg";
 
        File finalDestination = new File(destination);
 
        FileUtils.copyFile(source, finalDestination);
 
 
 
        try {
 
            fileInputStream =new FileInputStream(finalDestination);
 
            byte[] bytes =new byte[(int)finalDestination.length()];
 
            fileInputStream.read(bytes);
 
            encodedBase64 = new String(Base64.encodeBase64(bytes));
 
        }
 
        catch (FileNotFoundException e)
 
        {
 
            e.printStackTrace();
 
        }
 
        report.flush();
 
        return encodedBase64;
 
    }
 
 
 
}
 