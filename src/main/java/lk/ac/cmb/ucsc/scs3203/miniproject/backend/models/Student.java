package lk.ac.cmb.ucsc.scs3203.miniproject.backend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
}
