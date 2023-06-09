package com.example.sprintbootjpah2.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_student",
    uniqueConstraints = @UniqueConstraint(
            name = "emailid_unique",
            columnNames = "email_address"
    )
)
public class Student extends RepresentationModel<Student> {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long studentId;
    private String firstName;
    private String lastName;
    @Column(
            name = "email_address",
            nullable = false
    )
    private String emailId;
    private String guardName;
    private String guardianMobile;
}
