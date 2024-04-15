package org.simexmax.model.course;

import org.simexmax.model.person.Teacher;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a subject.
 *
 * @author Hardy Ryan Chingal Martinez <ryan.chingal@gmail.com>
 */
public class Subject {

    /**
     * Subject code
     */
    private final String code;
    /**
     * Name of the subject.
     */
    private final String subjectName;
    /**
     * Teacher who teaches the subject.
     */
    private final Teacher teacher;
    /**
     * List of exams associated with the subject.
     */
    private List<Grade> examList;

    public Subject(String code, String subjectName, Teacher teacher, List<Grade> examList) {
        this.code = code;
        this.subjectName = subjectName;
        this.teacher = teacher;
        this.examList = examList;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public String getCode() {
        return code;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public List<Grade> getExamList() {
        return examList;
    }

    public void setExamList(List<Grade> examList) {
        this.examList = examList;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String code;
        private String subjectName;
        private Teacher teacher;
        private List<Grade> examList;

        public Builder() {
            this.examList = new ArrayList<>();
        }

        public Builder code(String code) {
            this.code = code;
            return this;
        }

        public Builder subjectName(String subjectName) {
            this.subjectName = subjectName;
            return this;
        }

        public Builder teacher(Teacher teacher) {
            this.teacher = teacher;
            return this;
        }

        public Builder exams(List<Grade> examList) {
            this.examList = examList;
            return this;
        }

        public Builder exam(Grade exam) {
            this.examList.add(exam);
            return this;
        }

        public Subject build() {
            return new Subject(code, subjectName, teacher, examList);
        }
    }
}
