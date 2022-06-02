package RestTopics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Documents\\SeleniumJavaNotes\\chromedriver_win32 (1)\\chromedriver.exe" );
			WebDriver driver = new ChromeDriver();
	
			driver.get("https://rahulshettyacademy.com/angularpractice/");
			
			driver.findElement(By.name("name")).sendKeys("manthan");
			driver.findElement(By.name("email")).sendKeys("gsinnarkar015@gmail.com");
			driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123456");
			driver.findElement(By.id("exampleCheck1")).click();
			
			//driver.findElement(By.id("exampleFormControlSelect1"))
			//Handling static dropdown
		//	WebElement dropdown = driver.findElement(By.id("exampleFormControlSelect1"));

			//Select abc = new Select(dropdown);
			//abc.selectByVisibleText("Male");
	    driver.findElement(By.id("inlineRadio1")).click();
	    driver.findElement(By.name("bday")).sendKeys("12/21/1997");
	    driver.findElement(By.cssSelector("input[type='submit']")).click();
	
	}

}
