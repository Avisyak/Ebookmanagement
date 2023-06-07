package com.Broadway.FinalprojectBroadway.utils;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.Broadway.FinalprojectBroadway.Model.Order;

public class OrderExcelView extends AbstractXlsView{

	@Override
	protected void buildExcelDocument(
			Map<String, Object> model,
			Workbook workbook,
			HttpServletRequest request,
			HttpServletResponse response)
					throws Exception {
		
		//1. define your own excel file name
				response.addHeader("Content-Disposition", "attachment;filename=Order.xls");
				
				//2. read data given by Controller
				@SuppressWarnings("unchecked")
				List<Order> list = (List<Order>) model.get("list");
				
				//3. create one sheet
				Sheet sheet = workbook.createSheet("EMPLOYEE");
				
				//4. create row#0 as header
				setHead(sheet);
				
				//5. create row#1 onwards from List<T> 
				setBody(sheet,list);
	}
	private void setHead(Sheet sheet) {
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("fname");
		row.createCell(2).setCellValue("lname");
		row.createCell(3).setCellValue("Email");
		row.createCell(4).setCellValue("Phone");
		row.createCell(5).setCellValue("Address");
		row.createCell(6).setCellValue("City");
		row.createCell(7).setCellValue("State");
		row.createCell(8).setCellValue("Zip");
		row.createCell(9).setCellValue("payment");
		
	}
	
	private void setBody(Sheet sheet, List<Order> list) {
		int rowNum = 1;
		for(Order spec : list) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(spec.getId());
			row.createCell(1).setCellValue(spec.getFirstname());
			row.createCell(2).setCellValue(spec.getLastname());
			row.createCell(3).setCellValue(spec.getEmail());
			row.createCell(4).setCellValue(spec.getPhone());
			row.createCell(5).setCellValue(spec.getAddress());
			row.createCell(6).setCellValue(spec.getCity());
			row.createCell(7).setCellValue(spec.getState());
			row.createCell(8).setCellValue(spec.getZip());
			row.createCell(9).setCellValue(spec.getPayment());
			
		}
	}
	

}
