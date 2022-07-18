package com.dimas4ek.YoMaYo.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "please fill the message")
    @Length(max = 2048, message = "message too long")
    private String text;

    @ManyToOne(fetch=FetchType.EAGER) //один юзер - множество сообщений. EAGER - инфо о юзере
    @JoinColumn(name="user_id")
    private User author;

    private String authorName;

    private String filename;

    public Message() {
    }

    public Message(Long id, String text, User author) {
        this.author = author;
        this.id = id;
        this.text = text;
    }

    public String getAuthorName() {
        return author != null ? author.getUsername() : "<none>";
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}