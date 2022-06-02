package RestTopics;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssignmentExlplicitWait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Documents\\SeleniumJavaNotes\\chromedriver_win32 (1)\\chromedriver.exe" );
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			
			driver.get("https://rahulshettyacademy.com/loginpagePractise/");
			driver.findElement(By.name("username")).sendKeys("rahulshettyacademy");
			driver.findElement(By.name("password")).sendKeys("learning");
			//driver.findElement(By.xpath("//input[@type='radio']")).click();
			//explicit wait
		//	WebDriverWait w = new WebDriverWait(driver,5);
		//	w.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".checkmark")));
			
	//  driver.findElement(By.cssSelector(".checkmark")).click();
			driver.findElement(By.cssSelector(".customradio:nth-child(2)")).click();
			//System.out.println(driver.findElement(By.cssSelector(".customradio:nth-child(2)")).isSelected()); 
			
			WebDriverWait w = new WebDriverWait(driver,10);
			
				w.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
			
			driver.findElement(By.id("okayBtn")).click();
			
			//select static dropdown
			WebElement staticdropdown = driver.findElement(By.xpath("//Select[@class='form-control']"));
			Select s = new Select(staticdropdown);
			
			s.selectByIndex(2);
			
			
			//WebDriverWait w1 = new WebDriverWait(driver,5);
			//w1.until(ExpectedConditions.visibilityOfElementLocated(By.id("signInBtn")));
			driver.findElement(By.id("signInBtn")).click();
			
		List<WebElement>products=	driver.findElements(By.cssSelector(".card-footer.btn.btn-info"));
			for(int i=0;i<products.size();i++) {
				products.get(i).click();
				
				}
			
			//WebDriverWait w2 = new WebDriverWait(driver,10);
			//w2.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Checkout")));
		  driver.findElement(By.partialLinkText("Checkout")).click();
	}

}
