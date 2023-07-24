package com.example.demo.repository.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
public class Post {
    @Id
    Integer id;
    String title;
    String body;
    Integer user_id;
}
