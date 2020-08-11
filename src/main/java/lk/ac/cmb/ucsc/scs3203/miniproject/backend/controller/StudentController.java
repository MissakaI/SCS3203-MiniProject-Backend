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

    @PostMapping
    public void createStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id){
        return studentService.getStudentById(id);
    }

    @GetMapping("/email/{email}")
    public Student getStudentByEmail(@PathVariable String email){
        return studentService.getStudentByEmail(email);
    }

    @GetMapping("/mobile/{primaryPhoneNumber}")
    public Student getStudentByPrimaryMobile(@PathVariable String primaryPhoneNumber){
        return studentService.getStudentByPrimaryMobile(primaryPhoneNumber);
    }

    @GetMapping("/firstName/{firstName}")
    public Set<Student> getStudentsByFirstName(@PathVariable String firstName){
        return studentService.getStudentByFirstName(firstName);
    }

    @GetMapping("/lastName/{lastName}")
    public Set<Student> getStudentsByLastName(@PathVariable String lastName){
        return studentService.getStudentByLastName(lastName);
    }

    @GetMapping("/firstName_lastName/{firstName}/{lastName}")
    public Set<Student> getStudentsByLastName(@PathVariable String lastName, @PathVariable String firstName){
        return studentService.getStudentByLastName(lastName);
    }

    @GetMapping
    public Set<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @PatchMapping("/{id}")
    public boolean updateStudent(@RequestBody Student student, @PathVariable int id){
        return studentService.updateStudent(id,student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id){
        studentService.deleteStudent(id);
    }

}
