package com.challenge.blogApi.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "displayName")
    @NotNull(message = "\"displayName\" is required")
    @NotBlank(message = "\"displayName\" is required")
    @Size(min = 8, message = "\"displayName\" length must be at least 8 characters long")
    private String displayName;

    @Column(name = "email", unique = true)
    @NotNull(message = "\"email\" is required")
    @NotBlank(message = "\"email\" is required")
    @Email(message = "\"email\" must be a valid email")
    private String email;

    @Column(name = "password")
    @NotNull(message = "\"password\" is required")
    @NotBlank(message = "\"password\" is required")
    @Size(min = 6, max = 6, message = "\"password\" length must be at least 6 characters long")
    private String password;

    @Column(name = "image")
    private String image;

    public User() {
    }

    public User(String displayName, String email, String password, String image) {
        this.displayName = displayName;
        this.email = email;
        this.password = password;
        this.image = image;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getImage() {
        return image;
    }

    @Override
    public boolean equals(Object object) {
        if(object == this)
            return true;

        if(!(object instanceof User))
            return false;

        User user = (User) object;

        return email.equals(user.email);
    }
}
