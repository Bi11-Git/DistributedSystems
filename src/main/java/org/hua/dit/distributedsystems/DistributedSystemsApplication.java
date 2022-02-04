package org.hua.dit.distributedsystems;
import org.hua.dit.distributedsystems.models.*;
import org.hua.dit.distributedsystems.repositories.*;
import org.hua.dit.distributedsystems.service.QuestionService;
import org.hua.dit.distributedsystems.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class DistributedSystemsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DistributedSystemsApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner commandLineRunner(UserService userService, QuestionService questionService) {
        return args -> {

            Role student = new Role(null, "student");
            userService.saveRole(student);

            Role teacher = new Role(null, "teacher");
            userService.saveRole(teacher);



            User bill = new User(null, "bill@gmail.com", 1234, "1234", "Bill"
                    , new ArrayList<>(), null, null);
            userService.saveUser(bill);

            User artemis = new User(null, "artemis@gmail.com", 1234, "5678"
                    , "Artemis", new ArrayList<>(), null, null);
            userService.saveUser(artemis);

            User meletis = new User(null, "meletis@gmail.com", 1234, "9012"
                    , "Meletis", new ArrayList<>(), null, null);
            userService.saveUser(meletis);



            userService.addRoleToUser("bill@gmail.com", "student");
            userService.addRoleToUser("artemis@gmail.com", "teacher");
            userService.addRoleToUser("meletis@gmail.com", "teacher");

            userService.addTeacherToStudent("meletis@gmail.com", "bill@gmail.com");

            //subjects create
            Subject subject = new Subject(null, "Εξισώσεις",  null);

            //subjects add
            questionService.saveSubject(subject);

            //add ston kathigiti meleti
            userService.addSubjectToTeacher(subject, meletis.getEmail());

            questionService.saveQuestion(null, "1*2+x=5", "b", "c", "d"
                    , "1*2+x=5", "artemis@gmail.com", subject.getName());

            List<User> artemisStudents = userService.getStudents("artemis@gmail.com");

            Map<Long, Integer> results = new HashMap<>();

     /*       results.put(questionService.)*/

     /*       questionService.saveQuizResults();*/

            //todo


           // System.out.println(artemisStudents.get(0).getEmail());

        };
    }
}
