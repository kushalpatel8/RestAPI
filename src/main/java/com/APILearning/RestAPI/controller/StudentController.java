package com.APILearning.RestAPI.controller;

import com.APILearning.RestAPI.dto.AddStudentRequestdto;
import com.APILearning.RestAPI.dto.Studentdto;
import com.APILearning.RestAPI.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Studentdto>> getStudent() {
//        return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudents());
        return ResponseEntity.ok(studentService.getAllStudents());

    }
    @GetMapping("/{id}")
    public ResponseEntity<Studentdto> getStudentById(@PathVariable Long id) {
        return  ResponseEntity.ok(studentService.getStudentById());
    }

    @PostMapping
    public ResponseEntity<Studentdto> createNewStudent(@RequestBody @Valid AddStudentRequestdto addStudentRequestdto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createNewStudent(addStudentRequestdto));

    }

    @DeleteMapping("{/id}")
    public ResponseEntity<Void> deleteAStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{/id}")
    public ResponseEntity<Studentdto> updateStudent(@PathVariable Long id, @RequestBody AddStudentRequestdto addStudentRequestdto) {
        return ResponseEntity.ok(studentService.updateStudent(id, addStudentRequestdto));
    }

    @PatchMapping("{/id}")
    public ResponseEntity<Studentdto> updatePartialStudent(@PathVariable Long id, @RequestBody Map<String,Object> updates) {
        return ResponseEntity.ok(studentService.updatePartialStudent(id, updates));
    }
}
