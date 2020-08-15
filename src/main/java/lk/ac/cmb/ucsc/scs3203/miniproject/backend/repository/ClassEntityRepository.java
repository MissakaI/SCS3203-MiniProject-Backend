package lk.ac.cmb.ucsc.scs3203.miniproject.backend.repository;

import lk.ac.cmb.ucsc.scs3203.miniproject.backend.models.ClassEntity;
import lk.ac.cmb.ucsc.scs3203.miniproject.backend.models.Student;
import lk.ac.cmb.ucsc.scs3203.miniproject.backend.models.Teacher;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalTime;
import java.util.Optional;
import java.util.Set;

public interface ClassEntityRepository extends CrudRepository<ClassEntity,Integer > {
    //id , teacher , students, time , day, hall
    Set<ClassEntity> findClassEntitiesByDayEquals(String searchDay);
    Set<ClassEntity> findClassEntitiesByDayEqualsAndTimeContaining(String searchDay, LocalTime time);
    Set<ClassEntity> findClassEntitiesByTimeContaining(LocalTime time);
    Set<ClassEntity> findClassEntitiesByTeacher(Teacher teacher);
    Set<ClassEntity> findClassEntitiesByStudents(Student student);
    Set<ClassEntity> findClassEntitiesByHall(String hall);
    Optional<ClassEntity> findClassEntityByHallEqualsAndDayEqualsAndTimeContaining(String hall, String day, LocalTime time);
}
