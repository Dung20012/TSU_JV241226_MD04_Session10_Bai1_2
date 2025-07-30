package com.data.session_10.repository.impl;

import com.data.session_10.model.entity.Student;
import com.data.session_10.repository.IStudentRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class StudentRepositoryImpl implements IStudentRepository {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Student> findAll() {
        return getSession().createQuery("from Student", Student.class).getResultList();
    }

    @Override
    public Student findById(Long id) {
        return getSession().get(Student.class, id);
    }

    @Override
    public void save(Student student) {
        getSession().saveOrUpdate(student);
    }

    @Override
    public void delete(Student student) {
        getSession().delete(student);
    }
}
