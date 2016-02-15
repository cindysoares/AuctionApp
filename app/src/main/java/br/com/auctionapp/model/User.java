package br.com.auctionapp.model;

import java.io.Serializable;

public class User implements Serializable {

    private String email;
    private String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return email;
    }
}
