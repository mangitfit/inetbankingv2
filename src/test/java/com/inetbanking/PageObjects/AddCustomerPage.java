package com.inetbanking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	
	WebDriver driver;
	
	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "New Customer") 
	@CacheLookup
	WebElement txtlinktext;
	
	@FindBy(name = "name")
	@CacheLookup
	WebElement txtCustomername;
	
	@FindBy(name = "rad1")
	@CacheLookup
	WebElement txtGenderName;
	
	@FindBy(name = "dob")
	@CacheLookup
	WebElement txtdob;
	
	@FindBy(name = "addr")
	@CacheLookup
	WebElement txtaddress;
	
	
	@FindBy(name = "city")
	@CacheLookup
	WebElement txtcity;
	
	@FindBy(name = "state")
	@CacheLookup
	WebElement txtstate;

	@FindBy(name = "pinno")
	@CacheLookup
	WebElement txtpincode;
	
	@FindBy(name = "telephoneno")
	@CacheLookup
	WebElement txttelephoneno;
	
	@FindBy(name = "emailid")
	@CacheLookup
	WebElement txtemailid;
	
	@FindBy(name = "password")
	@CacheLookup
	WebElement txtpassword;
	
	@FindBy(name = "sub")
	@CacheLookup
	WebElement txtsub;
	
	
	
	//Action methods
	
	public void AddNewCustomer() {
		txtlinktext.click();
	}
	
	public void custName(String cname) {
		txtCustomername.sendKeys(cname);
		}
	
	public void custGender(String cgender) {
		txtGenderName.sendKeys(cgender);
		}
	
	public void custDob(String mm, String dd,String yy) {
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);
	}
	
	public void custAddress(String address) {
		txtaddress.sendKeys(address);
		}
	public void custcity(String ccity) {
		txtcity.sendKeys(ccity);
		}
	
	public void custState(String cstate) {
		txtstate.sendKeys(cstate);
		}
	
	public void custpincode(String cpincode) {  //incase you are passing as number (int - 
		txtpincode.sendKeys(cpincode);         //(String.valueOf(cpincode))
		}
	
	public void custTelephone(String ctelephoneno) {
		txttelephoneno.sendKeys(ctelephoneno);
		}
	
	public void custemailid(String cemailid) {
		txtemailid.sendKeys(cemailid);
		}
	
	public void custPassword(String cpwd) {
		txtpassword.sendKeys(cpwd);
		}
	
	public void submit() {
		txtsub.click();;
		}
}


