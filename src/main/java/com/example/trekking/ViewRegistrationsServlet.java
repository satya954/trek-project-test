package com.example.trekking;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class ViewRegistrationsServlet extends HttpServlet {

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
            throw new ServletException("Could not load DB properties", e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Registration> registrations = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPass)) {
                String sql = "SELECT name, age, mobile, start_date FROM registrations";
                try (Statement stmt = conn.createStatement();
                     ResultSet rs = stmt.executeQuery(sql)) {
                    while (rs.next()) {
                        Registration reg = new Registration();
                        reg.setName(rs.getString("name"));
                        reg.setAge(rs.getInt("age"));
                        reg.setMobile(rs.getString("mobile"));
                        reg.setStartDate(rs.getDate("start_date").toString());
                        registrations.add(reg);
                    }
                }
            }
        } catch (Exception e) {
            throw new ServletException("Database error", e);
        }

        request.setAttribute("registrations", registrations);
        RequestDispatcher dispatcher = request.getRequestDispatcher("viewRegistrations.jsp");
        dispatcher.forward(request, response);
    }
}

