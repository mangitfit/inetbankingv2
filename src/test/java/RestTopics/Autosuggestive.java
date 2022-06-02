package RestTopics;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Autosuggestive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Documents\\SeleniumJavaNotes\\chromedriver_win32 (1)\\chromedriver.exe" );
	WebDriver driver = new ChromeDriver();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  //imp
	driver.get("https://yahoo.com/");
	
	//entering Java keywrd in yahoo search box
	driver.findElement(By.id("yschsp")).sendKeys("java");
	
	//to select all the elements with text suggested after entering java in the serach box
	
  List<WebElement> list = 	driver.findElements(By.xpath("//li[@class='sa-item prog-sugg']//span"));
	
      System.out.println("" + list.size());
     
     for(WebElement itemlist:list ) {
    	 if (itemlist.getText().equals("java download")) {
    		 itemlist.click();
    		 break;
    	 }
     }
	}

}
