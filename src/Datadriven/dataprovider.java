package Datadriven;

import java.util.Hashtable;

import Data.ExcelReader;

public class dataprovider {

	public static Object[][] getdata(String testcase, ExcelReader e) {

		String sheetname = "Sunil";
		String TestCase = testcase;
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

		Object[][] data = new Object[rows][1];

		// Printing the data form the excel
		System.out.println("************TEST DATA PRINTING**************");
		int i = 0;
		for (int row = datastartsno; row < datastartsno + rows; row++) {
			Hashtable<String, String> table = new Hashtable<String, String>();
			for (int col = 0; col < cols; col++) {

				// System.out.println(e.getCellData(sheetname, col, row));

				String testdata = e.getCellData(sheetname, col, row);
				String colname = e.getCellData(sheetname, col, colstartsno);
				table.put(colname, testdata);
			}

			data[i][0] = table;
			i++;
		}
		return data;

	}
}
