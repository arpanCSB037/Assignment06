package com.webtech;

import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        // Receive form data
        String rollno = request.getParameter("rollno");
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String department = request.getParameter("department");
        String cgpaText = request.getParameter("cgpa");

        // Remove unnecessary spaces
        rollno = rollno == null ? "" : rollno.trim();
        name = name == null ? "" : name.trim();
        gender = gender == null ? "" : gender.trim();
        department = department == null ? "" : department.trim();
        cgpaText = cgpaText == null ? "" : cgpaText.trim();

        String message = null;
        String status = "error";

        // Server-side validation
        if (rollno.isEmpty() || name.isEmpty() ||
                gender.isEmpty() || department.isEmpty() ||
                cgpaText.isEmpty()) {

            message = "All fields are required.";

        } else if (rollno.length() > 15) {

            message = "Roll number cannot exceed 15 characters.";

        } else if (name.length() > 50) {

            message = "Name cannot exceed 50 characters.";

        } else if (gender.length() > 10 ||
                department.length() > 20) {

            message = "Invalid gender or department length.";

        } else if (!gender.equals("Male") &&
                !gender.equals("Female") &&
                !gender.equals("Other")) {

            message = "Please select a valid gender.";

        } else if (!department.matches("CSE|ECE|ME|EE|IT|CST")) {

            message = "Please select a valid department.";

        } else {

            try {
                BigDecimal cgpa = new BigDecimal(cgpaText);

                if (cgpa.compareTo(BigDecimal.ZERO) < 0 ||
                        cgpa.compareTo(BigDecimal.TEN) > 0) {

                    message = "CGPA must be between 0 and 10.";

                } else {

                    String sql = "INSERT INTO `2024CSB037` " +
                            "(rollno, name, gender, department, CGPA) " +
                            "VALUES (?, ?, ?, ?, ?)";

                    try (Connection con = DBConnection.getConnection();
                            PreparedStatement ps = con.prepareStatement(sql)) {

                        ps.setString(1, rollno);
                        ps.setString(2, name);
                        ps.setString(3, gender);
                        ps.setString(4, department);
                        ps.setBigDecimal(5, cgpa);

                        ps.executeUpdate();

                        status = "success";
                        message = "Student registered successfully!";
                    }
                }

            } catch (NumberFormatException e) {

                message = "Please enter a valid CGPA.";

            } catch (SQLException e) {

                // MySQL duplicate primary key error
                if (e.getErrorCode() == 1062) {
                    message = "This roll number is already registered!";
                } else {
                    message = "Database error. Please try again.";
                    e.printStackTrace();
                }
            }
        }

        // Send result to JSP
        request.setAttribute("status", status);
        request.setAttribute("message", message);

        request.setAttribute("rollno", rollno);
        request.setAttribute("name", name);
        request.setAttribute("gender", gender);
        request.setAttribute("department", department);
        request.setAttribute("cgpa", cgpaText);

        request.getRequestDispatcher("/result.jsp")
                .forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        List<Student> students = new ArrayList<>();

        String sql = "SELECT rollno, name, gender, department, CGPA " +
                "FROM `2024CSB037` ORDER BY rollno";

        try (Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            // Read each row from the database
            while (rs.next()) {

                Student student = new Student(
                        rs.getString("rollno"),
                        rs.getString("name"),
                        rs.getString("gender"),
                        rs.getString("department"),
                        rs.getBigDecimal("CGPA"));

                students.add(student);
            }

            // Send the student list to JSP
            request.setAttribute("students", students);

            // Forward to students.jsp
            request.getRequestDispatcher("/students.jsp")
                    .forward(request, response);

        } catch (SQLException e) {

            e.printStackTrace();

            response.sendError(
                    HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                    "Unable to retrieve student records.");
        }
    }

}
