package com.studenmanagement.StudentManagementSystem.controllers;

import com.studenmanagement.StudentManagementSystem.entity.Student;
import com.studenmanagement.StudentManagementSystem.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    /*
     * ROUTE: GET: /students
     * DESC: Handle student list and returns model and view
     * */
    @GetMapping("/students")
    public String studentList(Model model) {
        model.addAttribute("students", studentService.getAllStudent());
        return "students";
    }

    /*
     * ROUTE: GET: /students/new
     * DESC: Render view for creating new student
     * */
    @GetMapping("/students/new")
    public String createNewStudentForm(Model model) {
        //Create student obj to hold student form data
        Student student = new Student();
        model.addAttribute("student", student);
        return "create_student";
    }

    /*
     * ROUTE: POST: /students
     * DESC: Create new student
     * */
    @PostMapping("/students")
    public String createStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }


    /*
     * ROUTE: GET: /students/edit/id
     * DESC: Render view for update student details
     * */
    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit_student";
    }


    /*
     * ROUTE: POST: /students/id
     * DESC: Update and save updated student details
     * */
    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable("id") Long id,
                                @ModelAttribute("student") Student student, Model model) {

        //Get student from database by id
        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setId(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());

        //Save updated student objects
        studentService.updateStudent(existingStudent);
        return "redirect:/students";
    }

    /*
     * ROUTE: DELETE: /students/id
     * DESC: Delete student from student list
     * */
    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }
}
