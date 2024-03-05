package com.spring_boot_api_one_to_one_mapping.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
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
@Table(name = "address")
public class Address implements Serializable {

    private static final Long serialVersionUID=1234567890L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Integer addressId;

    @Column(name = "street")
    @NotNull
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Only Alphabets Allowed")
    private String  street;

    @Column(name = "city")
    @NotNull
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Only Alphabets Allowed")
    private String city;

    @Column(name = "state")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Only Alphabets Allowed")
    @NotNull
    private String state;

    @Column(name = "pincode")
    @NotNull
    @Size(min = 6,max = 6,message = "Provide valid pin code, It must be of 6 digits")
    private String pinCode;

//    @JsonBackReference
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    @JsonIgnore
    @OneToOne(mappedBy = "address", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Student student;

}
