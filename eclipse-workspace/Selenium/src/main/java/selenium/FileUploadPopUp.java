package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FileUploadPopUp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.gecko.driver","/Users/ippal/Downloads/geckodriver/geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("https://practice.expandtesting.com/upload");
		//driver.findElement(By.id("fileInput")).sendKeys("//enter path for file");
		

	}

}
