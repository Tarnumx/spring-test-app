package com.tarnum.spring.Model;

import javax.persistence.*;

@Entity
@Table(name = "account")
@NamedQuery(name = User.SELECT_USER_COUNT_BY_LOGIN, query = "select count(id) from account where email=:login")
public class User {

    public static final String SELECT_USER_COUNT_BY_LOGIN = "select_user_count_by_login";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "email", columnDefinition = "varchar(50)", nullable = false, unique = true)
    private String email;

    @Column(name = "salt", columnDefinition = "varchar(30)", nullable = false)
    private String salt;

    @Column(name = "password", columnDefinition = "varchar(100)", nullable = false)
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
