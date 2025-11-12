package com.APILearning.RestAPI.service.impl;

import com.APILearning.RestAPI.dto.AddStudentRequestdto;
import com.APILearning.RestAPI.dto.Studentdto;
import com.APILearning.RestAPI.entity.Student;
import com.APILearning.RestAPI.repository.StudentRepository;
import com.APILearning.RestAPI.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public  class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<Studentdto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
         return students
                 .stream()
                 .map(student -> modelMapper.map(student, Studentdto.class))
                 .toList();

    }

    @Override
    public Studentdto getStudentById() {
        return null;
    }

    public Studentdto getStudentById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found"));
        return modelMapper.map(student, Studentdto.class);
    }

    @Override
    public Studentdto createNewStudent(AddStudentRequestdto addStudentRequestdto) {
        Student newStudent = modelMapper.map(addStudentRequestdto, Student.class);
        Student student = studentRepository.save(newStudent);
        return modelMapper.map(student,Studentdto.class);
    }

    @Override
    public void deleteStudentById(Long id) {
        if(!studentRepository.existsById(id)) {
            throw new IllegalArgumentException("Student not found");
        }
        studentRepository.deleteById(id);
    }

    @Override
    public Studentdto updateStudent(Long id, AddStudentRequestdto addStudentRequestdto) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found"));
        modelMapper.map(addStudentRequestdto, student);
        student = studentRepository.save(student);
        return  modelMapper.map(student,Studentdto.class);
    }

    @Override
    public Studentdto updatePartialStudent(Long id, Map<String, Object> updates) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found"));
        updates.forEach((field, value)->{
            switch (field) {
                case "name" : student.setName((String) value);
                                break;
                case "email" : student.setEmail((String) value);
                                break;
                default:
                    throw new IllegalArgumentException("Feild is not Supported");
            }
        }) ;
        Student savedStudent = studentRepository.save(student);
        return  modelMapper.map(savedStudent,Studentdto.class);

    }
}
