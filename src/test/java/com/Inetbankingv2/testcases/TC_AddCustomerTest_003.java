package com.Inetbankingv2.testcases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;

import com.inetbanking.PageObjects.AddCustomerPage;
import com.inetbanking.PageObjects.Loginpage1;

import junit.framework.Assert;

public class TC_AddCustomerTest_003 extends Base1 {

	public void AddNewCustomer() throws InterruptedException, IOException
	{
		//to add new customer first you have to login then can add customer, so two pageobject classses will be used -login and addcustimerpage
	
		Loginpage1 lp = new Loginpage1(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickSubmit();
		
		Thread.sleep(3000);  //after login wait for sometime
 	
		//now creating objects of addcustomer pageobject
	  	
		AddCustomerPage acp = new AddCustomerPage(driver);
		acp.AddNewCustomer();
		
		acp.custName("Manthan");
		acp.custGender("male");
		acp.custDob("12", "21", "1997");
		Thread.sleep(3000); //as it takes time to load all values
	   acp.custAddress("India");
	   acp.custState("MP");
      acp.custcity("Katni");	
      acp.custpincode("483501");
	  acp.custTelephone("9165685781");
	  
	  //regarding email address- every customer should have a unique email address ek baar to pass hojaaega but baar baar ni
	 // acp.custemailid("gsinnarkar015@gmail.com");
	   String email=    RandomString() + "@gmail.com";
	   acp.custemailid(email);  //this is how email id is added dyananmically
	  acp.custPassword("abcdef");
	  acp.submit();
	  
	  //validating the below message comes after entering all the details
	   boolean res =     driver.getPageSource().contains("Customer registered successfully");
	  
	   if(res==true) {
		   Assert.assertTrue(true);
	   }
	   else {
		   
		   //failing capture screnshot
		   captureScreen(driver, "AddNewCustomer"); // parameters - driv er & testcasename
		   Assert.assertTrue(false);
	   }
	}
	
	public String RandomString() {   //this method will generated a random string of 8 caharacters
		    String generatedstring = RandomStringUtils.randomAlphabetic(8);
      return (generatedstring);
	}
}
