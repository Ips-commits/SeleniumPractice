package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CalendarSelectTest {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub


			System.setProperty("webdriver.gecko.driver","/Users/ippal/Downloads/geckodriver/geckodriver.exe");
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");

			Thread.sleep(2000);

			driver.findElement(By.id("datepicker")).click();
			
			futureDate("January 2025", "30");

//			driver.findElement(By.linkText("25")).click();
	}
		
		
		/**
		 * 
		 * @param expMonthYear
		 * @param day
		 */
		public static void futureDate(String expMonth, String day) {
			
			if(expMonth.contains("February") && Integer.parseInt(day)>29) {
				System.out.println("wrong day is passed for February, please pass the day range between 1 to 29");
				return;
			}
			
			
			if(Integer.parseInt(day)>31) {
				System.out.println("wrong day is passed, please pass the day range between 1 to 31");
				return;
			}
			
			if(Integer.parseInt(day)<=0) {
				System.out.println("wrong day is passed, please pass the day range between 1 to 31");
				return;
			}
			
			
			
			String actMonth = driver.findElement(By.className("ui-datepicker-title")).getText();
			System.out.println(actMonth);//April 2025
			
			while(!actMonth.equalsIgnoreCase(expMonth)) {//July 2025 == July 2025
				//click on next icon:
				driver.findElement(By.xpath("//span[text()='Next']")).click();
				actMonth = driver.findElement(By.className("ui-datepicker-title")).getText();//July 2025
				System.out.println(actMonth);
				String beforexpath="/html[1]/body[1]/div[4]/table[1]/tbody[1]/tr[5]+td[";
				String afterpath="]/a[1]";
				final int totalWeekDays=7;
				for(int rowNum=2;rowNum<=7;rowNum++)
				{
					for(int colNum=1;colNum<=totalWeekDays;colNum++)
					{
						day=driver.findElement(By.xpath(beforexpath+rowNum+afterpath+colNum+"]")).getText();
						System.out.println(day);
					}
				}

			}
			
			
			//html[1]/body[1]/div[4]/table[1]/tbody[1]/tr[5]/td[1]/a[1];
			//html[1]/body[1]/div[4]/table[1]/tbody[1]/tr[5]/td[2]/a[1];
			//html[1]/body[1]/div[4]/table[1]/tbody[1]/tr[5]/td[2]/a[1];
			//html[1]/body[1]/div[4]/table[1]/tbody[1]/tr[5]/td[3]/a[1];
			
			
			/*String beforexpath="/html[1]/body[1]/div[4]/table[1]/tbody[1]/tr[5]+td[";
			String afterpath="]/a[1]";
			final int totalWeekDays=7;
			for(int rowNum=2;rowNum<=7;rowNum++)
			{
				for(int colNum=1;colNum<=totalWeekDays;colNum++)
				{
					day=driver.findElement(By.xpath(beforexpath+rowNum+afterpath+colNum+"]")).getText();
					System.out.println(day);
				}
			}*/		
		}
}
