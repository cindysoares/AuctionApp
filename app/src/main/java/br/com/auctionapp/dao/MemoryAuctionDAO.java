package br.com.auctionapp.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.auctionapp.model.Auction;

public class MemoryAuctionDAO implements  AuctionDAO {

    private final List<Auction> auctions = new ArrayList<Auction>();

    protected MemoryAuctionDAO() { }

    @Override
    public List<Auction> findAllActive() {
        // TODO only active auctions
        return auctions;
    }

    @Override
    public Auction save(Auction auction) {
        auctions.add(auction);
        auction.setId(auctions.size());
        return auction;
    }
}
