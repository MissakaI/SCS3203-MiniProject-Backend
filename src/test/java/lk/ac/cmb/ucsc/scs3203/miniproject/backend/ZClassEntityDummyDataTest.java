package lk.ac.cmb.ucsc.scs3203.miniproject.backend;

import lk.ac.cmb.ucsc.scs3203.miniproject.backend.models.ClassEntity;
import lk.ac.cmb.ucsc.scs3203.miniproject.backend.models.Student;
import lk.ac.cmb.ucsc.scs3203.miniproject.backend.models.Subject;
import lk.ac.cmb.ucsc.scs3203.miniproject.backend.models.Teacher;
import lk.ac.cmb.ucsc.scs3203.miniproject.backend.repository.ClassEntityRepository;
import lk.ac.cmb.ucsc.scs3203.miniproject.backend.repository.StudentRepository;
import lk.ac.cmb.ucsc.scs3203.miniproject.backend.repository.SubjectRepository;
import lk.ac.cmb.ucsc.scs3203.miniproject.backend.repository.TeacherRepository;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Testable
@SpringBootTest
public class ZClassEntityDummyDataTest {

    @Autowired
    ClassEntityRepository repository;

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    SubjectRepository subjectRepository;

    @Test
    public void newStudentDummyData(){
        Teacher teacher1=teacherRepository.findById(1).get();
        Teacher teacher2=teacherRepository.findById(2).get();

        Subject subject1=subjectRepository.findById(1).get();
        Subject subject2=subjectRepository.findById(2).get();

        List<ClassEntity> list=new ArrayList();
        list.add(new ClassEntity(teacher1, subject1, new HashSet<>(), LocalTime.of(8,0), "Monday","2-B"));
        list.add(new ClassEntity(teacher2, subject2, new HashSet<>(), LocalTime.of(14,0), "Sunday","3-A"));

        repository.saveAll(list);
    }

}
