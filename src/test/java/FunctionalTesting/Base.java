package FunctionalTesting;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Documents\\SeleniumJavaNotes\\chromedriver_win32 (1)\\chromedriver.exe" );
			WebDriver driver = new ChromeDriver();
		
			int j=0;
		String[] veggies = {"Carrot", "Brocolli","Betroot"};	//array of items, yahan se check hoga jo bhi name hum selecct kr rae hain vo is list me hai ki nahi
			
			driver.get("https://rahulshettyacademy.com/seleniumPractise/");
			Thread.sleep(3000);
		List<WebElement> products = 	driver.findElements(By.cssSelector("h4.product-name"));
	   
		//iterate through the list of elements till the products.size
		for(int i=0;i<products.size();i++) {
			//Brocolli - 1kg, we need to split it bczweonly want Brocolli and not Brocolli - 1 kg
	String[] name =products.get(i).getText().split("-") ;  //get value will pull one particular value out of those 30 vlues, which value you have to pull that value index you have to pass inside this arguement
			//thi loop will run 30 times and jitne items add krnaa chaho krskte ho
		  //getText matlab us item ka text ya naam for eg. brocolli
	String Formatedname = 	name[0].trim();  //removing white spaces
	//Goal check whether the name you extracted is presnt in array or not
	//simplest way is to convert array to arraylist for easy search
	List itemsNeededList = Arrays.asList(veggies);
	
	   
		  if(itemsNeededList.contains(Formatedname)) {
			  //click on add to cart
			  driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
			  //Cucumber chahiye tha leliye ,ab loop free me kyu chalana hai to break maardo aur bahar nikal aao
			j++;
			 // break; //arraylist concept me break ni lagta
			
			if(j==3) {
				break;  //list ke 3 items aagye , to fir aage kyu chalana loop
			}
		  }
		}
	//ab maanlo aur koi iteam add krne ko kaha gya, to kya jitne baar item ad krna hoga utne baar for loop chalaoge kya, that's a bad practise
	//islye hum ek array banaenge and dthen usko arrayList me convertkrenege usse items exctrct krenge
	}

}
