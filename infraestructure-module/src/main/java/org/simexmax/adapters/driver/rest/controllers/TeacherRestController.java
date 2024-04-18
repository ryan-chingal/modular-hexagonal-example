package org.simexmax.adapters.driver.rest.controllers;

import org.simexmax.adapters.driver.rest.bodies.GradeRequestBody;
import org.simexmax.dto.person.StudentDto;
import org.simexmax.dto.person.TeacherDto;
import org.simexmax.handlers.commands.TeacherHandlerCommand;
import org.simexmax.handlers.queries.TeacherHandlerQuery;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class for handling teacher-related HTTP requests.
 *
 * @author Hardy Ryan Chingal Martinez <ryan.chingal@gmail.com>
 */
@RestController
@RequestMapping("/api/teachers")
public class TeacherRestController {
    private final TeacherHandlerQuery teacherHandlerQuery;
    private final TeacherHandlerCommand teacherHandlerCommand;

    public TeacherRestController(TeacherHandlerQuery teacherHandlerQuery, TeacherHandlerCommand teacherHandlerCommand) {
        this.teacherHandlerQuery = teacherHandlerQuery;
        this.teacherHandlerCommand = teacherHandlerCommand;
    }

    /**
     * Request to retrieve all teachers.
     *
     * @return A ResponseEntity with the HTTP status and a message indicating the operation is not implemented.
     */
    @GetMapping
    public ResponseEntity<?> getAllTeachers() {
        return ResponseEntity.ok(teacherHandlerQuery.getAllTeachers());

    }

    /**
     * Request to create a new teacher.
     *
     * @param teacher The request body containing the information of the teacher to be created.
     * @return A ResponseEntity with the HTTP status and a message indicating the operation is not implemented.
     */
    @PostMapping
    public ResponseEntity<?> createTeacher(@RequestBody TeacherDto teacher) {
        return ResponseEntity.ok(teacherHandlerCommand.createTeacher(teacher));
    }

    /**
     * Request to retrieve a teacher by ID.
     *
     * @param codeOrIdentification The ID or code of the teacher.
     * @return A ResponseEntity with the HTTP status and a message indicating the operation is not implemented.
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getTeacher(@PathVariable(name = "id") String codeOrIdentification) {
        return ResponseEntity.ok(teacherHandlerQuery.getTeacherByCodeOrIdentification(codeOrIdentification));
    }

    /**
     * Request to update a student's grade in a subject for a specific period.
     *
     * @param studentCode The code of the student.
     * @param subjectCode The code of the subject.
     * @param period      The period for which the grade is being updated.
     * @param grade       The request body containing the new grade value.
     * @return A ResponseEntity with the HTTP status and a message indicating the grade has been updated.
     */
    @PatchMapping("/students/{studentId}/subjects/{subjectCode}/grades/period/{period}")
    public ResponseEntity<?> updateStudentGradeInSubjectByPeriod(@PathVariable(name = "studentId") String studentCode,
                                                                 @PathVariable(name = "subjectCode") String subjectCode,
                                                                 @PathVariable(name = "period") int period,
                                                                 @RequestBody GradeRequestBody grade) {
        teacherHandlerCommand.changeStudentGradeInSubjectByPeriod(studentCode, subjectCode, period, grade.getGrade());
        return ResponseEntity.ok(String.format("Calificación actualizada del estudiante con código %s en la materia con" +
                " código %s en el periodo %s", studentCode, subjectCode, period));
    }

    /**
     * Register a new grade for a student in a subject for a specific period.
     *
     * @param studentCode The code of the student.
     * @param subjectCode The code of the subject.
     * @param period      The period for which the grade is being registered.
     * @param grade       The request body containing the grade value to be registered.
     * @return A ResponseEntity with the HTTP status and a message indicating the grade has been registered.
     */
    @PostMapping("/students/{studentId}/subjects/{subjectCode}/grades/period/{period}")
    public ResponseEntity<?> registerStudentGradeInSubjectByPeriod(@PathVariable(name = "studentId") String studentCode,
                                                                   @PathVariable(name = "subjectCode") String subjectCode,
                                                                   @PathVariable(name = "period") int period,
                                                                   @RequestBody GradeRequestBody grade) {
        teacherHandlerCommand.registerStudentGradeInSubjectByPeriod(studentCode, subjectCode, period, grade.getGrade());
        return ResponseEntity.ok(String.format("Calificación creada para el estudiante con código %s en la materia con" +
                " código %s en el periodo %s", studentCode, subjectCode, period));
    }

    /**
     * Request to retrieve final grades of students for a subject.
     *
     * @param subjectCode The code of the subject.
     * @return A ResponseEntity with the HTTP status and the final grades of students for the specified subject.
     */
    @GetMapping("/subjects/{subjectCode}/final-grades")
    public ResponseEntity<?> getStudentsFinalGradesBySubject(@PathVariable(name = "subjectCode") String subjectCode) {
        return ResponseEntity.ok(teacherHandlerQuery.getStudentsFinalGradesBySubject(subjectCode));
    }
}
