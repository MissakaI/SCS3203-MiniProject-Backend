package lk.ac.cmb.ucsc.scs3203.miniproject.backend;

import lk.ac.cmb.ucsc.scs3203.miniproject.backend.models.Subject;
import lk.ac.cmb.ucsc.scs3203.miniproject.backend.repository.SubjectRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class SubjectEntityTest {

    @Autowired
    SubjectRepository repository;

    @Test
    public void createNewSubject(){
        Subject subject=new Subject();
        subject.setSubjectName("SYS_ADMIN");
        subject.setGrade(6);

        repository.save(subject);
    }

    @Test
    public void updateSubject(){
        Subject subject=repository.findBySubjectNameAndGrade("SYS_ADMIN",6);
        System.out.println("Subject Code"+subject.getSubjectCode());
        subject.setGrade(7);
        repository.save(subject);
    }

}
