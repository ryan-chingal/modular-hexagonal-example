package org.simexmax.model.course;

/**
 * @author Hardy Ryan Chingal Martinez <ryan.chingal@gmail.com>
 */
public class FinalGrade {
    private Subject subject;
    private double finalGrade;

    public FinalGrade(Subject subject, double finalGrade) {
        this.subject = subject;
        this.finalGrade = finalGrade;
    }
    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public double getFinalGrade() {
        return finalGrade;
    }

    public void setFinalGrade(double finalGrade) {
        this.finalGrade = finalGrade;
    }

}
