package RestTopics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarUI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Documents\\SeleniumJavaNotes\\chromedriver_win32 (1)\\chromedriver.exe" );
			WebDriver driver = new ChromeDriver();
			
			driver.get("https://www.makemytrip.com/");
			
			driver.findElement(By.cssSelector("div[xpath='1']"));
			while(!driver.findElement(By.cssSelector("div[xpath='1']")).getText().contains("July 2022")) {
				driver.findElement(By.cssSelector("[class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
			}
			
	}

}
