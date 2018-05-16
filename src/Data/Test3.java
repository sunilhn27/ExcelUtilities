package Data;

public class Test3 {

	public static void main(String[] args) {

		ExcelReader excel = new ExcelReader("F:\\Selenium programs\\Post Action\\DataDriven\\src\\Data\\Suite1.xlsx");

		String SheetName = "Sunil";
		String TestCaseName = "TestA1";

		int TestRowno = 1;
		while (!excel.getCellData(SheetName, 0, TestRowno).equalsIgnoreCase(TestCaseName)) {
			TestRowno++;

		}
		System.out.println("Testno number " + TestRowno);

		int ColStartsno = TestRowno + 1;
		int DataStartsno = ColStartsno + 1;

		System.out.println("Col starts ftom " + ColStartsno);
		System.out.println("Data starts ftom " + DataStartsno);

		int cols = 0;
		while (!excel.getCellData(SheetName, cols, ColStartsno).equalsIgnoreCase("")) {
			cols++;
		}
		System.out.println("cols " + cols);

		int rows = 0;
		while (!excel.getCellData(SheetName, rows, DataStartsno + rows).equalsIgnoreCase("")) {
			rows++;
		}
		System.out.println("rows " + rows);

		// printing
		for (int row = DataStartsno; row < DataStartsno+rows; row++) {

			for (int col = 0; col < cols; col++) {

				System.out.println(excel.getCellData(SheetName, col, row));
			}
		}

	}

}
