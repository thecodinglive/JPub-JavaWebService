package info.thecodinglive;

import info.thecodinglive.model.School;
import info.thecodinglive.model.Student;
import info.thecodinglive.repository.SchoolRepository;
import info.thecodinglive.repository.StudentRepository;
import info.thecodinglive.service.SchoolService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootApplication
public class ManyToOneRun {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(JPAMain.class, args);
        SchoolService schoolService = context.getBean(SchoolService.class);

        schoolService.findStudentInfo();


//        SchoolRepository schoolRepository = context.getBean(SchoolRepository.class);
//        StudentRepository studentRepository = context.getBean(StudentRepository.class);
//
//        School school = new School("매력고");
//        schoolRepository.save(school);
//
//        Student stu1 = new Student("나라");
//        Student stu2 = new Student("민하");
//        Student stu3 = new Student("나나");
//
//        stu1.setSchool(school);
//        stu2.setSchool(school);
//        stu3.setSchool(school);
//
//        studentRepository.save(stu1);
//        studentRepository.save(stu2);
//        studentRepository.save(stu3);
//
//        List<Student> students = studentRepository.findAll();
//
//        for(Student s:students){
//            System.out.println(s.getUserName() + "," + s.getSchool().getName());
//        }
    }
}
