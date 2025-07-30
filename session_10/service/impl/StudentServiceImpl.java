package com.data.session_10.service.impl;

import com.data.session_10.model.entity.Student;
import com.data.session_10.repository.IStudentRepository;
import com.data.session_10.service.IStudentService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private IStudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public boolean deleteById(Long id) {
        Student student = studentRepository.findById(id);
        if (student != null && Boolean.FALSE.equals(student.getIsStudying())) {
            studentRepository.delete(student);
            return true;
        }
        return false;
    }

    @PostConstruct
    public void init() {
        insertData();
    }

    @Override
    public void insertData() {
        studentRepository.save(new Student("Nguyễn Văn A", "a@gmail.com", 8.5f, true));
        studentRepository.save(new Student("Nguyễn Văn B", "b@gmail.com", 6.5f, true));
        studentRepository.save(new Student("Nguyễn Văn C", "c@gmail.com", 5.5f, false));
        studentRepository.save(new Student("Nguyễn Văn D", "d@gmail.com", 4.5f, true));
        studentRepository.save(new Student("Nguyễn Văn E", "e@gmail.com", 7.5f, false));
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }
}
