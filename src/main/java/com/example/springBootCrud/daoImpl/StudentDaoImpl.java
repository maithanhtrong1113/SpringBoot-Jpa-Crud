package com.example.springBootCrud.daoImpl;

import com.example.springBootCrud.dao.StudentDAO;
import com.example.springBootCrud.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDAO {
    private EntityManager entityManager;

    @Autowired
    public StudentDaoImpl(EntityManager theEntitymanager) {
        entityManager = theEntitymanager;
    }

    @Override
    @Transactional
    public void saveStudent(Student student) {
        entityManager.persist(student);
    }

    @Override
    @Transactional
    public List<Student> findAll() {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student", Student.class);
        List<Student> resultList = query.getResultList();
        return resultList;
    }

    @Override
    @Transactional
    public Student findById(Integer id) {
        Student myStudent = entityManager.find(Student.class, id);
        return myStudent;
    }

    @Override
    @Transactional
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> typedQuery = entityManager.createQuery("FROM Student WHERE lastName=:theData", Student.class);
        typedQuery.setParameter("theData", lastName);
        return typedQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student theStudent = entityManager.find(Student.class,id);
        entityManager.remove(theStudent);
    }

}
