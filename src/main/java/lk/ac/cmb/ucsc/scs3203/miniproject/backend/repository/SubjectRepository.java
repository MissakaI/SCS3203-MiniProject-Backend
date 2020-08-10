package lk.ac.cmb.ucsc.scs3203.miniproject.backend.repository;

import lk.ac.cmb.ucsc.scs3203.miniproject.backend.models.Subject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends CrudRepository<Subject,Integer> {

    Subject findBySubjectCode(String code);

    Subject findBySubjectNameAndGrade(String name,Integer grade);

}
