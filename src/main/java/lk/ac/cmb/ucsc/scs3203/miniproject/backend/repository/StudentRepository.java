package lk.ac.cmb.ucsc.scs3203.miniproject.backend.repository;

import lk.ac.cmb.ucsc.scs3203.miniproject.backend.models.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

    Optional<Student> findByFirstNameAndLastName(String firstName,String lastName);
    Set<Student> findAllByFirstName(String firstName);
    Set<Student> findAllByLastName(String lastName);
    Optional<Student> findByPrimaryMobile(String primaryMobile);
    Set<Student> findAllByCity(String city);
    Set<Student> findAllBySuburb(String suburb);
    Optional<Student> findByEmail(String email);
}
