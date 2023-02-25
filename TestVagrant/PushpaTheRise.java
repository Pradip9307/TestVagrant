package TestVagrant;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PushpaTheRise {

	@SuppressWarnings("deprecation")
	@Test
	public void validation() {

		System.setProperty("webdriver.chrome.driver", "C:\\Installer\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("https://www.imdb.com/title/tt9389998/");

		// Extracting Country from IMDB
		WebElement PushpaCountryIMDB = driver
				.findElement(By.xpath("//a[@href=\"/search/title/?country_of_origin=IN&ref_=tt_dt_cn\"]"));
		String PushpaCountry = PushpaCountryIMDB.getText();
		System.out.println(PushpaCountry);

		// Extracting release date from IMDB
		driver.findElement(By.xpath("//a[@href=\"/title/tt9389998/releaseinfo?ref_=tt_dt_rdat\"]")).click();
		WebElement PushpaDateIMDB = driver.findElement(By.xpath("(//td[text()='17 December 2021'])[5]"));
		String PushpaDate = PushpaDateIMDB.getText();
		System.out.println(PushpaDate);

		// Extracting Country from Wiki
		// opening wiki on new tab
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://en.wikipedia.org/wiki/Pushpa:_The_Rise");

		// Extracting Country from Wiki
		WebElement PushpaCountryWiki = driver.findElement(By.xpath("//td[text()='India']"));
		String PushpaCountry1 = PushpaCountryWiki.getText();
		System.out.println(PushpaCountry1);

		// Extracting release date from Wiki
		WebElement PushpaDateWiki = driver.findElement(By.xpath("(//div[@class=\"plainlist\"])[4]"));
		String PushpaDate1 = PushpaDateWiki.getText();
	    System.out.println(PushpaDate1);

		// Comparing the country form IMDB and Wiki using assert function in TestNG
		Assert.assertEquals(PushpaCountry, PushpaCountry1);
		System.out.println("Country name on both website are same");

		// Comparing the date form IMDB and Wiki using assert function in TestNG
		Assert.assertEquals(PushpaDate, PushpaDate1);
		System.out.println("Release date on both website are same");
	}
}

