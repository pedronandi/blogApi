package com.challenge.blogApi.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Post {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @ManyToOne
    private User user;

    @Column(name = "published")
    private Date published;

    @Column(name = "updated")
    private Date updated;

    public Post() {
    }

    public Post(String title, String content, User user, Date published, Date updated) {
        this.title = title;
        this.content = content;
        this.user = user;
        this.published = published;
        this.updated = updated;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setPublished(Date published) {
        this.published = published;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public User getUser() {
        return user;
    }

    public Date getPublished() {
        return published;
    }

    public Date getUpdated() {
        return updated;
    }
}