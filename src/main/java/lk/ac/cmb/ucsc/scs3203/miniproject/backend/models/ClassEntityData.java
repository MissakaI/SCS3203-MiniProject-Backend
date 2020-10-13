package lk.ac.cmb.ucsc.scs3203.miniproject.backend.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.time.LocalTime;
import java.util.Set;

public class ClassEntityData {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Integer teacherId;

    private Integer subjectId;

    private Set<Integer> studentsIds;

    private LocalTime time;

    private String day;

    private String hall;


    @Override
    public String toString() {
        return "ClassEntityData{" +
                "id=" + id +
                ", teacherId='" + teacherId + '\'' +
                ", subjectId='" + subjectId + '\'' +
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

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public LocalTime getTime() {
        return time;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Set<Integer> getStudentsIds() {
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
