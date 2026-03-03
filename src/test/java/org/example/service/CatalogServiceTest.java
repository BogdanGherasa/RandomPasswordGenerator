package org.example.service;

import org.example.model.Grade;
import org.example.model.Student;
import org.example.model.Subject;
import org.example.repository.GradeRepository;
import org.example.repository.StudentRepository;
import org.example.repository.SubjectRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CatalogServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @Mock
    private SubjectRepository subjectRepository;

    @Mock
    private GradeRepository gradeRepository;

    @InjectMocks
    private CatalogService catalogService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addGrade_Success() {
        // Arrange
        Long studentId = 1L;
        Long subjectId = 1L;
        int gradeValue = 10;
        
        Student student = new Student(studentId, "John", "Doe", "john@school.com", null);
        Subject subject = new Subject(subjectId, "Mathematics", null);
        
        when(studentRepository.findById(studentId)).thenReturn(Optional.of(student));
        when(subjectRepository.findById(subjectId)).thenReturn(Optional.of(subject));
        when(gradeRepository.save(any(Grade.class))).thenAnswer(i -> i.getArguments()[0]);

        // Act
        Grade result = catalogService.addGrade(studentId, subjectId, gradeValue);

        // Assert
        assertNotNull(result);
        assertEquals(gradeValue, result.getValue());
        assertEquals(student, result.getStudent());
        assertEquals(subject, result.getSubject());
        verify(gradeRepository, times(1)).save(any(Grade.class));
    }

    @Test
    void addGrade_InvalidValue_ThrowsException() {
        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            catalogService.addGrade(1L, 1L, 15);
        });

        assertEquals("The grade must be between 1 and 10.", exception.getMessage());
    }

    @Test
    void addGrade_StudentNotFound_ThrowsException() {
        // Arrange
        when(studentRepository.findById(1L)).thenReturn(Optional.empty());

        // Act & Assert
        Exception exception = assertThrows(RuntimeException.class, () -> {
            catalogService.addGrade(1L, 1L, 10);
        });

        assertEquals("Student not found.", exception.getMessage());
    }
}
