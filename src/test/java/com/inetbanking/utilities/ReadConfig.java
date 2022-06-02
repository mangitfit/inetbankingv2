package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
	
	public ReadConfig(){  //constructor
		File src = new File("./Configuration/config.properties");  //./ represrting home dorectory
	  try{
	   FileInputStream fis = new FileInputStream(src);  //when you want read the data you have to open the file in read mode so need to use FileInputStream
	   pro = new Properties();
	   pro.load(fis); //load complete file at the runtime
	}
	  catch(Exception e) {
		  System.out.println("Exception is: " + e.getMessage());
	  }
}
	
	//To read each and every variable from the config.propertiesfile we need to craete soe methods
	
	public String getApplicationURL() {
		String url  = pro.getProperty("URL");
		return url;
	}
	
	public String getUsername() {
		String Username = pro.getProperty("Username");
	return Username;
	}
	public String getPassword() {
		String Password = pro.getProperty("password");
	return Password;
	}

	public String getIEPath() {
		// TODO Auto-generated method stub
		String iepath=pro.getProperty("iepath");
		return iepath;
		
	}

	public String getChromePath()
	{
	String chromepath=pro.getProperty("chromepath");
	return chromepath;
	}
}
