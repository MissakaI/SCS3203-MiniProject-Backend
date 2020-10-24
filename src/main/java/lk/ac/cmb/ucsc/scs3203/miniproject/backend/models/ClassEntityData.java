package lk.ac.cmb.ucsc.scs3203.miniproject.backend.models;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class ClassEntityData {

    private int id;

    private int teacher;

    private int subject;

    private Set<Integer> studentsIds;

    private LocalTime time;

    private String day;

    private String hall;

    public ClassEntityData(int id, int teacher, int subject, Set<Integer> studentsIds, LocalTime time, String day, String hall) {
        this.id = id;
        this.teacher = teacher;
        this.subject = subject;
        this.studentsIds = studentsIds;
        this.time = time;
        this.day = day;
        this.hall = hall;
    }

    public ClassEntityData() {
    }

    @Override
    public String toString() {
        return "ClassEntityData{" +
                "id=" + id +
                ", teacherId=" + teacher +
                ", subjectId=" + subject +
                ", studentsIds=" + studentsIds +
                ", time=" + time +
                ", day='" + day + '\'' +
                ", hall='" + hall + '\'' +
                '}';
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTeacherId() {
        return teacher;
    }

    public void setTeacher(int teacher) {
        this.teacher = teacher;
    }

    public LocalTime getTime() {
        return time;
    }

    public int getSubjectId() {
        return subject;
    }

    public void setSubject(int subject) {
        this.subject = subject;
    }

    public Set<Integer> getStudentsIds() {
        if (studentsIds == null)
            studentsIds=new HashSet<>();
        return studentsIds;
    }

    public void setStudentsIds(Set<Integer> studentsIds) {
        this.studentsIds = studentsIds;
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
}
