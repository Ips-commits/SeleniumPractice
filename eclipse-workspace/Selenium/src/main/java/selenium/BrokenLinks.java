package selenium;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrokenLinks {
	
	public static void main(String[] args) throws IOException
	{
	
    System.setProperty("webdriver.gecko.driver","/Users/ippal/Downloads/geckodriver/geckodriver.exe");
	WebDriver driver=new FirefoxDriver();
	driver.manage().window().maximize();
	driver.get("https://www.amazon.in");
	List<WebElement> links=driver.findElements(By.tagName("a"));
	System.out.println("No of links are"+links.size());
	List<String> urllist=new ArrayList<String>();
	for(WebElement e: links)
	{
		String url=e.getAttribute("href");
		urllist.add(url);
		checkBrokenLink(url);
	}
	driver.close();
	driver.quit();	
	}
	public static void checkBrokenLink(String BrokenUrl)
	{
		try {
			URL url=new URL(BrokenUrl);
			HttpURLConnection httpUrlConnection=(HttpURLConnection)url.openConnection();
			httpUrlConnection.setConnectTimeout(5000);
			httpUrlConnection.connect();
			if(httpUrlConnection.getResponseCode()>=400)
			{
				System.out.println(BrokenUrl+"-->is a broken link"+httpUrlConnection.getResponseCode());
			}
			else
			{
				System.out.println(BrokenUrl+"-->"+httpUrlConnection.getResponseCode());
			}						
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
