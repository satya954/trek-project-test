package com.example.trekking;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class TrekkingServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<String> images = (List<String>) getServletContext().getAttribute("trekImages");
        Random rand = new Random();
        String selectedImage = images.get(rand.nextInt(images.size()));
        request.setAttribute("selectedImage", selectedImage);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
