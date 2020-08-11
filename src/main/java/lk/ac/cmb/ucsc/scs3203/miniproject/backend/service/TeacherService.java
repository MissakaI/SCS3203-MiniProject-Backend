package lk.ac.cmb.ucsc.scs3203.miniproject.backend.service;

import lk.ac.cmb.ucsc.scs3203.miniproject.backend.models.Teacher;
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

    //service method to add a new teacher
    public void addNewTeacher(Teacher teacher){
        log.info("adding teacher "+teacher.toString());
        repository.save(teacher);
    }

    //service method to get all teachers. A set of teachers will be returned
    public Set<Teacher> getAllTeachers(){
        log.info("Fetching all teachers");
        return (Set<Teacher>) repository.findAll();
    }

    //service method to get a teacher by specific ID
    public Teacher getTeacherById(Integer id){
        Optional<Teacher> teacher = repository.findById(id);
        if(teacher.isEmpty()){
            log.info("No teacher found");
            return null; //if no teacher found null will be returned
        }

        Teacher data = teacher.get();
        log.info("Teacher found "+data.toString());
        return data; //if teacher found data will be returned as a Teacher entity
    }

    //service method to get a teacher by specific email
    public Teacher getTeacherByEmail(String email){
        Optional<Teacher> teacher = repository.findByEmail(email);
        if(teacher.isEmpty()){
            log.info("No teacher found");
            return null; //if no teacher found null will be returned
        }
        Teacher data = teacher.get();
        log.info("Teacher found "+data.toString());
        return data; //if teacher found data will be returned as a Teacher entity
    }

    //searching for a student by specific first name. A set of teachers will be returned
    public Set<Teacher> getTeacherByFirstName(String firstName){
        log.info("Fetching all teachers by first name");
        return repository.findAllByFirstName(firstName);
    }

    //searching for a student by specific last name. A set of teachers will be returned
    public Set<Teacher> getTeacherByLastName(String lastName){
        log.info("Fetching all teachers by last name");
        return repository.findAllByLastName(lastName);
    }

    //service method to get a teacher by specific first name and last name
    public Teacher getTeacherByFirstNameAndLastName(String firstName,String lastName){
        Optional<Teacher> teacher = repository.findByFirstNameAndLastName(firstName,lastName);
        if(teacher.isEmpty()){
            log.info("No teacher found");
            return null; //if no teacher found null will be returned
        }
        Teacher data = teacher.get();
        log.info("Teacher found "+data.toString());
        return data; //teacher found and it will be returned as a Teacher entity
    }

    //service method to get a teacher by specific phone number
    public Teacher getTeacherByPrimaryMobile(String primaryMobile){
        Optional<Teacher> teacher = repository.findByPrimaryMobile(primaryMobile);
        if(teacher.isEmpty()){
            log.info("No teacher found");
            return null; //if no teacher found null will be returned
        }
        Teacher data = teacher.get();
        log.info("Teacher found "+data.toString());
        return data; //teacher found and it will be returned as a Teacher entity
    }

    //service method to get all the teachers by a specific city
    public Set<Teacher> getTeachersByCity(String city){
        log.info("Fetching all the teachers by city");
        return repository.findAllByCity(city);
    }

    //service method to get all the teachers by a specific suburb
    public Set<Teacher> getTeachersBySuburb(String suburb){
        log.info("Fetching all the teachers by city");
        return repository.findAllBySuburb(suburb);
    }

    //service method to update a teacher
    public boolean updateTeacher(Integer id, Teacher teacher){
        Teacher teacherToUpdate =this.getTeacherById(id);
        if(teacherToUpdate == null){
            log.info("No teacher found");
            return false; //return false if update is not successful
        }
        else{
            log.info("Teacher to update found "+teacherToUpdate.toString());
            teacherToUpdate.setFirstName(teacher.getFirstName());
            teacherToUpdate.setLastName(teacher.getLastName());
            teacherToUpdate.setCity(teacher.getCity());
            teacherToUpdate.setEmail(teacher.getEmail());
            teacherToUpdate.setPrimaryMobile(teacher.getPrimaryMobile());
            teacherToUpdate.setSuburb(teacher.getSuburb());
            repository.save(teacherToUpdate);
            log.info("Teacher updated "+teacherToUpdate.toString());
            return true; //return true if update is not successful
        }
    }

    //service method to delete a teacher
    public void deleteTeacher(Integer id){
        log.info("Deleting the teacher with id "+id);
        repository.deleteById(id);
    }

}
