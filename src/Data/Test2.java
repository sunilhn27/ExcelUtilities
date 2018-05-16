package Data;

public class Test2 {

	public static void main(String[] args) {

		ExcelReader e = new ExcelReader("F:\\Selenium programs\\Post Action\\DataDriven\\src\\Data\\Suite1.xlsx");
		String sheetname = "Sunil";
		String TestCase = "TestA2";
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

		// Printing the data form the excel
		System.out.println("************TEST DATA PRINTING**************");
		for (int row = datastartsno; row < datastartsno + rows; row++) {
			for (int col = 0; col < cols; col++) {

				System.out.println(e.getCellData(sheetname, col, row));
			}
		}

	}

}
