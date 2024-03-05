package com.spring_boot_api_one_to_one_mapping.Service;


import com.spring_boot_api_one_to_one_mapping.Entity.Address;
import com.spring_boot_api_one_to_one_mapping.Entity.Student;

import java.util.List;

public interface StudentService {

    public String saveStudent(Student student);

    public List<Student> getAllStudent();

    public Student getStudentById(Integer studentId);

    public List<Student> getStudentByFirstName(String studentFirstName);

    public Student getStudentByPhoneNo(String studentPhoneNumber);

    public String updateStudentById(Integer studentId, Student student);

    public String deleteStudentById(Integer studentId);

    public Student getStudentByPinCode(String studentPinCode);

    public Student getStudentByStreet(String studentStreet);


}
