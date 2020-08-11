package lk.ac.cmb.ucsc.scs3203.miniproject.backend.service;

import lk.ac.cmb.ucsc.scs3203.miniproject.backend.models.Teacher;
import lk.ac.cmb.ucsc.scs3203.miniproject.backend.repository.TeacherRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@Log4j2
public class TeacherService {

    @Autowired
    TeacherRepository repository;

    public void addNewTeacher(Teacher teacher){
        //log.info("adding teacher "+teacher);
        System.out.println("Adding teacher "+ teacher.toString());
        repository.save(teacher);
    }

    public Set<Teacher> getAllTeachers(){
        return (Set<Teacher>) repository.findAll();
    }

    public Teacher getTeacherById(Integer id){
        Optional<Teacher> teacher = repository.findById(id);
        if(teacher.isEmpty()){
            log.info("No teacher found");
            System.out.println("No teacher found");
            return null;
        }
        Teacher data = teacher.get();
        return data;
    }

    public Teacher getTeacherByEmail(String email){
        Optional<Teacher> teacher = repository.findByEmail(email);
        if(teacher.isEmpty()){
            log.info("No teacher found");
            //System.out.println("No teacher found");
            return null;
        }
        Teacher data = teacher.get();
        return data;
    }

    public Set<Teacher> getTeacherByFirstName(String firstName){
        return repository.findAllByFirstName(firstName);
    }

    public Set<Teacher> getTeacherByLastName(String lastName){
        return repository.findAllByLastName(lastName);

    }

    public Teacher getTeacherByFirstNameAndLastName(String firstName,String lastName){
        Optional<Teacher> teacher = repository.findByFirstNameAndLastName(firstName,lastName);
        if(teacher.isEmpty()){
            log.info("No teacher found");
            //System.out.println("No teacher found");
            return null;
        }
        Teacher data = teacher.get();
        return data;
    }

    public Teacher getTeacherByPrimaryMobile(String primaryMobile){
        Optional<Teacher> teacher = repository.findByPrimaryMobile(primaryMobile);
        if(teacher.isEmpty()){
            log.info("No teacher found");
            //System.out.println("No teacher found");
            return null;
        }
        Teacher data = teacher.get();
        return data;
    }

    public Set<Teacher> getTeachersByCity(String city){
        return repository.findAllByCity(city);
    }

    public Set<Teacher> getTeachersBySuburb(String suburb){
        return repository.findAllBySuburb(suburb);
    }

}
