<%@ page import="java.util.List" %>
    <%@ page import="com.webtech.Student" %>

        <!DOCTYPE html>
        <html>

        <head>
            <title>All Students</title>

            <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
        </head>

        <body>

            <div class="container" style="max-width: 1100px;">

                <h1>Registered Students</h1>

                <p class="subtitle">
                    All student records retrieved from MySQL.
                </p>

                <% List<Student> students =
                    (List<Student>) request.getAttribute("students");
                        %>

                        <% if (students !=null && !students.isEmpty()) { %>

                            <div style="overflow-x: auto;">

                                <table style="width: 100%; border-collapse: collapse;">

                                    <thead>
                                        <tr style="background: #2563eb; color: white;">
                                            <th>Roll Number</th>
                                            <th>Name</th>
                                            <th>Gender</th>
                                            <th>Department</th>
                                            <th>CGPA</th>
                                        </tr>
                                    </thead>

                                    <tbody>

                                        <% for (Student s : students) { %>

                                            <tr style="border-bottom: 1px solid #cbd5e1;">

                                                <td style="padding: 12px;">
                                                    <%= s.getRollno() %>
                                                </td>

                                                <td style="padding: 12px;">
                                                    <%= s.getName() %>
                                                </td>

                                                <td style="padding: 12px;">
                                                    <%= s.getGender() %>
                                                </td>

                                                <td style="padding: 12px;">
                                                    <%= s.getDepartment() %>
                                                </td>

                                                <td style="padding: 12px;">
                                                    <%= s.getCgpa() %>
                                                </td>

                                            </tr>

                                            <% } %>

                                    </tbody>

                                </table>

                            </div>

                            <p style="margin-top: 20px;">
                                Total Students: <strong>
                                    <%= students.size() %>
                                </strong>
                            </p>

                            <% } else { %>

                                <p>No student records found.</p>

                                <% } %>

                                    <a class="back-link" href="${pageContext.request.contextPath}/index.jsp">
                                        Back to Registration
                                    </a>

            </div>

        </body>

        </html>