package Datadriven;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Data.ExcelReader;

public class TerstExcelwithhasttable {

	WebDriver d;

	@BeforeSuite
	public void launch() {
		System.setProperty("webdriver.chrome.driver", "D:\\MS OFFICE\\Chromedriver.exe");
		d = new ChromeDriver();
		d.get("http://opensource.demo.orangehrmlive.com/");
		d.manage().window().maximize();

	}

	@Test(dataProvider = "getdata")
	public void test(Hashtable<String, String> data) throws Exception {
		// System.out.println("user " + username + "pass " + password);
		d.findElement(By.id("txtUsername")).sendKeys(data.get("username"));
		d.findElement(By.id("txtPassword")).sendKeys(data.get("password"));
		d.findElement(By.name("Submit")).click();
		Thread.sleep(2200);
		d.findElement(By.id("txtUsername")).clear();
		d.findElement(By.id("txtPassword")).clear();

	}

	@DataProvider
	public static Object[][] getdata() {
		ExcelReader e = new ExcelReader("F:\\Selenium programs\\Post Action\\DataDriven\\src\\Data\\Suite1.xlsx");
		return dataprovider.getdata("TestA4", e);
	}
}
