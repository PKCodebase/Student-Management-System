package com.Student_Management.Students_Management_System.service.impl;

import java.util.List;

import com.Student_Management.Students_Management_System.entity.Student;
import com.Student_Management.Students_Management_System.repository.StudentRepository;
import com.Student_Management.Students_Management_System.service.StudentService;
import org.springframework.stereotype.Service;


@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student); // Save and return the saved entity
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null); // Return null if not found
    }

    @Override
    public void updateStudent(Student student) {
        // Check if student exists before saving
        if (studentRepository.existsById(student.getId())) {
            studentRepository.save(student);
        } else {
            throw new IllegalArgumentException("Student with id " + student.getId() + " does not exist.");
        }
    }

    @Override
    public void deleteStudentById(Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Student with id " + id + " does not exist.");
        }
    }

    @Override
    public boolean existsById(Long id) {
        return studentRepository.existsById(id); // Use the repository to check existence
    }
}
