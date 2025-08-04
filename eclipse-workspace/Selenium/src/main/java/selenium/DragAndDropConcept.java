package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropConcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.gecko.driver","/Users/ippal/Downloads/geckodriver/geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
		
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.id("draggable"))).
		clickAndHold().moveToElement(driver.findElement(By.id("droppable"))).
		release().
		build().
		perform();
		
		driver.close();
		driver.quit();

	}

}
