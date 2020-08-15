package lk.ac.cmb.ucsc.scs3203.miniproject.backend.models;

import javax.persistence.MappedSuperclass;
import java.util.List;

@MappedSuperclass
public class User {
    protected String firstName;
    protected String lastName;
    protected String suburb;
    protected String city;

    protected String primaryMobile;
    protected String email;

    public User() {
    }

    public User(String firstName, String lastName, String suburb, String city, String primaryMobile, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.suburb = suburb;
        this.city = city;
        this.primaryMobile = primaryMobile;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPrimaryMobile() {
        return primaryMobile;
    }

    public void setPrimaryMobile(String primaryMobile) {
        this.primaryMobile = primaryMobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", suburb='" + suburb + '\'' +
                ", city='" + city + '\'' +
                ", primaryMobile='" + primaryMobile + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
