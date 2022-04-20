package com.myA1store.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook wb;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell col;
	public CellStyle cs;
	String path = null;
	
	 public ExcelData(String path) {
		this.path = path;
		
	}
	public int getRowCount(String sheetname) throws Exception {
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		sheet =wb.getSheet(sheetname);
		int totalrows =sheet.getLastRowNum();
		wb.close();
		fi.close();
		return totalrows;
	}
	public int getcellCount(String sheetname,int rownum) throws Exception {
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		sheet =wb.getSheet(sheetname);
		row =sheet.getRow(rownum);
		int totalcol =row.getLastCellNum();
		wb.close();
		fi.close();
		return totalcol;
	
	}
	public String getcellData(String sheetname,int rownum,int colnum) throws Exception {
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		sheet =wb.getSheet(sheetname);
		row =sheet.getRow(rownum);
		col =row.getCell(colnum);
	
		DataFormatter dataformat = new DataFormatter();
		String data;
		try {
		data =dataformat.formatCellValue(col);
		}catch (Exception e) {
			data ="";
		}
		wb.close();
		fi.close();
		return data;
	}
	public void setCellData(String sheetname,int rownum,int colnum,String data) throws Exception {
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		sheet =wb.getSheet(sheetname);
		row =sheet.getRow(rownum);
		col =row.createCell(colnum);
		col.setCellValue(data);
		fo = new FileOutputStream(path);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
		
		}
	public void setGreenColor(String sheetname,int rownum,int colnum) throws Exception {
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		sheet =wb.getSheet(sheetname);
		row =sheet.getRow(rownum);
		col = row.getCell(colnum);
		
		cs =wb.createCellStyle();
		cs.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		cs.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		col.setCellStyle(cs);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
		
	}
	public void setRedColor(String sheetname,int rownum,int colnum) throws Exception {
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		sheet =wb.getSheet(sheetname);
		row =sheet.getRow(rownum);
		col = row.getCell(colnum);
		
		cs =wb.createCellStyle();
		cs.setFillForegroundColor(IndexedColors.RED.getIndex());
		cs.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		col.setCellStyle(cs);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
		
	}
}
