package com.example.query.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Dto {
    private String title;
    private String author;
    private int publicationYear;
    private int price;
    private int authorId;

}
