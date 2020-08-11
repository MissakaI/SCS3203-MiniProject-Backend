package lk.ac.cmb.ucsc.scs3203.miniproject.backend.repository;

import lk.ac.cmb.ucsc.scs3203.miniproject.backend.models.Teacher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Integer> {

    Optional<Teacher> findByFirstNameAndLastName(String firstName, String lastName);
    Set<Teacher> findAllByFirstName(String firstName);
    Set<Teacher> findAllByLastName(String lastName);
    Optional<Teacher> findByPrimaryMobile(String primaryMobile);
    Set<Teacher> findAllByCity(String city);
    Set<Teacher> findAllBySuburb(String suburb);
    Optional<Teacher> findByEmail(String email);
}
