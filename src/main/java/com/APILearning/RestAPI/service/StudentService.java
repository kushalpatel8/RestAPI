package com.APILearning.RestAPI.service;

import com.APILearning.RestAPI.dto.AddStudentRequestdto;
import com.APILearning.RestAPI.dto.Studentdto;
import com.APILearning.RestAPI.entity.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {
    List<Studentdto> getAllStudents();

    Studentdto getStudentById();

    Studentdto createNewStudent(AddStudentRequestdto addStudentRequestdto);

    void deleteStudentById(Long id);

    Studentdto updateStudent(Long id, AddStudentRequestdto addStudentRequestdto);

    Studentdto updatePartialStudent(Long id, Map<String, Object> updates);
}
