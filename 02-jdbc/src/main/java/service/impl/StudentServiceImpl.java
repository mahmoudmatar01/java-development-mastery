package main.java.service.impl;


import main.java.connection.DBConnection;
import main.java.model.Student;
import main.java.service.StudentService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    @Override
    public List<Student> getAllStudent() {
        Connection con = DBConnection.getConnection();
        //check Connection
        checkConnectivity(con);
        List<Student> allStudent = new ArrayList<>();
        String query = "SELECT * FROM student";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Student student =  Student.builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .phone("+2"+resultSet.getString("phone"))
                        .gpa(resultSet.getDouble("gpa"))
                        .build();
                allStudent.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return allStudent;
    }

    @Override
    public Student getStuById(int id) {
        Connection con = DBConnection.getConnection();
        //check Connection
        checkConnectivity(con);
        String query = "SELECT * FROM student WHERE id=?";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
//                Student student = new Student(resultSet.getString("name"), resultSet.getDouble("gpa"), resultSet.getInt("id"), resultSet.getString("phone"));
                Student student =  Student.builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .phone("+2"+resultSet.getString("phone"))
                        .gpa(resultSet.getDouble("gpa"))
                        .build();
                    return student;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void updateStudent(Student student) {
        Connection con = DBConnection.getConnection();
        //check Connection
        checkConnectivity(con);
        String query = "UPDATE student SET name=?, gpa=? ,phone=? WHERE id=?";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setString(1, student.getStudentName());
            preparedStatement.setDouble(2, student.getGpa());
            preparedStatement.setString(3, "+2"+student.getPhone());
            preparedStatement.setInt(4, student.getId());
            preparedStatement.executeUpdate();
//        preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void AddStudent(Student student) {
        Connection con = DBConnection.getConnection();
        //check Connection
        checkConnectivity(con);
        String query = "INSERT INTO student (name,gpa,phone) VALUES(?,?,?)";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setString(1, student.getStudentName());
            preparedStatement.setDouble(2, student.getGpa());
            preparedStatement.setString(3, "+2"+student.getPhone());
            preparedStatement.execute();
//        preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void deleteStudent(int id) {
        Connection con = DBConnection.getConnection();
        //check Connection
        checkConnectivity(con);
        String query = "DELETE FROM student WHERE id=?";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
//        preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    void checkConnectivity(Connection con){
        if(con==null){
            return;
        }
    }
}
