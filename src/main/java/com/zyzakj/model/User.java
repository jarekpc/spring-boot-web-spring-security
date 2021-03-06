package com.zyzakj.model;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by zyzakj on 2017-06-26.
 */
@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;
    @Column(name = "email")
    @Email(message = "*Please provide a valid Email")
    @NotEmpty(message = "*Please provide an email")
    private String email;
    @Column(name = "password")
    @Length(min = 5, message = "*Your password must have at least 5 characters")
    @NotEmpty(message = "*Please provide your password")
    //@Transient
    private String password;
    @Column(name = "username")
    @NotEmpty(message = "*Please provide your name")
    private String username;
    @Column(name = "last_name")
    @NotEmpty(message = "*Please provide your last name")
    private String lastName;

    @Column(name = "first_name")
    @NotEmpty(message = "*Please provide your first name")
    private String firstName;

    @Column(name = "active")
    private int active;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLE", joinColumns =  @JoinColumn(name = "user_id",referencedColumnName = "user_id"), inverseJoinColumns =  @JoinColumn(name = "role_id",referencedColumnName = "role_id"))
    private Set<Role> roles;

}
