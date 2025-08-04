package selenium;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class HandleWindowPopUp {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.gecko.driver","/Users/ippal/Downloads/geckodriver/geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.orangehrm.com/30-day-free-trial");
		
		Actions act = new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).perform();
		
		driver.findElement(By.linkText("OrangeHRM")).click();
		Thread.sleep(2000);
		
		Set<String> handles = driver.getWindowHandles();
		
		Iterator<String> it = handles.iterator();
		
		String parentWindowID = it.next();
		System.out.println("parent window id: "+ parentWindowID);
		
		String childWindowID = it.next();
		System.out.println("child window id: "+ childWindowID);
		Thread.sleep(2000);
		
		driver.switchTo().window(childWindowID);	
		System.out.println("child window title : "+ driver.getTitle());
		
		driver.close();
		
		driver.switchTo().window(parentWindowID);
		System.out.println("Parent window title:"+driver.getTitle());
				
				
		driver.quit();	

	}

}
