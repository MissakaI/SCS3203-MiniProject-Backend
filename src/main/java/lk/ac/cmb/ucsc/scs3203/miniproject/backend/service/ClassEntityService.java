package lk.ac.cmb.ucsc.scs3203.miniproject.backend.service;

import lk.ac.cmb.ucsc.scs3203.miniproject.backend.models.*;
import lk.ac.cmb.ucsc.scs3203.miniproject.backend.repository.ClassEntityRepository;
import lk.ac.cmb.ucsc.scs3203.miniproject.backend.repository.TeacherRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Log4j2
public class ClassEntityService {

    @Autowired
    ClassEntityRepository repository;

    TeacherService teacherService;
    StudentService studentService;
    SubjectService subjectService;

    //id , teacher , students, time , day, hall

    public ClassEntity prepareData(ClassEntityData classData){
        log.info("preparing data", classData);
        Teacher teacher = teacherService.getTeacherById(classData.getTeacherId());
        Subject subject = subjectService.getSubjectByCode(classData.getSubjectId());
        Set<Student> students = classData.getStudentsIds().stream().
                map(id -> studentService.getStudentById(id)).
                collect(Collectors.toSet());
        ClassEntity classEntity = new ClassEntity();
        classEntity.setTeacher(teacher);
        classEntity.setStudents(students);
        classEntity.setSubject(subject);
        classEntity.setTime(classData.getTime());
        classEntity.setDay(classData.getDay());
        classEntity.setHall(classData.getHall());
        return classEntity;
    }

    //creating a new class entity
    public ClassEntity addNewClassEntity(ClassEntityData classData){
        log.info("creating a new class", classData);
        ClassEntity classEntity = this.prepareData(classData);
        log.info("creating the class");
        return repository.save(classEntity);
    }

    //find a class by id
    public ClassEntity findClassByID(Integer id){
        Optional<ClassEntity> classEntity = repository.findById(id);
        if(classEntity.isEmpty()){
            log.info("No class found");
            return null; //null will be returned if no data found
        }
        ClassEntity data = classEntity.get();
        log.info("Fetching class data"+data.toString());
        return data; //a class entity will be returned if data found
    }

    //get all classes
    public Set<ClassEntity> getAllClasses(){
        log.info("fetching all classes");
        return (Set<ClassEntity>) repository.findAll();
    }

    //get all classes in a specific day
    public Set<ClassEntity> findClassesByDay(String day){
        log.info("fetching all classes to "+day);
        return repository.findClassEntitiesByDayEquals(day);
    }

    //get all classes in a specific time
    public Set<ClassEntity> findClassesByTime(LocalTime time){
        log.info("fetching all classes to "+time);
        return repository.findClassEntitiesByTimeContaining(time);
    }

    //get all classes in specific day and a specific time
    public Set<ClassEntity> findClassByDayAndTime(String day, LocalTime time){
        log.info("fetching all classes to "+day+" and "+time);
        return repository.findClassEntitiesByDayEqualsAndTimeContaining(day,time);
    }

    //get a class in specific hall, day, time
    public ClassEntity findClassByHallAndDayAndTime(String hall,String day,LocalTime time){
        log.info("fetching class to "+day+" and "+time+ " and "+ hall);
        Optional<ClassEntity> classEntity = repository.findClassEntityByHallEqualsAndDayEqualsAndTimeContaining(hall,day,time);
        if(classEntity.isEmpty()){
            log.info("No class found");
            return null; //null will be returned if no data found
        }
        ClassEntity data = classEntity.get();
        log.info("Fetching class data"+data.toString());
        return data; //a class entity will be returned if data found
    }

    //find classes to a teacher
    public Set<ClassEntity> findClassByTeacher(Integer teacher_id){
        Teacher teacher = teacherService.getTeacherById(teacher_id);
        if(teacher != null){
            log.info("fetching all classes to "+teacher.toString());
            return repository.findClassEntitiesByTeacher(teacher);
        }
        else{
            log.info("fail to fetch the teacher with given id");
            return null;
        }
    }

    //find classes to a student
    public Set<ClassEntity> findClassByStudent(Integer student_id){
        Student student = studentService.getStudentById(student_id);
        if(student != null){
            log.info("fetching all classes to "+student.toString());
            return repository.findClassEntitiesByStudents(student);
        }
        else{
            log.info("fail to fetch the student with given id");
            return null;
        }
    }

    //find classes to a hall
    public Set<ClassEntity> findClassByHall(String hall){
        log.info("fetching all classes to "+hall);
        return repository.findClassEntitiesByHall(hall);
    }

    //update a class
    public boolean updateClassEntity(Integer id, ClassEntityData classData){
        ClassEntity classEntityToUpdate =this.findClassByID(id);
        if(classEntityToUpdate == null){
            log.info("No class found");
            return false; //if update is not successful false will be returned
        }
        else{
            ClassEntity classEntity = this.prepareData(classData);
            log.info("Class to update found "+classEntityToUpdate.toString());
            classEntityToUpdate.setHall(classEntity.getHall());
            classEntityToUpdate.setDay(classEntity.getDay());
            classEntityToUpdate.setTime(classEntity.getTime());
            classEntityToUpdate.setSubject(classEntity.getSubject());
            classEntityToUpdate.setTeacher(classEntity.getTeacher());
            classEntityToUpdate.setStudents(classEntity.getStudents());
            repository.save(classEntityToUpdate);
            log.info("Class updated "+classEntityToUpdate.toString());
            return true; //if update is successful true will be returned
        }
    }
    //delete a class
    public void deleteClassEntity(Integer id){
        log.info("Class with following id will be deleted"+id);
        repository.deleteById(id);
    }
}
