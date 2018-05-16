package Data;

public class excel {

	public static void main(String[] args) {

		ExcelReader e = new ExcelReader("D:\\MS OFFICE\\Exceldata\\TestIBM.xlsx");

		int Rowcount = e.getRowCount("Sunil");
		System.out.println(Rowcount);
		String usrnmae = e.getCellData("Sunil", "password", Rowcount);
		System.out.println(usrnmae);

		for (int rownum = 2; rownum <= Rowcount; rownum++) {
			String a = e.getCellData("Sunil", "username", rownum);
			System.out.println(a);

			String b = e.getCellData("Sunil", "password", rownum);
			System.out.println(b);
		}
		System.out.println("*************************");

		if (!e.isSheetExist("Sage")) {
			e.addSheet("Sage");
		}
		e.addColumn("Sage", "Status");
		e.setCellData("sage", "Status", Rowcount, "Pass");
		System.out.println("Success");
	}

}
