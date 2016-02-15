package br.com.auctionapp.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.auctionapp.model.User;

public class MemoryUserDAO implements UserDAO {

    private final List<User> users = new ArrayList<User>();

    protected MemoryUserDAO() {    }

    @Override
    public User save(User user) {
        users.add(user);
        return user;
    }

    @Override
    public User find(String email) {
        for (User user : users) {
            if(user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

}
