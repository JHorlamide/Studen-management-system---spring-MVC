package com.studenmanagement.StudentManagementSystem.services;

import com.studenmanagement.StudentManagementSystem.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudent();

    Student saveStudent(Student student);
}
