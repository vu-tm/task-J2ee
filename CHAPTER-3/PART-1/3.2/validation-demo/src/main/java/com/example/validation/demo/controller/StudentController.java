/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.validation.demo.controller;
import com.example.validation.demo.dto.StudentDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/**
 *
 * @author Hi
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    @PostMapping
    public ResponseEntity<StudentDto> create(
    @Valid @RequestBody StudentDto studentDto){
        return ResponseEntity.ok(studentDto);
    }
}
