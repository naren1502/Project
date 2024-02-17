package genericUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	FileInputStream fis;
	Workbook wb;
	FileOutputStream fos;
	File fi;

	/*
	 * public ExcelUtility() { try { fi = new File(FrameworkConstants.excelPath);
	 * fis = new FileInputStream(fi); fos = new FileOutputStream(fi); wb =
	 * WorkbookFactory.create(fis); }catch (Exception e) { // TODO: handle exception
	 * } }
	 */

	/**
	 * The below method which is used to read data based on row and column numbers
	 * 
	 * @param sheet  name
	 * @param roNum
	 * @param colNum
	 * @return data from the cell
	 * @throws IOException
	 */
	public String GetdataByRowNumAndColNum(String sheet, int rowNum, int colNum) throws IOException {

		String data = wb.getSheet(sheet).getRow(rowNum).getCell(colNum).toString();
		return data;
	}

	/**
	 * The below implemented method which returns all the data present in the sheet
	 * 
	 * @param sheet
	 * @return 2d array with all the data present in sheet
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String[][] GetAllSheetData(String sheet) throws EncryptedDocumentException, IOException {
		Sheet sh = wb.getSheet(sheet);
		int rows = wb.getSheet(sheet).getLastRowNum();
		int cols = 0;
		for (int i = 0; i < rows; i++) {
			int cells = sh.getRow(i).getPhysicalNumberOfCells();
			if (cells > cols) {
				cols = cells;
			}
		}
		String[][] strArray = new String[rows][cols];
		int rowIndex = 0;
		try {
			for (Row row : sh) {
				int colIndex = 0;
				for (Cell cell : row) {
					String cellValue = "";
					strArray[rowIndex][colIndex++] = cellValue.toString();
				}
				rowIndex++;
			}

		} catch (Exception e) {
			System.out.print("no data");
		}
		return strArray;

	}

	/**
	 * The below which returns the data based on the row
	 * 
	 * @param sheet
	 * @param uniqueData
	 * @return HashMap
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */

	public HashMap<String, String> GetDataFromSingleRow(String sheet, String uniqueData)
			throws EncryptedDocumentException, IOException {
		Sheet sh = wb.getSheet(sheet);
		int row = sh.getLastRowNum();
		System.out.println(row);
		HashMap<String, String> hm = new HashMap<>();
		String str = "";

		for (int i = 0; i <= row; i++) {
			try {
				CellType type = sh.getRow(i).getCell(0).getCellType();
				if (type == null) {

				} else {
					str = sh.getRow(i).getCell(0).toString();
				}

				if (str.equalsIgnoreCase(uniqueData)) {
					int cellCount = sh.getRow(i).getPhysicalNumberOfCells();
					for (int j = 1; j < cellCount; j++) {

						String value = sh.getRow(i).getCell(j).toString();
						System.out.println(value);
						for (int k = 1; k < cellCount; k++) {
							String key = sh.getRow(i - 1).getCell(k).toString();

							hm.put(key, value);
						}
					}
				}
			} catch (Exception e) {
				System.out.println("no data");
				continue;
			}
		}
		return hm;
	}

	/**
	 * This method which is used to write back the excel data
	 * 
	 * @param sheet
	 * @param header
	 * @param uniquecellIndex
	 * @param uniqueData
	 * @param data
	 */
	public void writeDataIntoExcel(String sheet, String header, int uniquecellIndex, String uniqueData, String data) {
		Sheet sh = wb.getSheet(sheet);
		int[] c = getUniqueDataRowNumber(sh, uniquecellIndex, uniqueData, header);
		sh.getRow(c[0]).getCell(c[1]).setCellValue(data);
	}

	public int[] getUniqueDataRowNumber(Sheet sh, int uniquecellIndex, String uniqueData, String header) {

		int row = sh.getLastRowNum();
		for (int i = 0; i < row; i++) {
			try {
				String data = sh.getRow(i).getCell(uniquecellIndex).toString();
				if (data.equalsIgnoreCase(uniqueData)) {
					int cellCount = sh.getRow(i - 1).getPhysicalNumberOfCells();
					for (int j = 1; j < cellCount; j++) {
						if (sh.getRow(i - 1).getCell(j).toString().equalsIgnoreCase(header)) {
							return new int[] { i, j };
						}

					}
				}
			} catch (Exception e) {

			}
		}
		return new int[] { 0, 0 };
	}
}
