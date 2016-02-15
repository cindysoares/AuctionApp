package br.com.auctionapp.dao;

import java.util.List;

import br.com.auctionapp.model.Auction;

/**
 * Created by Cindy on 01/02/2016.
 */
public interface AuctionDAO {

    public List<Auction> findAllActive();
    public Auction save(Auction auction);

}
