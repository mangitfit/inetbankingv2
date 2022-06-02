package com.inetbanking.utilities;

//Listener class used to generate extent report
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter{
	
	public ExtentReports extent;
	public ExtentTest logger;


	public void onStart(ITestContext testContext) {  //So ITestContext is used to store and share data across the tests in selenium by using the TestNG framework
		
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); //time stamp
	    String repName = "Test-Report- "+timestamp+".html";
	
	
	//step1 - create Extent html reporter class and pass file name//step2 - create Extent reports and attach reporter(s)
    
	    ExtentSparkReporter htmlreporter = new ExtentSparkReporter(System.getProperty("user.dir")+ "/test-output/"+repName); //specify location
     try {
		htmlreporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

    ExtentReports extent = new ExtentReports();
    
    //attach reporter
    extent.attachReporter(htmlreporter);
    extent.setSystemInfo("Host name" ,"localhost");
    extent.setSystemInfo("Environment","QA");
    extent.setSystemInfo("user","manthan");
    
    //setting confog properties
    
    htmlreporter.config().setDocumentTitle("InetBankingv2 Test Project");  //title of report
    htmlreporter.config().setReportName("Functional Test Automation Report"); //name of the repot
 //   htmlreporter.config().setTestViewChartLocation(ChartLocation.TOP); //location of the chart
	}
  public void onTestSuccess(ITestResult tr) {
	  
	  logger = extent.createTest(tr.getName());  //create new entry in the report
	logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
}
  
  public void onTestFailure(ITestResult tr) {
	  logger = extent.createTest(tr.getName());
	  logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
	  
	 String screenshotPath = System.getProperty("user.dir")+"//Screenshots\\" +tr.getName() +".png";
  
   File f = new File(screenshotPath);
   
   if(f.exists()){
	   logger.fail("Screenshot is below:"+ logger.addScreenCaptureFromPath(screenshotPath));
  }
  
 /*  public void onTestSkipped(ITestResult tr)
	{
		logger=extent.createTest(tr.getName()); // create new entry in th report
		logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
	}
	
	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	}*/
  }
}

