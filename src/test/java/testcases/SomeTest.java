package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SomeTest {


	public WebDriver driver;

	@BeforeClass
	public void initDriver()
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();		
	}


	@Test
	public void googleTest()
	{
		driver.get("https://www.google.co.in/");

		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys("titanic film wikipedia");
		search.sendKeys(Keys.ENTER);

		WebElement serResult = driver.findElement(By.xpath("//h3[text()='Titanic (1997 film) - Wikipedia']"));
		serResult.click();

		String expTitle="Titanic (1997 film) - Wikipedia";
		String actTitle= driver.getTitle();

		if(expTitle.equals(actTitle))
		{
			System.out.println("Title verification Passed");
		}
		else
		{
			System.out.println("Title verification Failed");
		}

	}

	@AfterClass
	public void closeDriver()
	{
		driver.close();
	}

}
