package com.Inetbankingv2.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.PageObjects.Loginpage1;



	public class Tc_001 extends Base1{
		
		
		
		@Test
		public void Login() throws InterruptedException, IOException{
	//	try {
		
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Documents\\SeleniumJavaNotes\\SeleniumHybridE-bankingAutomation\\chromedriver_win32\\chromedriver.exe");
		  System.out.println("driver="+driver);
			//WebDriver  driver = new ChromeDriver();
			driver= new ChromeDriver();
			driver.get(baseURL);
			Loginpage1 lp = new Loginpage1(driver);
			lp.setUserName(username);
			lp.setPassword(password);
			lp.clickSubmit();
			
			
			if(driver.getTitle().equals("Guru99 Bank Manager Homepage")) {
				Assert.assertTrue(true);
				}
			else {
				//calling screenshot method when fail
				captureScreen( driver , "Login");  //String tname = tcname = login
				Assert.assertTrue(false);
			}
		//}
		
	//	catch(NullPointerException e) {
		//	System.out.println(e);
		}
		}
		
	//	}
			

	
	
