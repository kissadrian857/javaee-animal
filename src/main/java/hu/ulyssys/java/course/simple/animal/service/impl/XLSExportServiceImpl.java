package hu.ulyssys.java.course.simple.animal.service.impl;

import hu.ulyssys.java.course.simple.animal.entity.Slug;
import hu.ulyssys.java.course.simple.animal.service.SlugService;
import hu.ulyssys.java.course.simple.animal.service.XLSExportService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import javax.inject.Inject;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class XLSExportServiceImpl implements XLSExportService {
    @Inject
    private SlugService slugService;
    @Override
    public void processExport() {

        Workbook wb = new HSSFWorkbook();  // or new XSSFWorkbook();
        Sheet slugSheet = wb.createSheet("Slug");

        CellStyle style = wb.createCellStyle();
        Font font = wb.createFont();
        font.setBold(true);
        style.setFont(font);


        Row headerRow = slugSheet.createRow(0);
        Cell id =headerRow.createCell(0);
        id.setCellValue("ID");
        id.setCellStyle(style);

        headerRow.createCell(1).setCellValue("Name");
        headerRow.createCell(2).setCellValue("Number of legs");
        headerRow.createCell(3).setCellValue("Animal type");

        int i = 1;
        for (Slug s : slugService.getALl()){
            Row row = slugSheet.createRow(i++);
            row.createCell(0).setCellValue(s.getId());
            row.createCell(1).setCellValue(s.getName());
            row.createCell(2).setCellValue(s.getLegsNumber());
            row.createCell(3).setCellValue(s.getType().toString());
        }

        try (OutputStream fileOut = new FileOutputStream("workbook.xls")) {
            wb.write(fileOut);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
