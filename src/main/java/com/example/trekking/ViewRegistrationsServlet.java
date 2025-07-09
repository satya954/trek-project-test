package com.example.trekking;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class ViewRegistrationsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String filePath = getServletContext().getRealPath("/WEB-INF/registrations.txt");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>All Trek Registrations</title></head><body>");
        out.println("<h2>Registered Trekkers</h2>");
        out.println("<pre>");

        File file = new File(filePath);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    out.println(line);
                }
            }
        } else {
            out.println("No registrations yet.");
        }

        out.println("</pre>");
        out.println("<a href='register.jsp'>Back to Form</a>");
        out.println("</body></html>");
    }
}

