package com.spring_boot_api_one_to_one_mapping.Service.StudentServiceImpl;

import com.spring_boot_api_one_to_one_mapping.Entity.Address;
import com.spring_boot_api_one_to_one_mapping.Entity.Student;
import com.spring_boot_api_one_to_one_mapping.Exception.DataNotPresentException;
import com.spring_boot_api_one_to_one_mapping.Repository.StudentRepository;
import com.spring_boot_api_one_to_one_mapping.Service.StudentService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;


    @Transactional
    @SneakyThrows
    @Override
    public String saveStudent(Student student) {
       Optional<Student> op= studentRepository.findByStudentPhoneNo(student.getStudentPhoneNo());

       if(op.isEmpty())
       {
           studentRepository.save(student);
           return "Data saved Successfully";
       }
       else {
           throw new DataNotPresentException("This PhoneNumber="+student.getStudentPhoneNo()+" is already registered");
       }
    }

    @Transactional
    @SneakyThrows
    @Override
    public List<Student> getAllStudent() {
      List<Student> list= studentRepository.findAll();

      if(list.isEmpty())
      {
          throw new DataNotPresentException("Database is Empty");
      }
      else {
          return list;
      }

    }

    @Transactional
    @SneakyThrows
    @Override
    public Student getStudentById(Integer studentId) {

        Optional<Student> op=studentRepository.findById(studentId);
        if(op.isEmpty())
        {
            throw new DataNotPresentException("The studentId="+studentId+" is not available in database");
        }
        else
        {
            return op.get();
        }

    }

    @Transactional
    @SneakyThrows
    @Override
    public List<Student> getStudentByFirstName(String studentFirstName) {

       List<Student> li= studentRepository.getStudentByFirstName(studentFirstName);
       if(li.isEmpty())
       {
          throw new DataNotPresentException("Data is not available regarding StudentFirstName="+studentFirstName);
       }
       else {
           return li;
       }

    }

    @Transactional
    @SneakyThrows
    @Override
    public Student getStudentByPhoneNo(String studentPhoneNumber) {
          Optional<Student> op= studentRepository.findByStudentPhoneNo(studentPhoneNumber);

          if(op.isEmpty())
          {
              throw new DataNotPresentException("There is no details of Student related to studentPhoneNumber="+studentPhoneNumber);
          }
          else
          {
              return op.get();
          }
    }

    @Transactional
    @SneakyThrows
    @Override
    public String updateStudentById(Integer studentId, Student updatedStudent) {
        Optional<Student> op=studentRepository.findById(studentId);
        if(op.isEmpty())
        {
            throw new DataNotPresentException("There is no data related to studentId="+studentId);
        }
        else {
             Student student1 = op.get();
            student1.setStudentFirstName(updatedStudent.getStudentFirstName());
            student1.setStudentLastName(updatedStudent.getStudentLastName());
            student1.setStudentEmail(updatedStudent.getStudentEmail());
            student1.setStudentPhoneNo(updatedStudent.getStudentPhoneNo());

            Address address = student1.getAddress();
            address.setStreet(updatedStudent.getAddress().getStreet());
            address.setCity(updatedStudent.getAddress().getCity());
            address.setState(updatedStudent.getAddress().getState());
            address.setPinCode(updatedStudent.getAddress().getPinCode());

            studentRepository.save(student1);

            return "Data updated Successfully";
        }

    }

    @Transactional
    @SneakyThrows
    @Override
    public String deleteStudentById(Integer studentId) {
      Optional<Student> op= studentRepository.findById(studentId);
      if(op.isEmpty())
      {
          throw new DataNotPresentException("There is no data present related to studentId="+studentId);
      }
      else
      {
          studentRepository.deleteById(studentId);
          return "Data deleted successfully";
      }

    }

    @Transactional
    @SneakyThrows
    @Override
    public Student getStudentByPinCode(String studentPinCode) {

          Optional<Student> op= studentRepository.getStudentByPinCode(studentPinCode);

          if(op.isEmpty())
          {
              throw new DataNotPresentException("Data related to studentPinCode="+studentPinCode+" is not available");
          }
          else
          {
              return op.get();
          }

    }

    @Transactional
    @SneakyThrows
    @Override
    public Student getStudentByStreet(String studentStreet) {
      Optional<Student> op= studentRepository.getStudentByStreet(studentStreet);
      if(op.isEmpty())
      {
          throw new DataNotPresentException("Data related to street="+studentStreet+" is not available in database");
      }
      else
      {
          return op.get();
      }

    }
}
