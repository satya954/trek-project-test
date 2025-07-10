package com.example.trekking;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.Properties;

public class SubmitFormServlet extends HttpServlet {

    private String dbUrl;
    private String dbUser;
    private String dbPass;

    @Override
    public void init() throws ServletException {
        try (InputStream input = getServletContext().getResourceAsStream("/WEB-INF/classes/db.properties")) {
            Properties props = new Properties();
            props.load(input);
            dbUrl = props.getProperty("db.url");
            dbUser = props.getProperty("db.username");
            dbPass = props.getProperty("db.password");
        } catch (IOException e) {
            throw new ServletException("Failed to load DB config", e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String mobile = request.getParameter("mobile");
        String startDate = request.getParameter("startDate");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPass)) {
                String sql = "INSERT INTO registrations (name, age, mobile, start_date) VALUES (?, ?, ?, ?)";
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1, name);
                    stmt.setInt(2, age);
                    stmt.setString(3, mobile);
                    stmt.setDate(4, Date.valueOf(startDate));
                    stmt.executeUpdate();
                }
            }
        } catch (Exception e) {
            throw new ServletException("DB error", e);
        }

        request.setAttribute("name", name);
        request.setAttribute("age", age);
        request.setAttribute("mobile", mobile);
        request.setAttribute("startDate", startDate);

        request.getRequestDispatcher("success.jsp").forward(request, response);
    }
}

