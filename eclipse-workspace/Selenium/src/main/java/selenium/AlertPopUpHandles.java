package selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AlertPopUpHandles {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.gecko.driver","/Users/ippal/Downloads/geckodriver/geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		Thread.sleep(2000);
		
		Alert alert=driver.switchTo().alert();
		String text = alert.getText();
		System.out.print(text);
		
		alert.sendKeys("Test Alert Automation");
		Thread.sleep(3000);
		//alert.accept();
		alert.dismiss();
		
		driver.quit();


	}

}
