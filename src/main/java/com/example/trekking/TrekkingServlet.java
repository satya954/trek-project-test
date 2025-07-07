package com.example.trekking;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class TrekkingServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
