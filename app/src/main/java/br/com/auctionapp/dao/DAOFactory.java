package br.com.auctionapp.dao;

public class DAOFactory {

    private static final UserDAO userDAO = new MemoryUserDAO();
    private static final AuctionDAO auctionDAO = new MemoryAuctionDAO();

    public static UserDAO getUserDAO() {
        return userDAO;
    }

    public static AuctionDAO getAuctionDAO() {
        return auctionDAO;
    }

}
