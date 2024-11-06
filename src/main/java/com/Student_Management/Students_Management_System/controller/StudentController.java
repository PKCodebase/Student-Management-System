package com.Student_Management.Students_Management_System.controller;


import com.Student_Management.Students_Management_System.entity.Student;
import com.Student_Management.Students_Management_System.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Use RestController to indicate all responses are RESTful
@RequestMapping("/students") // Prefix to group all routes under /api/students
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<Student>> listStudents() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students); // Return the list of students as JSON
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        return ResponseEntity.ok(student); // Return the student as JSON
    }

    @PostMapping("/add")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        if (student.getFirstName() == null || student.getLastName() == null ||
                student.getEmail() == null || student.getPhone() == null) {
            return ResponseEntity.badRequest().body(null); // Return 400 if validation fails
        }

        Student savedStudent = studentService.saveStudent(student);
        return ResponseEntity.ok(savedStudent); // Return the saved student as JSON
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        Student existingStudent = studentService.getStudentById(id);

        // Update the fields of the existing student
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setPhone(student.getPhone());

        studentService.updateStudent(existingStudent);
        return ResponseEntity.ok(existingStudent); // Return the updated student as JSON
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        if (!studentService.existsById(id)) {
            return ResponseEntity.notFound().build(); // Return 404 if not found
        }

        studentService.deleteStudentById(id);
        return ResponseEntity.ok("Student deleted successfully."); // Return success message
    }
}
