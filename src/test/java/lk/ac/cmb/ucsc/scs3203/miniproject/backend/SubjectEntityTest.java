package lk.ac.cmb.ucsc.scs3203.miniproject.backend;

import lk.ac.cmb.ucsc.scs3203.miniproject.backend.models.Subject;
import lk.ac.cmb.ucsc.scs3203.miniproject.backend.repository.SubjectRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Testable
@SpringBootTest
public class SubjectEntityTest {

    @Autowired
    SubjectRepository repository;

    @Test
    public void createNewSubjects(){
        List<Subject> subjects=new ArrayList<>();
        for (int i = 6; i < 12; i++) {
            Subject subject=new Subject();
            subject.setSubjectName("SCIENCE");
            subject.setGrade(i);
            subjects.add(subject);
        }

        repository.saveAll(subjects);
    }

}
