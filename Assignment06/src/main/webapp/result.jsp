<!DOCTYPE html>
<html>

<head>
    <title>Registration Result</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>

<body>

    <div class="container">

        <h1>
            ${status == 'success' ? 'Registration Successful!' : 'Registration Failed!'}
        </h1>

        <p class="subtitle">${message}</p>

        <div class="result-item">
            <strong>Roll Number:</strong> ${rollno}
        </div>

        <div class="result-item">
            <strong>Name:</strong> ${name}
        </div>

        <div class="result-item">
            <strong>Gender:</strong> ${gender}
        </div>

        <div class="result-item">
            <strong>Department:</strong> ${department}
        </div>

        <div class="result-item">
            <strong>CGPA:</strong> ${cgpa}
        </div>

        <a class="back-link" href="${pageContext.request.contextPath}/index.jsp">
            Back to Registration
        </a>

    </div>

</body>

</html>