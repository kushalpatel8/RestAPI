package com.APILearning.RestAPI.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Studentdto {
    private long id;
    private String name;
    private String email;

    public Studentdto(long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
