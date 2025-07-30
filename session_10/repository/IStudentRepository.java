package com.data.session_10.repository;

import com.data.session_10.model.entity.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
    void delete(Student student);
    Student findById(Long id);
    void save(Student student);
}
