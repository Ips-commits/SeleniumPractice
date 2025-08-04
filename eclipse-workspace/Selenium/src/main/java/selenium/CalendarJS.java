package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;



public class CalendarJS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.gecko.driver","/Users/ippal/Downloads/geckodriver/geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.spicejet.com/");
		WebElement date=driver.findElement(By.xpath("//div[contains(text(),'Tue, 3 Jun 2025')]"));
		String dateVal="Thu,19 Jun 2025";
		selectDateByJS(driver,date,dateVal);
	}
	public static void selectDateByJS(WebDriver driver,WebElement element,String dateVal)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value','"+dateVal+"');",element);
		
	}

}
