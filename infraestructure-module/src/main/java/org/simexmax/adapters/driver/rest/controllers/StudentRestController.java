package org.simexmax.adapters.driver.rest.controllers;

import org.simexmax.dto.SubjectFinalGradeDto;
import org.simexmax.dto.SubjectGradesDto;
import org.simexmax.dto.person.StudentDto;
import org.simexmax.handlers.commands.StudentHandlerCommand;
import org.simexmax.handlers.queries.StudentHandlerQuery;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Hardy Ryan Chingal Martinez <ryan.chingal@gmail.com>
 */
@RestController
@RequestMapping("/api/students")
public class StudentRestController {
    private final StudentHandlerQuery studentServiceQuery;
    private final StudentHandlerCommand studentServiceCommand;

    public StudentRestController(StudentHandlerQuery studentServiceQuery, StudentHandlerCommand studentServiceCommand) {
        this.studentServiceQuery = studentServiceQuery;
        this.studentServiceCommand = studentServiceCommand;
    }

    /**
     * Retrieves all students.
     *
     * @return A ResponseEntity containing the list of all students.
     */
    @GetMapping
    public ResponseEntity<?> getAllStudents() {
        return ResponseEntity.ok(studentServiceQuery.getAllStudents());
    }

    /**
     * Creates a new student.
     *
     * @param student The student to be created.
     * @return A ResponseEntity containing the created student.
     */
    @PostMapping
    public ResponseEntity<?> createStudent(@RequestBody StudentDto student) {
        return ResponseEntity.ok(studentServiceCommand.createStudent(student));
    }

    /**
     * Retrieves a student by their code or identification.
     *
     * @param codeOrIdentification The code or identification of the student.
     * @return A ResponseEntity containing the student if found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentByCodeOrIdentification(@PathVariable(name = "id") String codeOrIdentification) {
        return ResponseEntity.ok(studentServiceQuery.getStudentByCodeOrIdentification(codeOrIdentification));
    }

    /**
     * Retrieves all grades for a student in a specific subject.
     *
     * @param studentId   The ID of the student.
     * @param subjectCode The code of the subject.
     * @return A ResponseEntity containing the grades of the student in the specified subject.
     */
    @GetMapping("/{id}/subjects/{code}/grades")
    public ResponseEntity<?> getAllStudentGradesBySubject(@PathVariable(name = "id") String studentId,
                                                          @PathVariable(name = "code") String subjectCode) {

        return ResponseEntity.ok(studentServiceQuery.getAllStudentGradesBySubject(studentId, subjectCode));
    }

    /**
     * Retrieves all grades for a student.
     *
     * @param studentId The ID of the student.
     * @return A list of {@link SubjectGradesDto} objects representing the grades of the student in all subjects.
     */
    @GetMapping("/{id}/subjects/grades")
    public ResponseEntity<?> getAllStudentGrades(@PathVariable(name = "id") String studentId) {
        return ResponseEntity.ok(studentServiceQuery.getAllStudentGrades(studentId));
    }

    /**
     * Retrieves the final grades of a student for all subjects.
     *
     * @param studentId The ID of the student.
     * @return A list of {@link SubjectFinalGradeDto} objects representing the final grades of the student in all subjects.
     */
    @GetMapping("/{id}/subjects/final-grades")
    public ResponseEntity<?> getAllStudentFinalGrade(@PathVariable(name = "id") String studentId) {
        return ResponseEntity.ok(studentServiceQuery.getAllStudentFinalGrade(studentId));
    }

    /**
     * Retrieves the final grade of a student for a specific subject.
     *
     * @param studentId The ID of the student.
     * @param subjectId The ID of the subject.
     * @return The final grade of the student in the specified subject.
     */
    @GetMapping("/{id}/subjects/{code}/final-grades")
    public ResponseEntity<?> getAllStudentFinalGradeBySubject(@PathVariable(name = "id") String studentId,
                                                              @PathVariable(name = "code") String subjectId) {
        return ResponseEntity.ok(studentServiceQuery.getAllStudentFinalGradeBySubject(studentId, subjectId));
    }
}

