package br.com.auctionapp.dao;

import br.com.auctionapp.model.User;

public interface UserDAO {

    public User save(User user);
    public User find(String email);

}
