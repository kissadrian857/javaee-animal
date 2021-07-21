package hu.ulyssys.java.course.simple.animal.service.impl;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import hu.ulyssys.java.course.simple.animal.entity.Slug;
import hu.ulyssys.java.course.simple.animal.service.PDFExportService;
import hu.ulyssys.java.course.simple.animal.service.SlugService;

import javax.inject.Inject;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class PDFExportServiceImpl implements PDFExportService {

    @Inject
    private SlugService slugService;

    @Override
    public InputStream processExport() {
        try {
            Document document = new Document();
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            PdfWriter.getInstance(document, stream);
            document.open();

            for (Slug s : slugService.getALl()) {
                document.add(new Paragraph("Id:" + s.getId() + " name:" + s.getName()));
            }
            //link hozzáadása
            Chunk chunk = new Chunk("European Business Award!");
            chunk.setAnchor("http://itextpdf.com/blog/european-business-award-kick-ceremony");
            document.add(chunk);
            //
            document.close();

            return new ByteArrayInputStream(stream.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
