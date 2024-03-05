package com.spring_boot_api_one_to_one_mapping.Repository;

import com.spring_boot_api_one_to_one_mapping.Entity.Address;
import com.spring_boot_api_one_to_one_mapping.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    public Optional<Student> findByStudentPhoneNo(String studentPhoneNo);

    @Query(value = "select * from student where student_first_name=:studentFirstName", nativeQuery = true)
    public List<Student> getStudentByFirstName(@Param("studentFirstName") String studentFirstName);

    @Query(value = "SELECT s.* FROM student s JOIN address a ON s.address_id1 = a.address_id WHERE a.pincode = :pinCode", nativeQuery = true)
    public Optional<Student> getStudentByPinCode(@Param("pinCode") String pinCode);


    @Query(value = "SELECT s.*, a.* FROM student s JOIN address a ON s.address_id1 = a.address_id WHERE a.street = :street", nativeQuery = true)
    public Optional<Student> getStudentByStreet(@Param("street") String street);



}
