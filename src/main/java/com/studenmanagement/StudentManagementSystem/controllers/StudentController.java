package com.studenmanagement.StudentManagementSystem.controllers;

import com.studenmanagement.StudentManagementSystem.entity.Student;
import com.studenmanagement.StudentManagementSystem.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String createStudent(@ModelAttribute("student") Student student){
        studentService.saveStudent(student);
        return "redirect:/students";
    }
}
