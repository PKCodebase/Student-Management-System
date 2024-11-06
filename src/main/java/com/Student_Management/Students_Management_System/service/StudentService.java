package com.Student_Management.Students_Management_System.service;


import com.Student_Management.Students_Management_System.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student saveStudent(Student student);
    Student getStudentById(Long id);
    void updateStudent(Student student);
    void deleteStudentById(Long id);

    boolean existsById(Long id);
}
