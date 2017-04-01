package POI;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellAddress;

public class TestPOI {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		FileInputStream is = new FileInputStream(new File(
				"C:/Users/lenovo/Desktop/test.xls"));
		HSSFWorkbook workbook = new HSSFWorkbook(is);
		HSSFSheet sheet = workbook.getSheetAt(0);
		HSSFRow row = sheet.getRow(0);
		HSSFCell cell = row.getCell(0);
		CellAddress address = cell.getAddress();
		String value = cell.getStringCellValue();
		HSSFRichTextString richText = cell.getRichStringCellValue();
		String value2 = richText.getString();
		int length = richText.length();
		HSSFCellStyle cellStyle = cell.getCellStyle();
		HSSFFont font = cellStyle.getFont(workbook);
		byte underline = font.getUnderline();
		boolean bold = font.getBold();
		HSSFColor hssfColor = font.getHSSFColor(workbook);
		short[] triplet = hssfColor.getTriplet();
		String color = "R" + triplet[0] + " G" + triplet[1] + " B" + triplet[2] + "";
		String fontName = font.getFontName();
		short fontHeight = font.getFontHeightInPoints();
		int charSet = font.getCharSet();
		System.out.println("color:" + color + ",fontName:" + fontName
				+ ",underline:" + underline + ",length:" + length + ",value:"
				+ value + ",value2:" + value2 + ",bold:" + bold
				+ ",fontHeight:" + fontHeight + ",charSet(GB2312_CHARSET):" + charSet);
	}
}
