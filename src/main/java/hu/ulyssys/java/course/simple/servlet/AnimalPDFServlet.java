package hu.ulyssys.java.course.simple.servlet;

import hu.ulyssys.java.course.simple.animal.service.PDFExportService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@WebServlet("animal-pdf")
public class AnimalPDFServlet extends HttpServlet {
    @Inject
    PDFExportService pdfExportService;

    private final int ARBITARY_SIZE = 1024;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/pdf");
        response.setHeader("Content-disposition", "attachment; filename=test.pdf");

        try (InputStream in = pdfExportService.processExport();
             OutputStream out = response.getOutputStream()) {

            byte[] buffer = new byte[ARBITARY_SIZE];

            int numBytesRead;
            while ((numBytesRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, numBytesRead);
            }
        }
    }
}
