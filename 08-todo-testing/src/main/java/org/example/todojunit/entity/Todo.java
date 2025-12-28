package org.example.todojunit.entity;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "todos")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String imageUrl;
}
