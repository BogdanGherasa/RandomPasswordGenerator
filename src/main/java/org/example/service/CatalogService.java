package org.example.service;

import org.example.model.Grade;
import org.example.model.Student;
import org.example.model.Subject;
import org.example.repository.GradeRepository;
import org.example.repository.StudentRepository;
import org.example.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing catalog-related operations.
 */
@Service
public class CatalogService {

    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;
    private final GradeRepository gradeRepository;

    /**
     * Constructor-based dependency injection.
     */
    public CatalogService(StudentRepository studentRepository, 
                          SubjectRepository subjectRepository, 
                          GradeRepository gradeRepository) {
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
        this.gradeRepository = gradeRepository;
    }

    /**
     * Registers a new student in the system.
     *
     * @param student The student to add.
     * @return The saved student entity.
     */
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    /**
     * Retrieves all registered students.
     *
     * @return A list of all students.
     */
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    /**
     * Adds a new subject to the system.
     *
     * @param name The name of the subject.
     * @return The saved subject entity.
     */
    public Subject addSubject(String name) {
        Subject subject = new Subject();
        subject.setName(name);
        return subjectRepository.save(subject);
    }

    /**
     * Assigns a grade to a student for a specific subject.
     *
     * @param studentId The unique identifier of the student.
     * @param subjectId The unique identifier of the subject.
     * @param value     The grade value (must be between 1 and 10).
     * @return The saved grade entity.
     */
    public Grade addGrade(Long studentId, Long subjectId, int value) {
        if (value < 1 || value > 10) {
            throw new IllegalArgumentException("The grade must be between 1 and 10.");
        }

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found."));

        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new RuntimeException("Subject not found."));

        Grade grade = new Grade();
        grade.setStudent(student);
        grade.setSubject(subject);
        grade.setValue(value);

        return gradeRepository.save(grade);
    }

    /**
     * Retrieves all grades received by a specific student.
     *
     * @param studentId The ID of the student.
     * @return A list of grades for the student.
     */
    public List<Grade> getStudentGrades(Long studentId) {
        return gradeRepository.findByStudentId(studentId);
    }
}
