package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository  studentRepository)
    {
        this.studentRepository = studentRepository;
    }
    public List<Student> getStudents()
    {
        //return List.of(new Student(1L,"marium", "marium.jamal@gamil.com", LocalDate.of(2000, Month.JANUARY, 5 ), 21));
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
            //System.out.println(student);
        Optional<Student> studentOptional=  studentRepository.findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent())
            throw  new IllegalStateException("Email Taken");
        studentRepository.save(student);


    }

    public void deleteStudent(Long id) {
        boolean b = studentRepository.existsById(id);
        if(!b)
            throw new IllegalStateException("Student with "+ id+ "doesnot exist");
        studentRepository.deleteById(id);



    }

    @Transactional
    public void updateStudent(Long id, String name, String email) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Student with " +id+ " does not exist"));
        if(name!=null && name.length()>0 && !Objects.equals(student.getName(), name))
        {
            student.setName(name);
        }

        if(email != null&& email.length() >0 && !Objects.equals(student.getEmail(), email))
        {
            Optional<Student> studentOptional=  studentRepository.findStudentByEmail(email);
            if(studentOptional.isPresent())
                throw  new IllegalStateException("Email Taken");
            student.setEmail(email);
        }



    }
}
