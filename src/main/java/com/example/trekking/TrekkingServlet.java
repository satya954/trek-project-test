package com.example.trekking;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class TrekkingServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String contextPath = request.getContextPath();
        String[] images = {
            contextPath + "/images/trekking1.jpg",
            contextPath + "/images/trekking2.jpg",
            contextPath + "/images/trekking3.jpg"
        };
        Random rand = new Random();
        String selectedImage = images[rand.nextInt(images.length)];
        request.setAttribute("selectedImage", selectedImage);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
