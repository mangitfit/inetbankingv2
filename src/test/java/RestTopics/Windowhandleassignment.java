package RestTopics;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Windowhandleassignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Documents\\SeleniumJavaNotes\\chromedriver_win32 (1)\\chromedriver.exe" );
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Multiple Windows")).click();
		driver.findElement(By.cssSelector("a[href*='windows']")).click();
		
	Set <String> windows = 	driver.getWindowHandles();
	           Iterator<String> it =          windows.iterator();
	    String parent =       it.next();
	     String child = it.next();
	   
	    driver.switchTo().window(child);
	     
		System.out.println(driver.findElement(By.xpath("//div/h3")).getText());
		
		driver.switchTo().window(parent);
		System.out.println(driver.findElement(By.xpath("//div/h3")).getText());
	
	    
	}

}
