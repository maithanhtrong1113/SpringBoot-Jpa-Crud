package com.example.springBootCrud;

import com.example.springBootCrud.dao.StudentDAO;
import com.example.springBootCrud.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringBootCrudApplication {


    public static void main(String[] args) {
        SpringApplication.run(SpringBootCrudApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

        return runner -> {
//            createNewStudent(studentDAO);
            for(Student temp: studentDAO.findAll()){
                System.out.println(temp);
            }

        };
    }

    public void createNewStudent(StudentDAO studentDAO) {
        Student newStudent = new Student("Mai", "Thanh Trong", "maithanhtrong1113@gmail.com");
        studentDAO.saveStudent(newStudent);
    }

    public List<Student> showAll(StudentDAO studentDAO) {
        return studentDAO.findAll();
    }

}
