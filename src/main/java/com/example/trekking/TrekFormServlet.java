package com.example.trekking;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class TrekFormServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String mobile = request.getParameter("mobile");
        String startDate = request.getParameter("startDate");

        // Save to a file inside WEB-INF
        String filePath = getServletContext().getRealPath("/WEB-INF/registrations.txt");
        try (FileWriter fw = new FileWriter(filePath, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(String.format("Name: %s, Age: %s, Mobile: %s, Start Date: %s%n", name, age, mobile, startDate));
        }

        // Confirmation response
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Registration Successful</title></head><body>");
        out.println("<h2>Registration Successful!</h2>");
        out.println("<p>Thank you, " + name + ". Your trek starts on " + startDate + ".</p>");
        out.println("<a href='register.jsp'>Back to Form</a>");
        out.println("</body></html>");
    }
}

