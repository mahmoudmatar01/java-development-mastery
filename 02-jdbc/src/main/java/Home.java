package main.java;

import main.java.service.StudentService;
import main.java.service.impl.StudentServiceImpl;

public class Home {
    public static void main(String[] args) {

        StudentService studentService = new StudentServiceImpl();
//        Student student = new Student("Mahmoud",3.1,"01128673348");
//        Student student =  Student.builder()
//                .name("Eng/Ramy")
//                .gpa(4.5)
//                .phone("01234556")
//                .build();
//        studentService.AddStudent(student);
//        studentService.updateStudent(new Student("Matar",3.4,1,"01111614941"));
//        System.out.println(studentService.getAllStudent());
        System.out.println(studentService.getStuById(5));
//        studentService.deleteStudent(2);


    }
}









// To connect in sql server management studio :-

//        String connectionString="jdbc:sqlserver://DESKTOP-UQA266F;Database=CourseraDb;IntegratedSecurity=true;encrypt=true;trustServerCertificate=true";
//        try{
//            try(Connection con= DriverManager.getConnection(connectionString)){
//                System.out.println("Connection success");
//            }
//        }catch (SQLException e){
//            System.out.println("Error connection to the database");
//            e.printStackTrace();
//        }