package db.his.util;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import db.his.domain.Doctor;

public class ExcelPoiUtil {
	/**
	 * POI:解析Excel文件中的数据并把每行数据封装成一个实体
	 * 
	 * @param fis
	 *            文件输入流
	 * @return List<EmployeeInfo> Excel中数据封装实体的集合
	 */
	public static List<Doctor> importDoctorsByPoi(InputStream fis) {

		List<Doctor> docs = new ArrayList<Doctor>();
		Doctor doctor = null;

		try {
			// 创建Excel工作薄
			HSSFWorkbook hwb = new HSSFWorkbook(fis);
			// 得到第一个工作表
			HSSFSheet sheet = hwb.getSheetAt(0);
			HSSFRow row = null;
			// 日期格式化
			DateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
			// 遍历该表格中所有的工作表，i表示工作表的数量 getNumberOfSheets表示工作表的总数
			for (int i = 0; i < hwb.getNumberOfSheets(); i++) {
				sheet = hwb.getSheetAt(i);
				// 遍历该行所有的行,j表示行数 getPhysicalNumberOfRows行的总数
				for (int j = 1; j < sheet.getPhysicalNumberOfRows(); j++) {
					row = sheet.getRow(j);
					doctor = new Doctor();

					// 此方法调用getCellValue(HSSFCell cell)对解析出来的数据进行判断，并做相应的处理
					if(ExcelPoiUtil.getCellValue(row.getCell(0)) != null && !"".equals(ExcelPoiUtil.getCellValue(row.getCell(0)))) {   
                        doctor.setDoctor_id(ExcelPoiUtil.getCellValue(row.getCell(0)));   
                    } 
					doctor.setName(ExcelPoiUtil.getCellValue(row.getCell(1)));
					doctor.setProfession_id(ExcelPoiUtil.getCellValue(row.getCell(2)));
					doctor.setDept_id(ExcelPoiUtil.getCellValue(row.getCell(3)));
					doctor.setPassword(ExcelPoiUtil.getCellValue(row.getCell(4)));
					docs.add(doctor);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return docs;
	}

	// 判断从Excel文件中解析出来数据的格式
	private static String getCellValue(HSSFCell cell) {
		String value = null;
		// 简单的查检列类型
		switch (cell.getCellType()) {
		case HSSFCell.CELL_TYPE_STRING:// 字符串
			value = cell.getRichStringCellValue().getString();
			break;
		case HSSFCell.CELL_TYPE_NUMERIC:// 数字
			long dd = (long) cell.getNumericCellValue();
			value = dd + "";
			break;
		case HSSFCell.CELL_TYPE_BLANK:
			value = "";
			break;
		case HSSFCell.CELL_TYPE_FORMULA:
			value = String.valueOf(cell.getCellFormula());
			break;
		case HSSFCell.CELL_TYPE_BOOLEAN:// boolean型值
			value = String.valueOf(cell.getBooleanCellValue());
			break;
		case HSSFCell.CELL_TYPE_ERROR:
			value = String.valueOf(cell.getErrorCellValue());
			break;
		default:
			break;
		}
		return value;
	}
}
