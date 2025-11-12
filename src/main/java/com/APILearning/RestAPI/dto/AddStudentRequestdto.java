package com.APILearning.RestAPI.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class AddStudentRequestdto {
    @NotBlank
    @Size(min = 3, max = 50)
    private String name;

    @Email
    @NotBlank(message = "Email is required")
    private String email;
}
