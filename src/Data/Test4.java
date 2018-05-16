package Data;

public class Test4 {

	public static void main(String[] args) {

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

		for (int row = Datastartsno; row < Datastartsno + rows; row++) {

			for (int col = 0; col < cols; col++) {

				System.out.println(e.getCellData(sheetname, col, row));
			}

		}

	}
}
