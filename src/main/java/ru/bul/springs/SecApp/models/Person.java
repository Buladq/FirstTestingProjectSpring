package ru.bul.springs.SecApp.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty
    @Size(min = 2, max = 60, message = "Значение имени должно быть от 2 до 60 симсволов")
    @Column(name = "username")
    private String username;


    @Column(name = "password")
    @NotEmpty(message = "Пароль не должен быть пустым")
    private String password;


    @Column(name = "role")
    private String role;

    public Person() {
    }

    public Person( String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Person(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(username, person.username) && Objects.equals(password, person.password) && Objects.equals(role, person.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, role);
    }
}