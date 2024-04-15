package org.simexmax.model.course;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hardy Ryan Chingal Martinez <ryan.chingal@gmail.com>
 */
public class SubjectGrades {
    /**
     * The subject for which the final grade is recorded.
     */
    private final Subject subject;
    /**
     * Grades related to a subject.
     */
    private final List<Grade> subjectGrades;

    public SubjectGrades(Subject subject, List<Grade> subjectGrades) {
        this.subject = subject;
        this.subjectGrades = subjectGrades;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Subject subject;
        private List<Grade> subjectGrades;

        public Builder(){
            this.subjectGrades = new ArrayList<>();
        }

        public Builder subject(Subject subject) {
            this.subject = subject;
            return this;
        }

        public Builder subjectGrades(List<Grade> subjectGrades) {
            this.subjectGrades = subjectGrades;
            return this;
        }

        public Builder subjectGrade(Grade subjectGrade) {
            this.subjectGrades.add(subjectGrade);
            return this;
        }

        public SubjectGrades build() {
            return new SubjectGrades(subject, subjectGrades);
        }
    }

    public Subject getSubject() {
        return subject;
    }

    public List<Grade> getSubjectGrades() {
        return subjectGrades;
    }
}
