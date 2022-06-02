package com.Inetbankingv2.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.PageObjects.Loginpage1;
import com.inetbanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends Base1{

	//here there will be one test method and one data provider method ,
	//data provider will provide data to gtest ,method
	
	@Test(dataProvider ="Logindata")
	public void LoginDDT(String user,String pwd) {  //actual test method should read the data from the excel and exceute multiple times
		
    //linking to the pageobject
		
		Loginpage1 lp = new Loginpage1(driver);
		lp.setUserName(user);
		lp.setPassword(pwd);
		lp.clickSubmit();
	
	  //calling isAlertPreset method
		
		if(isAlertPresent() ==true) {
			driver.switchTo().alert().accept(); //clsoe alert
			driver.switchTo().defaultContent();  //move back to previous page
		Assert.assertTrue(false);  //false - as this is teh failure case
		}
		else {
			Assert.assertTrue(true); // passed
		}
	
	
	}
	
	//Validating alerts
	
	public boolean isAlertPresent() { //userdefined method created to check if alert is present or not
		try {
		driver.switchTo().alert(); //if gthe alert is not present it will throw an exception
		return true;  //if the alert is present
		}
		catch(Exception e) {
			return false;
		}
		}
	
	
	
	//internally @dataprovider will read the data from excel and store it in 2d array
	
	@DataProvider(name = "Logindata") //whenever we use dataprovider annotation need to provide some name
	String [][] getData() throws IOException{ // retun type is string
		
		//excel path     //till user.dir will give you projet homedirectory
		String path = System.getProperty("user.dir")+ "/src/test/java/com/inetbanking/testdata/Logindata.xlsx";
		
		int rownum = XLUtils.getRowCount(path, "sheet1");
		int colcount = XLUtils.getCellCount(path ,"sheet1" , 1);
	
	//create 2d array before storin value intoit
		String logindata[][] = new String [rownum][colcount];  //rows and cols
	
	
	//get data from excel into 2d array
		
	for(int i =1;i<rownum;i++) {
		for(int j=0;j<colcount;j++) {
			//1st row in array will be xlfile row -1  ,ie 1 in excel is 0 in array- bcx first row jo h excel me usme heading dala hai
			logindata[i-1][j] = XLUtils.getCellData(path, "sheet1", i, j);
		}
	}
	
	//after completion of this forloop we need to send data to the actual test method
	
	return logindata;
	}
}
