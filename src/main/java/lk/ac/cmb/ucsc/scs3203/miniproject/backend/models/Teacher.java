package lk.ac.cmb.ucsc.scs3203.miniproject.backend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Teacher extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id;
}
