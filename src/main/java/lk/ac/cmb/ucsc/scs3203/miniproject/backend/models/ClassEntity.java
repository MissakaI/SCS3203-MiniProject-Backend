package lk.ac.cmb.ucsc.scs3203.miniproject.backend.models;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Set;

@Entity
public class ClassEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Teacher teacher;

    @ManyToOne
    private Subject subject;

    @ManyToMany
    private Set<Student> students;

    private LocalTime time;

    private String day;

    private String hall;

    public ClassEntity() {
    }

    public ClassEntity(Teacher teacher, Subject subject, Set<Student> students, LocalTime time, String day, String hall) {
        this.teacher = teacher;
        this.subject = subject;
        this.students = students;
        this.time = time;
        this.day = day;
        this.hall = hall;
    }

    public ClassEntity(int id, Teacher teacher, Subject subject, Set<Student> students, LocalTime time, String day, String hall) {
        this.id = id;
        this.teacher = teacher;
        this.subject = subject;
        this.students = students;
        this.time = time;
        this.day = day;
        this.hall = hall;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getHall() {
        return hall;
    }

    public void setHall(String hall) {
        this.hall = hall;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
