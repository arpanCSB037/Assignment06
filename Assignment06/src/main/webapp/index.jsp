<!DOCTYPE html>
<html>

<head>
    <title>Student Registration</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>

<body>

    <div class="container">

        <h1>Student Registration</h1>

        <p class="subtitle">
            Enter student details to register a new student.
        </p>

        <form action="${pageContext.request.contextPath}/student" method="post">

            <div class="form-group">
                <label>Roll Number</label>
                <input type="text" name="rollno" placeholder="e.g. 2024CSB001" required>
            </div>

            <div class="form-group">
                <label>Student Name</label>
                <input type="text" name="name" placeholder="Enter student name" required>
            </div>

            <div class="form-group">
                <label>Gender</label>
                <select name="gender" required>
                    <option value="">Select Gender</option>
                    <option value="Male">Male</option>
                    <option value="Female">Female</option>
                    <option value="Other">Other</option>
                </select>
            </div>

            <div class="form-group">
                <label>Department</label>
                <select name="department" required>
                    <option value="">Select Department</option>
                    <option value="CSE">CSE</option>
                    <option value="ECE">ECE</option>
                    <option value="ME">ME</option>
                    <option value="EE">EE</option>
                    <option value="IT">IT</option>
                </select>
            </div>

            <div class="form-group">
                <label>CGPA</label>
                <input type="number" name="cgpa" placeholder="Enter CGPA" min="0" max="10" step="0.01" required>
            </div>

            <button type="submit">Register Student</button>

        </form>

        <a href="${pageContext.request.contextPath}/student" class="back-link">
            View All Registered Students
        </a>

    </div>

</body>

</html>