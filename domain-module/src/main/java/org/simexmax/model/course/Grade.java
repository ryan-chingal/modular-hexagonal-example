package org.simexmax.model.course;

import org.simexmax.model.person.Student;

/**
 * Represents an exam.
 *
 * @author Hardy Ryan Chingal Martinez <ryan.chingal@gmail.com>
 */
public class Grade {

    /**
     * The grade obtained in the exam.
     */
    private Double grade;
    /**
     * The student who took the exam.
     */
    private final Student student;
    /**
     * The subject of the exam.
     */
    private final Subject subject;

    /**
     * Weight of the exam in the final grade calculation.
     */
    private final Double weighting;

    /**
     * Period in which the exam was conducted.
     */
    private final Integer period;

    public Grade(Double grade, Student student, Subject subject, Integer period, Double weighting) {
        this.grade = grade;
        this.student = student;
        this.subject = subject;
        this.period = period;
        this.weighting = weighting;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private Double grade;
        private Student student;
        private Subject subject;
        private Integer period;
        private Double weighting;
        public Builder() {
            this.grade = 0.0;
            this.student = null;
            this.subject = null;
            this.weighting = 1d;
            this.period = 1;
        }

        public Builder grade(Double grade) {
            this.grade = grade;
            return this;
        }

        public Builder student(Student student) {
            this.student = student;
            return this;
        }

        public Builder subject(Subject subject) {
            this.subject = subject;
            return this;
        }

        public Builder period(Integer period) {
            this.period = period;
            return this;
        }

        public Builder weighting(Double weighting) {
            this.weighting = weighting;
            return this;
        }

        public Grade build() {
            return new Grade(grade, student, subject, period, weighting);
        }

    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public Student getStudent() {
        return student;
    }

    public Subject getSubject() {
        return subject;
    }

    public Integer getPeriod() {
        return period;
    }
    public Double getWeighting() {
        return weighting;
    }
}
