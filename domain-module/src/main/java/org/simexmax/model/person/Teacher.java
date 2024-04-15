package org.simexmax.model.person;

import org.simexmax.model.course.Subject;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a teacher.
 *
 * @author Hardy Ryan Chingal Martinez <ryan.chingal@gmail.com>
 */
public class Teacher extends APerson {
    /**
     * Teacher code
     */
    private final String code;
    /**
     * List of subjects taught by the teacher.
     */
    private final List<Subject> subjectsTaught;

    public Teacher(String userName, String firstName, String secondName, String firstLastname, String secondLastname,
                   String email, String password, List<Identification> identificationList, Long birthDate, String code,
                   List<Subject> subjectsTaught) {
        super(userName, firstName, secondName, firstLastname, secondLastname, email, password, identificationList, birthDate);
        this.code = code;
        this.subjectsTaught = subjectsTaught;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String code;
        private String userName;
        private String firstName;
        private String secondName;
        private String firstLastname;
        private String secondLastname;
        private String email;
        private String password;
        private List<Identification> identificationList;
        private Long birthDate;
        private List<Subject> subjectsTaught;

        public Builder() {
            this.identificationList = new ArrayList<>();
            this.subjectsTaught = new ArrayList<>();
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

        public Builder subjectsTaught(List<Subject> subjectsTaught) {
            this.subjectsTaught = subjectsTaught;
            return this;
        }

        public Builder subjectTaught(Subject subjectTaught) {
            this.subjectsTaught.add(subjectTaught);
            return this;
        }

        public Teacher build() {
            return new Teacher(userName, firstName, secondName, firstLastname, secondLastname, email, password,
                    identificationList, birthDate, code, subjectsTaught);
        }
    }

    public String getCode() {
        return code;
    }

    public List<Subject> getSubjectsTaught() {
        return subjectsTaught;
    }
}
