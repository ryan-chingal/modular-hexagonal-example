package org.simexmax.model.person;

import org.simexmax.model.course.Subject;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a student.
 *
 * @author Hardy Ryan Chingal Martinez <ryan.chingal@gmail.com>
 */
public class Student extends APerson {
    /**
     * Student code
     */
    private final String code;
    /**
     * List of subjects in which the student is enrolled.
     */
    private final List<Subject> enrolledSubjects;

    public Student(String userName, String firstName, String secondName, String firstLastname, String secondLastname,
                   String email, String password, List<Identification> identificationList, Long birthDate, String code,
                   List<Subject> subjectList) {
        super(userName, firstName, secondName, firstLastname, secondLastname,
                email, password, identificationList, birthDate);
        this.code = code;
        this.enrolledSubjects = subjectList;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String userName;
        private String firstName;
        private String secondName;
        private String firstLastname;
        private String secondLastname;
        private String email;
        private String password;
        private List<Identification> identificationList;
        private Long birthDate;
        private String code;
        private List<Subject> subjectList;

        public Builder() {
            this.identificationList = new ArrayList<>();
            this.subjectList = new ArrayList<>();
        }

        public Builder code(String code) {
            this.code = code;
            return this;
        }

        public Builder userName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder secondName(String secondName) {
            this.secondName = secondName;
            return this;
        }

        public Builder firstLastname(String firstLastname) {
            this.firstLastname = firstLastname;
            return this;
        }

        public Builder secondLastname(String secondLastname) {
            this.secondLastname = secondLastname;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder birthDate(Long birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public Builder identificationList(List<Identification> identificationList) {
            this.identificationList = identificationList;
            return this;
        }

        public Builder identification(Identification identification) {
            this.identificationList.add(identification);
            return this;
        }

        public Builder enrolledSubjects(List<Subject> subjectList) {
            this.subjectList = subjectList;
            return this;
        }

        public Builder enrolledSubject(Subject subject) {
            this.subjectList.add(subject);
            return this;
        }

        public Student build(){
            return new Student(userName, firstName, secondName, firstLastname, secondLastname, email, password,
                    identificationList, birthDate, code, subjectList);
        }
    }

    public String getCode() {
        return code;
    }

    public List<Subject> getEnrolledSubjects() {
        return enrolledSubjects;
    }
}
