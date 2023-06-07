package com.Broadway.FinalprojectBroadway.utils;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.Broadway.FinalprojectBroadway.Model.Book;
import com.Broadway.FinalprojectBroadway.Model.Order;

public class BookExcelView extends AbstractXlsView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			Workbook workbook,
			HttpServletRequest request,
			HttpServletResponse response)
					throws Exception {
		//1. define your own excel file name
		response.addHeader("Content-Disposition", "attachment;filename=Book.xls");
		
		//2. read data given by Controller
		@SuppressWarnings("unchecked")
		List<Book> list = (List<Book>) model.get("list");
		
		//3. create one sheet
		Sheet sheet = workbook.createSheet("Book");
		
		//4. create row#0 as header
		setHead(sheet);
		
		//5. create row#1 onwards from List<T> 
		setBody(sheet,list);
		
	}
	private void setHead(Sheet sheet) {
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("bname");
		row.createCell(2).setCellValue("aname");
		row.createCell(3).setCellValue("Category");
		row.createCell(4).setCellValue("Photo");
		row.createCell(4).setCellValue("Price");
	
		
	}
	private void setBody(Sheet sheet, List<Book> list) {
		int rowNum = 1;
		for(Book spec : list) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(spec.getId());
			row.createCell(1).setCellValue(spec.getBname());
			row.createCell(2).setCellValue(spec.getAname());
			row.createCell(3).setCellValue(spec.getCategory());
			row.createCell(4).setCellValue(spec.getPhoto());
			row.createCell(4).setCellValue(spec.getPrice());
	
			
		}
	}
}
