package lk.ac.cmb.ucsc.scs3203.miniproject.backend.controller;

import lk.ac.cmb.ucsc.scs3203.miniproject.backend.models.Student;
import lk.ac.cmb.ucsc.scs3203.miniproject.backend.models.Teacher;
import lk.ac.cmb.ucsc.scs3203.miniproject.backend.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/teacher")
@CrossOrigin
public class TeacherController {

    TeacherService teacherService;
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

//    @GetMapping("/id/{id}")
//    String demo(@RequestBody Teacher id){
//        return "";
//    }
    @PostMapping
    public void createTeacher(@RequestBody Teacher teacher){
    teacherService.addNewTeacher(teacher);
}

    @GetMapping("/{id}")
    public Teacher getTeacherById(@PathVariable int id){
        return teacherService.getTeacherById(id);
    }

    @GetMapping("/email/{email}")
    public Teacher getTeacherByEmail(@PathVariable String email){
        return teacherService.getTeacherByEmail(email);
    }

    @GetMapping("/mobile/{primaryPhoneNumber}")
    public Teacher getTeacherByPrimaryMobile(@PathVariable String primaryPhoneNumber){
        return teacherService.getTeacherByPrimaryMobile(primaryPhoneNumber);
    }

    @GetMapping("/firstName/{firstName}")
    public Set<Teacher> getTeachersByFirstName(@PathVariable String firstName){
        return teacherService.getTeacherByFirstName(firstName);
    }

    @GetMapping("/lastName/{lastName}")
    public Set<Teacher> getTeachersByLastName(@PathVariable String lastName){
        return teacherService.getTeacherByLastName(lastName);
    }

    @GetMapping("/firstName_lastName/{firstName}/{lastName}")
    public Set<Teacher> getTeachersByLastName(@PathVariable String lastName, @PathVariable String firstName){
        return teacherService.getTeacherByLastName(lastName);
    }

    @GetMapping
    public ArrayList<Teacher> getAllTeachers(){
        return teacherService.getAllTeachers();
    }

    @PutMapping("/{id}")
    public boolean updateTeacher(@RequestBody Teacher teacher, @PathVariable int id){
        return teacherService.updateTeacher(id,teacher);
    }

    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable int id){
        teacherService.deleteTeacher(id);
    }



}
