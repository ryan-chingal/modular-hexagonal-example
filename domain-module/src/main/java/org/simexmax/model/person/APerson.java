package org.simexmax.model.person;

import java.util.List;

/**
 * @author Hardy Ryan Chingal Martinez <ryan.chingal@gmail.com>
 */
public abstract class APerson {
    /**
     * APerson ANme for login usage
     */
    protected String userName;
    /**
     * APerson first name
     */
    protected String firstName;
    /**
     * APerson second name
     */
    protected String secondName;
    /**
     * APerson first lastname
     */
    protected String firstLastname;
    /**
     * APerson second lastname
     */
    protected String secondLastname;
    /**
     * APerson e-mail
     */
    protected String email;
    /**
     * APerson password
     */
    protected String password;
    /**
     * APerson e-mail
     */
    protected List<Identification> identificationList;
    /**
     * APerson birthdate
     */
    protected Long birthDate;

    public APerson(String userName, String firstName, String secondName, String firstLastname, String secondLastname,
                   String email, String password, List<Identification> identificationList, Long birthDate) {
        this.userName = userName;
        this.firstName = firstName;
        this.secondName = secondName;
        this.firstLastname = firstLastname;
        this.secondLastname = secondLastname;
        this.email = email;
        this.password = password;
        this.identificationList = identificationList;
        this.birthDate = birthDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFirstLastname() {
        return firstLastname;
    }

    public void setFirstLastname(String firstLastname) {
        this.firstLastname = firstLastname;
    }

    public String getSecondLastname() {
        return secondLastname;
    }

    public void setSecondLastname(String secondLastname) {
        this.secondLastname = secondLastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Long birthDate) {
        this.birthDate = birthDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Identification> getIdentificationList() {
        return identificationList;
    }

    public void setIdentificationList(List<Identification> identificationList) {
        this.identificationList = identificationList;
    }
}
