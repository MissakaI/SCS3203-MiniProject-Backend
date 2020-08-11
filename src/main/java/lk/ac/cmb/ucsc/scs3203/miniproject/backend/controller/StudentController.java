package lk.ac.cmb.ucsc.scs3203.miniproject.backend.controller;

import lk.ac.cmb.ucsc.scs3203.miniproject.backend.models.Student;
import lk.ac.cmb.ucsc.scs3203.miniproject.backend.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/student/")
public class StudentController {

    //SubjectService subjectService;
    StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

//    @GetMapping("/id/{id}")
//    String demo(@RequestBody Student id){
//        return "";
//    }

    @PostMapping("/newStudent")
    public void createStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }

    @GetMapping("/getStudent/{id}")
    public Student getStudentById(@PathVariable int id){
        return studentService.getStudentById(id);
    }

    @GetMapping("/getStudent/{email}")
    public Student getStudentByEmail(@PathVariable String email){
        return studentService.getStudentByEmail(email);
    }

    @GetMapping("/getStudent/{primaryPhoneNumber}")
    public Student getStudentByPrimaryMobile(@PathVariable String primaryPhoneNumber){
        return studentService.getStudentByPrimaryMobile(primaryPhoneNumber);
    }

    @GetMapping("/getStudent/{firstName}")
    public Set<Student> getStudentsByFirstName(@PathVariable String firstName){
        return studentService.getStudentByFirstName(firstName);
    }

    @GetMapping("/getStudent/{lastName}")
    public Set<Student> getStudentsByLastName(@PathVariable String lastName){
        return studentService.getStudentByLastName(lastName);
    }

//    @GetMapping("/getStudent/{firstName}&{lastName}")
//    public Set<Student> getStudentsByLastName(@PathVariable String lastName){
//        return studentService.getStudentByLastName(lastName);
//    }

    @GetMapping("/getStudents")
    public Set<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @PatchMapping("/updateStudent/{id}")
    public boolean updateStudent(@RequestBody Student student, @PathVariable int id){
        return studentService.updateStudent(id,student);
    }

    @GetMapping("/deleteStudent/{id}")
    public void deleteStudent(@PathVariable int id){
        studentService.deleteStudent(id);
    }

}
