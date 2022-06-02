package RestTopics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*; 

public class RelativeLocatorsSelenium4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Documents\\SeleniumJavaNotes\\chromedriver_win32 (1)\\chromedriver.exe" );
			WebDriver driver = new ChromeDriver();
			
			driver.get("https://rahulshettyacademy.com/angularpractice/");
			
		WebElement righttext= 	driver.findElement(By.xpath("//label[text()='Employed']"));
	    driver.findElement(with(By.tagName("input")).toLeftOf(righttext)).click();

        WebElement rbt=	  driver.findElement(By.name("inlineRadioOptions"));
       System.out.println( driver.findElement(with(By.tagName("label")).toRightOf(rbt)).getText());	
	}

}
