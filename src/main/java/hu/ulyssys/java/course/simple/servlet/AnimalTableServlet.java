package hu.ulyssys.java.course.simple.servlet;


import hu.ulyssys.java.course.simple.animal.entity.Cat;
import hu.ulyssys.java.course.simple.animal.service.CatService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@WebServlet("animal-table")
public class AnimalTableServlet extends HttpServlet {
    @Inject
    private CatService catService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        StringBuilder builder = new StringBuilder();

        builder.append("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<title>Animals</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<h1>Animals</h1>\n");

        builder.append("<table>")
                .append("<tr>")
                .append("<td>ID</td>")
                .append("<td>Név</td>")
                .append("<td>Lábak száma</td>")
                .append("<td>Faj</td>")
                .append("</tr>");

        builder.append("<p>"+catService.getALl().size()+"</p>");
        for (Cat cat : catService.getALl()) {
            builder.append("<tr>")
                    .append("<td>" + cat.getId() + "</td>"
                            + "<td>" + cat.getName() + "</td>"
                            + "<td>" + cat.getLegsNumber() + "</td>"
                            + "<td>" + cat.getType() + "</td>")
                    .append("</tr>");
        }

        builder.append("</table>");
        out.println(new String(builder.toString().getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8.name()));
        out.println("</body>\n" + "</html>\n");
    }
}
