package Data;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TerstExcel {

	WebDriver d;

	@BeforeSuite
	public void launch() {
		System.setProperty("webdriver.chrome.driver", "D:\\MS OFFICE\\Chromedriver.exe");
		d = new ChromeDriver();
		d.get("http://opensource.demo.orangehrmlive.com/");
		d.manage().window().maximize();

	}

	@Test(dataProvider = "getdata")
	public void test(String username, String password) throws Exception {
		System.out.println("user " + username + "pass " + password);
		d.findElement(By.id("txtUsername")).sendKeys(username);
		d.findElement(By.id("txtPassword")).sendKeys(password);
		d.findElement(By.name("Submit")).click();
		Thread.sleep(2200);
		d.findElement(By.id("txtUsername")).clear();
		d.findElement(By.id("txtPassword")).clear();

	}

	@DataProvider
	public static Object[][] getdata() {

		ExcelReader e = new ExcelReader("F:\\Selenium programs\\Post Action\\DataDriven\\src\\Data\\Suite1.xlsx");
		String sheetname = "Sunil";
		String TestCase = "TestA4";
		int testrowno = 1; // TestA1
		while (!e.getCellData(sheetname, 0, testrowno).equalsIgnoreCase(TestCase)) {
			testrowno++;
		}
		System.out.println("testnoum no  " + testrowno);

		int colstartsno = testrowno + 1; // iteration
		int datastartsno = colstartsno + 1; // 1

		System.out.println("Colstarts no " + colstartsno);
		System.out.println("datastartsno  " + datastartsno);

		int cols = 0;
		while (!e.getCellData(sheetname, cols, colstartsno).trim().equalsIgnoreCase("")) {
			cols++;
		}
		System.out.println("total no of col " + cols);

		int rows = 0;
		while (!e.getCellData(sheetname, 0, datastartsno + rows).equalsIgnoreCase("")) {
			rows++;
		}
		System.out.println("Total no of row " + rows);

		Object[][] data = new Object[rows][cols];

		// Printing the data form the excel
		System.out.println("************TEST DATA PRINTING**************");
		for (int row = datastartsno; row < datastartsno + rows; row++) {
			for (int col = 0; col < cols; col++) {

				System.out.println(e.getCellData(sheetname, col, row));
				data[row - datastartsno][col] = e.getCellData(sheetname, col, row);
			}
		}
		return data;
	}
	
}
