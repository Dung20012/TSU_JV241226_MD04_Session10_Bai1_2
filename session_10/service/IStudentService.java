package com.data.session_10.service;

import com.data.session_10.model.entity.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    boolean deleteById(Long id);
    void  insertData();
    Student findById(Long id);
    void save(Student student);
}
