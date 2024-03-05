package com.spring_boot_api_one_to_one_mapping.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student")
public class Student implements Serializable {


    /*
      if we provide only @one to one mapping in student only at addreess then it is unidirectional mapping i.e by using student
      details we can find the address details but if we have address details we cant find student details

      So to perform bidirectional we have to create Student variable in Address also and write @oneToOne mapping but it creates
      foregin key of student in address table and foreign key of address in student but if we want only one foreign key but bidirectional we will perform
      mappedBy i.e in Student class if we perform mapped by then it creates student foreign key in address table and

      there rae number of cascading type i.e

      CascedingType.All (Provide all features like if we save student on that time address also save if we fetch student address also fetch)
      CascadingType.Remove
      CascadingType.Persist

      fetch by default type is Lazy i.e if we want to fetch student only address can fetch but in eager want to fetch both at same time then Eager

     */
    private static final Long serialVersionUID= 1234567890L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer studentId;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z]+$" , message = "Only alphabets allowed")
    @Column(name = "student_first_name")
    private String studentFirstName;

    @Column(name = "student_last_name")
    @NotNull
    @Pattern(regexp = "^[a-zA-Z]+$" , message = "Only alphabets allowed")
    private String studentLastName;

    @Column(name = "student_email")
    @NotNull
    @Email(regexp = ".*@gmail\\.com$", message = "Invalid email address mail must be end with @gmail.com")
    private String studentEmail;

    @NotNull
    @Column(name = "student_phone_no")
    @Size(min=10 , max = 10, message = "Phone Number must of 10 Digits")
    private String studentPhoneNo;


//    @JsonBackReference
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id1")
    private Address address;





}
