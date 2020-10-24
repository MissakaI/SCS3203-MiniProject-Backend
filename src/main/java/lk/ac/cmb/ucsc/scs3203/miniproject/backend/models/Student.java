package lk.ac.cmb.ucsc.scs3203.miniproject.backend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Student extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    public Student() {
    }

    public Student(String firstName, String lastName, String suburb, String city, String primaryMobile, String email) {
        super(firstName, lastName, suburb, city, primaryMobile, email);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return getId() == student.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
