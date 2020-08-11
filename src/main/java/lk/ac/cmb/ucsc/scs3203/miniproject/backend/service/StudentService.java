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

    public void addNewStudent(Student student){
        //log.info("adding student "+student);
        System.out.println("Adding student "+ student.toString());
        repository.save(student);
    }

    public Set<Student> getAllStudents(){
        return (Set<Student>) repository.findAll();
    }

    public Student getStudentById(Integer id){
            Optional<Student> student = repository.findById(id);
            if(student.isEmpty()){
                log.info("No student found");
                System.out.println("No student found");
                return null;
            }
            Student data = student.get();
            return data;
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
        return repository.findAllByCity(city);
    }

    public Set<Student> getStudentsBySuburb(String suburb){
        return repository.findAllBySuburb(suburb);
    }

    public boolean updateStudent(Integer id, Student student){
        Student studentToUpdate =this.getStudentById(id);
        if(studentToUpdate == null){
            log.info("No student found");
            return false;
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
            return true;
        }
    }

    public void deleteStudent(Integer id){
        repository.deleteById(id);
    }

}
