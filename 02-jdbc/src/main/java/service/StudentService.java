package main.java.service;


import main.java.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudent();

    Student getStuById(int id);

    void updateStudent(Student student);

    void AddStudent(Student student);

    void deleteStudent(int id);
}
