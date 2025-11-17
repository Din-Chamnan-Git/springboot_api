package com.learn.pro1.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "category")
public class Category {

    @Id // set id as primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment id
    private Long id;

    @Column(nullable = false ,unique = true)
    private String name;

    @Column(columnDefinition = "TEXT") // mean allow long text more than 255 char
    private String description;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_category_id")
    private Category parentCategory;


    // one to many relationship with category table : one category can have many sub categories
    @OneToMany(mappedBy = "parentCategory" , cascade = CascadeType.ALL)
    private List<Category> subCategories = new ArrayList<>();


    @Column(name = "is_active") // set column name in database
    private boolean isActive = true;


    @CreationTimestamp
    @Column(name = "created_at" , updatable = false)
    private LocalDateTime createdAt;


    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;




}
