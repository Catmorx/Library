package com.usa.library.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "library")
public class LibraryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String target;
    private Integer capacity;
    private String description;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties("libs")
    private CategoryModel category;

    @OneToMany(mappedBy = "lib")
    @JsonIgnoreProperties({"lib", "client"})
    private List<MessageModel> messages;
    @OneToMany(mappedBy = "lib")
    @JsonIgnoreProperties({"libs", "client"})
    private List<ReservationModel> reservations;
}
