package com.studenmanagement.StudentManagementSystem.repository;

import com.studenmanagement.StudentManagementSystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
