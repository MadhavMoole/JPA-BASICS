package com.madhav.SpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(App.class, args);

        StudentRepository repo = ctx.getBean(StudentRepository.class);

//        Student madhav = new Student();
//        madhav.setName("madhav");

//        List<Student> studentList = repo.findAllStudents();
//        studentList.forEach(s -> System.out.println(s));
        
        System.out.println(repo.findAll());
        System.out.println(repo.findById(1));
        repo.deleteById(3);
    }
}
