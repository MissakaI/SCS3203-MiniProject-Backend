package lk.ac.cmb.ucsc.scs3203.miniproject.backend.service;

import lk.ac.cmb.ucsc.scs3203.miniproject.backend.models.Student;
import lk.ac.cmb.ucsc.scs3203.miniproject.backend.repository.StudentRepository;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@Log4j2
public class StudentService {

    @Autowired
    StudentRepository repository;

    //creating a new student
    public Student addNewStudent(Student student){
        log.info("adding student "+student);
        System.out.println("Adding student "+ student.toString());
        return repository.save(student);
    }

    //getting all students
    public Set<Student> getAllStudents(){
        log.info("fetching all students");
        return (Set<Student>) repository.findAll();
    }

    //getting a student by id
    public Student getStudentById(Integer id){
            Optional<Student> student = repository.findById(id);
            if(student.isEmpty()){
                log.info("No student found");
                return null; //null will be returned if no data found
            }
            Student data = student.get();
            log.info("Fetching student data"+data.toString());
            return data; //a student entity will be returned if data found
    }

    public Student getStudentByEmail(String email){
        Optional<Student> student = repository.findByEmail(email);
        if(student.isEmpty()){
            log.info("No student found");
            //System.out.println("No student found");
            return null;
        }
        Student data = student.get();
        return data;
    }

    public Set<Student> getStudentByFirstName(String firstName){
        return repository.findAllByFirstName(firstName);
    }

    public Set<Student> getStudentByLastName(String lastName){
        return repository.findAllByLastName(lastName);

    }

    public Student getStudentByFirstNameAndLastName(String firstName,String lastName){
        Optional<Student> student = repository.findByFirstNameAndLastName(firstName,lastName);
        if(student.isEmpty()){
            log.info("No student found");
            //System.out.println("No student found");
            return null;
        }
        Student data = student.get();
        return data;
    }

    public Student getStudentByPrimaryMobile(String primaryMobile){
        Optional<Student> student = repository.findByPrimaryMobile(primaryMobile);
        if(student.isEmpty()){
            log.info("No student found");
            //System.out.println("No student found");
            return null;
        }
        Student data = student.get();
        return data;
    }

    public Set<Student> getStudentsByCity(String city){
        log.info("Fetching all student by city "+city);
        return repository.findAllByCity(city);
    }

    public Set<Student> getStudentsBySuburb(String suburb){
        log.info("Fetching all student by suburb"+suburb);
        return repository.findAllBySuburb(suburb);
    }

    //updating a student
    public boolean updateStudent(Integer id, Student student){
        Student studentToUpdate =this.getStudentById(id);
        if(studentToUpdate == null){
            log.info("No student found");
            return false; //if update is not successful false will be returned
        }
        else{
            log.info("Student to update found "+studentToUpdate.toString());
            studentToUpdate.setFirstName(student.getFirstName());
            studentToUpdate.setLastName(student.getLastName());
            studentToUpdate.setCity(student.getCity());
            studentToUpdate.setEmail(student.getEmail());
            studentToUpdate.setPrimaryMobile(student.getPrimaryMobile());
            studentToUpdate.setSuburb(student.getSuburb());
            repository.save(studentToUpdate);
            log.info("Student updated "+studentToUpdate.toString());
            return true; //if update is successful true will be returned
        }
    }

    //deleting a student
    public void deleteStudent(Integer id){
        log.info("Student with following id will be deleted"+id);
        repository.deleteById(id);
    }

}
