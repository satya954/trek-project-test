<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.trekking.Registration" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Registrations</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-image: url('images/trekking2.jpg');
            background-size: cover;
            color: white;
        }
        table {
            width: 80%%;
            margin: 50px auto;
            border-collapse: collapse;
            background-color: rgba(0,0,0,0.7);
        }
        th, td {
            padding: 10px;
            border: 1px solid #ffffff;
            text-align: center;
        }
        th {
            background-color: #2e8b57;
        }
        h1 {
            text-align: center;
            margin-top: 30px;
        }
    </style>
</head>
<body>
    <h1>Registered Trek Participants</h1>
    <table>
        <tr>
            <th>Name</th>
            <th>Age</th>
            <th>Mobile</th>
            <th>Start Date</th>
        </tr>
        <%
            List<Registration> regs = (List<Registration>) request.getAttribute("registrations");
            for (Registration r : regs) {
        %>
        <tr>
            <td><%= r.getName() %></td>
            <td><%= r.getAge() %></td>
            <td><%= r.getMobile() %></td>
            <td><%= r.getStartDate() %></td>
        </tr>
        <% } %>
    </table>
</body>
</html>
