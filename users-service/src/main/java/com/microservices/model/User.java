package com.microservices.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@Entity
@Table(name = "users")
public class User {


    @Id
    @Column(name = "ID")
    private String userId;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "ABOUT")
    private String about;

//    @Transient                               //this will not save rating in the database , it will ignore
//    private List<Rating> ratings = new ArrayList<>();


}


