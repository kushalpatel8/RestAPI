package com.APILearning.RestAPI.repository;

import com.APILearning.RestAPI.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

    void deleteById(Long id);
}
