package com.pedrohenrique.todosimple.models;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table (name = Task.TABLE_NAME)
public class Task {
    public static final String TABLE_NAME = "Task";

   
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name ="id", unique = true)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    private User user;

    @Column(name = "description", length = 255, nullable = false)
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 255)
    private String description;


    public Task() {
    }

    public Task(long id, User user, String description) {
        this.id = id;
        this.user = user;
        this.description = description;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Task id(long id) {
        setId(id);
        return this;
    }

    public Task user(User user) {
        setUser(user);
        return this;
    }

    public Task description(String description) {
        setDescription(description);
        return this;
    }

    @Override
    public boolean equals(Object o) {
      return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, description);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", user='" + getUser() + "'" +
            ", description='" + getDescription() + "'" +
            "}";
    }
    




}
