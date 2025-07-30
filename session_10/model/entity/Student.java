package com.data.session_10.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    @NotBlank(message = "Tên không được để trống !")
    private String studentName;

    @NotBlank(message = "Email không được để trống !")
    @Email(message = "Email không hợp lệ !")
    private String email;

    @NotNull(message = "Điểm không được để trống !")
    @Min(value = 1, message = "Điểm phải lớn hơn 0 !")
    private Float ageMark;

    private Boolean isStudying;

    public Student(String studentName, String email, Float ageMark, Boolean isStudying) {
        this.studentName = studentName;
        this.email = email;
        this.ageMark = ageMark;
        this.isStudying = isStudying;
    }
}
