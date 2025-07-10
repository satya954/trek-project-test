<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registration Success</title>
    <style>
        body {
            background-image: url('images/trekking-bg.jpg');
            background-size: cover;
            font-family: Arial, sans-serif;
            padding: 40px;
        }
        .container {
            background-color: rgba(255, 255, 255, 0.95);
            padding: 30px;
            max-width: 600px;
            margin: auto;
            border-radius: 10px;
            box-shadow: 0 0 15px rgba(0,0,0,0.1);
            color: #333;
        }
        h2 {
            color: #28a745;
            text-align: center;
        }
        p {
            font-size: 18px;
            margin: 10px 0;
        }
        a {
            display: inline-block;
            margin-top: 20px;
            color: #007bff;
            text-decoration: none;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>✅ Registration Successful!</h2>
        <p><strong>Name:</strong> ${name}</p>
        <p><strong>Age:</strong> ${age}</p>
        <p><strong>Mobile:</strong> ${mobile}</p>
        <p><strong>Trek Start Date:</strong> ${startDate}</p>

        <a href="register.jsp">➕ Register Another</a> |
        <a href="viewRegistrations">📋 View All Registrations</a> |
	<a href="home">🏠 Return to Home Page</a>
    </div>
</body>
</html>

