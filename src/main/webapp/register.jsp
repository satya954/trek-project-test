<!DOCTYPE html>
<html>
<head>
    <title>Register for Trek</title>
    <style>
        body {
            background-image: url('images/trekking-bg.jpg');
            background-size: cover;
            font-family: Arial, sans-serif;
            color: #333;
            padding: 40px;
        }
        .container {
            background-color: rgba(255, 255, 255, 0.9);
            padding: 30px;
            max-width: 500px;
            margin: auto;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        input, label {
            display: block;
            width: 100%;
            margin-bottom: 15px;
        }
        input[type="submit"] {
            background-color: #28a745;
            color: white;
            border: none;
            padding: 10px;
            cursor: pointer;
            border-radius: 5px;
        }
        a {
            color: #007bff;
            text-decoration: none;
            display: block;
            text-align: center;
            margin-bottom: 20px;
        }
    </style>
    <script>
        function validateForm() {
            const mobile = document.forms["trekForm"]["mobile"].value;
            const age = parseInt(document.forms["trekForm"]["age"].value);
            const mobilePattern = /^[6-9]\d{9}$/;

            if (!mobilePattern.test(mobile)) {
                alert("Invalid mobile number. It must be 10 digits and start with 6, 7, 8, or 9.");
                return false;
            }

            if (age < 18 || age > 45) {
                alert("Age must be between 18 and 45.");
                return false;
            }

            return true;
        }
    </script>
</head>
<body>
    <a href="viewRegistrations">View All Registrations</a>
    <div class="container">
        <h2>Register for a Trek</h2>
        <form name="trekForm" action="submitForm" method="post" onsubmit="return validateForm()">

            <label for="name">Name:</label>
            <input type="text" name="name" required />

            <label for="age">Age:</label>
            <input type="number" name="age" required />

            <label for="mobile">Mobile:</label>
            <input type="text" name="mobile" required />

            <label for="startDate">Trek Start Date:</label>
            <input type="date" name="startDate" required />

            <input type="submit" value="Register" />
        </form>
    </div>
</body>
</html>
