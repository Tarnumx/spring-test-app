package com.tarnum.spring.Dto;

import com.tarnum.spring.Validation.PasswordTheSame;
import com.tarnum.spring.Validation.ValidEmail;
import org.hibernate.validator.constraints.NotEmpty;

@PasswordTheSame
public class RegistrationUserDTO {
    @ValidEmail
    @NotEmpty(message = "Login cant be empty")
    private String login;
    @NotEmpty(message = "Password cant be empty")
    private String password;

    private String password1;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }
}
