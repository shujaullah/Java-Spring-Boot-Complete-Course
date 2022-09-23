package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // select * from student where email =?
    //Optional<Student> findStudentByEmail(String email);
    //@Query("SELECT s FROM Student s WHERE s.email=?1");
    Optional<Student> findStudentByEmail(String email);

}
