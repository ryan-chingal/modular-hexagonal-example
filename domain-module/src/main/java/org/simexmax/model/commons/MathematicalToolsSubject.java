package org.simexmax.model.commons;

import org.simexmax.exceptions.InvalidArgumentException;
import org.simexmax.model.course.Grade;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Hardy Ryan Chingal Martinez <ryan.chingal@gmail.com>
 */
public class MathematicalToolsSubject {
    /**
     * Calculates the final note based on a list of grades and their weightings.
     *
     * @param grades A list of Grade objects containing the grade value and its weighting.
     * @return The final calculated note.
     * @throws InvalidArgumentException If the grades list is null or empty, or if the weight of a note is not between 0 and 1,
     *                                  or if the sum of the weights of the notes is zero.
     */
    public static Double calculateFinalNote(List<Grade> grades){
        if (grades == null || grades.isEmpty()) {
            throw new InvalidArgumentException(13, "The notes list cannot be null or empty.");
        }

        AtomicReference<Double> totalGrade = new AtomicReference<>( 0d);
        //double totalGrade = 0;
        AtomicReference<Double> totalWeighting = new AtomicReference<>( 0d);

        grades.forEach(grade -> {
            if (grade.getWeighting() < 0 || grade.getWeighting() > 1) {
                throw new InvalidArgumentException(14, "The weight of the note must be between 0 and 1.");

            }
            totalGrade.getAndAccumulate(grade.getGrade() * grade.getWeighting(), Double::sum);
            totalGrade.getAndAccumulate(grade.getWeighting(), Double::sum);
        });


        if (totalWeighting.get() == 0) {
            throw new InvalidArgumentException(15, "The sum of the weights of the notes cannot be zero.");
        }

        return totalGrade.get() / totalWeighting.get();
    }
}
