package lk.ac.cmb.ucsc.scs3203.miniproject.backend.service;

import lk.ac.cmb.ucsc.scs3203.miniproject.backend.models.Subject;
import lk.ac.cmb.ucsc.scs3203.miniproject.backend.repository.SubjectRepository;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Log4j2
public class SubjectService {
    SubjectRepository repository;

    public SubjectService(SubjectRepository repository) {
        this.repository = repository;
    }

    //create subject
    public Subject addSubject(Subject subject) {
        log.info("add subject" + subject);
        return repository.save(subject);
    }

    //get all subjects
    public List<Subject> getAllSubjects() {
        log.info("fetching all subjects");
        return (List<Subject>) repository.findAll();
    }

    //get subject by subject code
    public Subject getSubjectByCode(int id) {
        log.info("fetching data from teacher id :" + id);
        Optional<Subject> subject = repository.findBySubjectCode(id);
        if (subject.isEmpty()){
            log.info("Subject not found!");
            return null;
        }

        Subject sub = subject.get();
        log.info("Subject found :" + sub.toString());
        return sub;
    }

    //get Subject by subject name
    public Set<Subject> getSubjectByName(String name) {
        log.info("fetching data from subject name :" + name);
        return (Set<Subject>) repository.findBySubjectName(name);
    }

    //get Subject by Grade
    public Set<Subject> getSubjectByGrade(Integer grade) {
        log.info("fetching data from subject grade :" + grade);
        return (Set<Subject>) repository.findByGrade(grade);
    }

    //get Subject by name and grade
    public Subject getSubjectByNameAndGrade(String name, Integer grade) {
        log.info("fetching data from subject name :" + name +" grade: " + grade);
        return repository.findBySubjectNameAndGrade(name, grade);
    }

    //update Subject
    public boolean updateSubject(Integer code, Subject sub) {
        log.info("update subject id:"+ code);
        Subject subjectToUpdate = this.getSubjectByCode(code);
        if (subjectToUpdate == null){
            log.info("No teacher found");
            return false; //return false if update is not successful.
        }
        else {
            log.info("found subject to update :"+ subjectToUpdate.toString());
            subjectToUpdate.setSubjectName(sub.getSubjectName());
            subjectToUpdate.setGrade(sub.getGrade());
            return true; // return true if update is successful.
        }
    }

    //delete subject with code
    public void deleteSubjectByCode (Integer code) {
        log.info("Delete subject with code :" + code);
        repository.deleteById(code);
    }
}
