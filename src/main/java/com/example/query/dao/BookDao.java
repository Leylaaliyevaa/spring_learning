package com.example.query.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDao {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long bookId;
        private String title;
        private String author;
        private int price;
        private int publicationYear;

        @ManyToOne
        private AuthorDao authorDao;

        @ManyToMany
        @JoinTable(
                name = "book_category",
                joinColumns = @JoinColumn(name = "book_id"),
                inverseJoinColumns = @JoinColumn(name = "category_id")
        )
        private List<CategoryDao> categories;
    }

