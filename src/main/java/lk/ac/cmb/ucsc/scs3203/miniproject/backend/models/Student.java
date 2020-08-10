package lk.ac.cmb.ucsc.scs3203.miniproject.backend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    int id;
}
