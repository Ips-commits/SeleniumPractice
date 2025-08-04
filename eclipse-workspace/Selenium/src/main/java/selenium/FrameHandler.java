package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FrameHandler {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.gecko.driver","/Users/ippal/Downloads/geckodriver/geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.londonfreelance.org/courses/frames/index.html");
		
		int framecount=driver.findElements(By.tagName("frame")).size();
		System.out.print(framecount);
		
		//driver.switchTo().frame(3);
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@src='top.html']")));
		
		String header = driver.findElement(By.tagName("h2")).getText();
		System.out.println(header);
				
		driver.quit();

	}

}
