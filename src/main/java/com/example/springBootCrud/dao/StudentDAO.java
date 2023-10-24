package com.example.springBootCrud.dao;

import com.example.springBootCrud.entity.Student;

import java.util.List;

public interface StudentDAO {
    void saveStudent(Student student);
    List<Student> findAll();
    Student findById(Integer id);

    List<Student> findByLastName(String lastName);
    void update(Student student);
    void delete(Integer id);
}
