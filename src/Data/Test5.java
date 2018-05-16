package Data;

public class Test5 {

	public static void main(String[] args) {
		ExcelReader e = new ExcelReader("F:\\Selenium programs\\Post Action\\DataDriven\\src\\Data\\Suite1.xlsx");

		String sheetname = "Sunil";
		String testcasename = "TestA3";

		int teststartno = 1;

		while (!e.getCellData(sheetname, 0, teststartno).equalsIgnoreCase(testcasename)) {
			teststartno++;

		}
		System.out.println("testno :" + teststartno);

		int colstartno = teststartno + 1;
		int datastartno = colstartno + 1;
		System.out.println("col" + colstartno);
		System.out.println("Data" + datastartno);

		int cols = 0;
		while (!e.getCellData(sheetname, cols, colstartno).equalsIgnoreCase("")) {
			cols++;
		}
		System.out.println("cols is " + cols);

		int rows = 0;
		while (!e.getCellData(sheetname, rows, datastartno + rows).equalsIgnoreCase("")) {
			rows++;

		}
		System.out.println("rows is  " + rows);

		for (int row = datastartno; row < datastartno + rows; row++) {

			for (int col = 0; col < cols; col++) {

				System.out.println(e.getCellData(sheetname, col, row));
			}
		}
	}

}
