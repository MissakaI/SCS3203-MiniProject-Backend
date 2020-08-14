package lk.ac.cmb.ucsc.scs3203.miniproject.backend.controller;

import lk.ac.cmb.ucsc.scs3203.miniproject.backend.models.Subject;
import lk.ac.cmb.ucsc.scs3203.miniproject.backend.service.SubjectService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

import java.util.List;

@RestController
@RequestMapping("/api/v1/subjects/")
public class SubjectController {

    SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

//    @GetMapping("/id/{id}")  //localhost:8080/scs3203/api/v1/subject/id/1
//    String demo(@RequestBody Subject id){
//        return "";
//    }
    @PostMapping
    public ResponseEntity addSubject (@RequestBody Subject subject) {
        Subject s =  subjectService.addSubject(subject);
        if (s != null)
            return new ResponseEntity(HttpStatus.OK);
        else
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    public Set<Subject> getSubject() {
        return subjectService.getAllSubjects();
    }

    @GetMapping("/{code}")
    public Subject getSubjectByCode(@PathVariable int code) {
        return subjectService.getSubjectByCode(code);
    }

    @GetMapping("/name/{name}")
    public Set<Subject> getSubjectByName(@PathVariable String name) {
        return subjectService.getSubjectByName(name);
    }

    @GetMapping("/grade/{grade}")
    public Set<Subject> getSubjectByGrade(@PathVariable int grade) {
        return subjectService.getSubjectByGrade(grade);
    }

    @GetMapping("/name_grade/{name}/{grade}")
    public Subject getSubjectByNameAndGrade(@PathVariable String name, @PathVariable int grade) {
        return subjectService.getSubjectByNameAndGrade(name, grade);
    }

    @PatchMapping
    public boolean updateSubject(@RequestBody int code, @RequestBody Subject subject) {
        return subjectService.updateSubject(code, subject);
    }

    @DeleteMapping("/{code}")
    public void deleteSubjectByCode(@PathVariable int code) {
        subjectService.deleteSubjectByCode(code);
    }

}
