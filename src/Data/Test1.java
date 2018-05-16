package Data;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test1 {

	WebDriver d;

	// @BeforeSuite
	public void launch() {
		System.setProperty("webdriver.chrome.driver", "D:\\MS OFFICE\\Chromedriver.exe");
		d = new ChromeDriver();
		d.get("http://opensource.demo.orangehrmlive.com/");
		d.manage().window().maximize();

	}

	@Test(dataProvider = "getdata")
	public void test(String username, String password ) throws Exception {
		System.out.println("user " + username + "pass " + password);
		// d.findElement(By.id("txtUsername")).sendKeys(username);
		// d.findElement(By.id("txtPassword")).sendKeys(password);
		// d.findElement(By.name("Submit")).click();
		Thread.sleep(2200);
		// d.findElement(By.id("txtUsername")).clear();
		// d.findElement(By.id("txtPassword")).clear();
		System.out.println("sdf");
	}

	@DataProvider
	public static Object[][] getdata() {
		ExcelReader e = new ExcelReader("F:\\Selenium programs\\Post Action\\DataDriven\\src\\Data\\Suite1.xlsx");

		String sheetname = "Sunil";
		String TestCaseName = "TestA2";

		int TestRowno = 1;

		while (!e.getCellData(sheetname, 0, TestRowno).equalsIgnoreCase(TestCaseName)) {
			TestRowno++;

		}
		System.out.println(" testrowno :" + TestRowno);

		int colstartsno = TestRowno + 1;
		int Datastartsno = colstartsno + 1;

		System.out.println(" col start " + colstartsno);
		System.out.println(" Data start " + Datastartsno);

		int cols = 0;
		while (!e.getCellData(sheetname, cols, colstartsno).equalsIgnoreCase("")) {
			cols++;
		}
		System.out.println("cols " + cols);

		int rows = 0;
		while (!e.getCellData(sheetname, rows, Datastartsno + rows).equalsIgnoreCase("")) {
			rows++;
		}
		System.out.println("Rows " + rows);

		Object[][] data = new Object[rows][cols];

		for (int row = Datastartsno; row < Datastartsno + rows; row++) {

			for (int col = 0; col < cols; col++) {

				data[row - Datastartsno][col] = e.getCellData(sheetname, col, row);
				System.out.println("ssssss");

				System.out.println(e.getCellData(sheetname, col, row));
			}

		}
		return data;
	}
}