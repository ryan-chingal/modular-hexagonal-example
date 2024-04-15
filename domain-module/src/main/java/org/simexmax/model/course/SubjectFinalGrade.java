package org.simexmax.model.course;

import org.simexmax.model.person.Student;

/**
 * @author Hardy Ryan Chingal Martinez <ryan.chingal@gmail.com>
 */
public class SubjectFinalGrade {
    /**
     * The subject for which the final grade is recorded.
     */
    private final Subject subject;
    /**
     * The student whose final grade is recorded.
     */
    private final Student student;
    /**
     * The final grade achieved by the student in the subject.
     */
    private final Double finalGrade;

    /**
     * Constructs a new SubjectFinalGrade instance.
     *
     * @param subject    The subject for which the final grade is recorded.
     * @param student    The student whose final grade is recorded.
     * @param finalGrade The final grade achieved by the student in the subject.
     */
    public SubjectFinalGrade(Subject subject, Student student, Double finalGrade) {
        this.subject = subject;
        this.student = student;
        this.finalGrade = finalGrade;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Subject subject;
        private Student student;
        private double finalGrade;

        public Builder() {
            this.subject = null;
            this.student = null;
            this.finalGrade = 0d;
        }

        public Builder subject(Subject subject) {
            this.subject = subject;
            return this;
        }

        public Builder student(Student student) {
            this.student = student;
            return this;
        }

        public Builder finalGrade(double finalGrade) {
            this.finalGrade = finalGrade;
            return this;
        }

        public SubjectFinalGrade build() {
            return new SubjectFinalGrade(subject, student, finalGrade);
        }
    }

    public Subject getSubject() {
        return subject;
    }


    public Student getStudent() {
        return student;
    }

    public Double getFinalGrade() {
        return finalGrade;
    }

}
