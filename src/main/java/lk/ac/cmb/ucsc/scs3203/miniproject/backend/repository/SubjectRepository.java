package lk.ac.cmb.ucsc.scs3203.miniproject.backend.repository;

import lk.ac.cmb.ucsc.scs3203.miniproject.backend.models.Subject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface SubjectRepository extends CrudRepository<Subject,Integer> {

    Optional<Subject> findBySubjectCode(Integer code);
    Set<Subject> findBySubjectName(String name);
    Set<Subject> findByGrade(Integer grade);
    Subject findBySubjectNameAndGrade(String name,Integer grade);

}
