package com.spring_boot_api_one_to_one_mapping.Controller;

import com.spring_boot_api_one_to_one_mapping.Entity.Student;
import com.spring_boot_api_one_to_one_mapping.Service.StudentServiceImpl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

    @PostMapping("/save")
    public ResponseEntity<String> saveStudent(@RequestBody Student student)
    {
       String str=  studentService.saveStudent(student);
       return ResponseEntity.status(HttpStatus.OK).body(str);
    }

    @GetMapping("/get")
    public  ResponseEntity<List<Student>> getAllStudent()
    {
        List<Student> list=studentService.getAllStudent();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/getbyid/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable("studentId")  Integer studentId)
    {
        Student student=studentService.getStudentById(studentId);
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }

    @GetMapping("/getbyname")
    public ResponseEntity<List<Student>> getStudentByFirstName(@RequestParam("studentFirstName") String studentFirstName)
    {
        List<Student> list=studentService.getStudentByFirstName(studentFirstName);
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/getbyphone")// Http request have headers i.e RequestHeader and ResponseHeader which contains meta data of request like host,autherization,etc
    public ResponseEntity<Student> getStudentByPhoneNo(@RequestHeader("studentPhoneNumber") String studentPhoneNumber)
    {
        Student student =  studentService.getStudentByPhoneNo(studentPhoneNumber);
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }

    @PutMapping("/update/{studentId}")
    public ResponseEntity<String> updateStudentById(@PathVariable("studentId") Integer studentId,@RequestBody Student student)
    {
        String str=studentService.updateStudentById(studentId, student);
        return ResponseEntity.status(HttpStatus.OK).body(str);
    }

    @DeleteMapping("/delete/{studentId}")
    public ResponseEntity<String> deleteStudentById(@PathVariable("studentId") Integer studentId)
    {
        String str=studentService.deleteStudentById(studentId);
        return ResponseEntity.status(HttpStatus.OK).body(str);
    }

    @GetMapping("/address/{pinCode}")
    public ResponseEntity<Student> getStudentByPinCode(@PathVariable("pinCode") String studentPinCode)
    {
        Student student= studentService.getStudentByPinCode(studentPinCode);
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }

    @GetMapping("/getaddress")
    public ResponseEntity<Student> getStudentByStreet(@RequestParam("studentStreet") String studentStreet)
    {
      Student student=studentService.getStudentByStreet(studentStreet);
      return ResponseEntity.status(HttpStatus.OK).body(student);
    }



}
