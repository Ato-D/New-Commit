package com.example.Centrifugo.student;

import com.example.Centrifugo.dto.ResponseDTO;
import com.example.Centrifugo.dto.StudentDto;
import org.springframework.http.ResponseEntity;

import java.util.Map;
import java.util.UUID;

public interface StudentService {

    ResponseEntity<ResponseDTO> findAllStudents(Map<String, String> params);

    ResponseEntity<ResponseDTO> findById(UUID id);

    ResponseEntity<ResponseDTO> saveStudent(StudentDto studentDto);

    ResponseEntity<ResponseDTO> updateStudent(UUID id, StudentDto studentDto);

    ResponseEntity<ResponseDTO> deleteStudent(UUID id);
}
