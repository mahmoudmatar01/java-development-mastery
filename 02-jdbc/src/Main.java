import service.StudentService;
import service.impl.StudentServiceImpl;

public class Main {
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