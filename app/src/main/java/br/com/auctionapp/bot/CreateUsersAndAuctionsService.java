package br.com.auctionapp.bot;

import android.app.IntentService;
import android.content.Intent;
import android.widget.Toast;

import br.com.auctionapp.dao.AuctionDAO;
import br.com.auctionapp.dao.DAOFactory;
import br.com.auctionapp.dao.UserDAO;
import br.com.auctionapp.model.Auction;
import br.com.auctionapp.model.User;

public class CreateUsersAndAuctionsService extends IntentService {

    public CreateUsersAndAuctionsService() {
        super("CreateUsersAndAuctionsService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        AuctionDAO auctionDAO = DAOFactory.getAuctionDAO();
        UserDAO userDAO = DAOFactory.getUserDAO();

        User user1 = new User("user1@email.com", "user1");
        User user2 = new User("user2@email.com", "user2");

        userDAO.save(user1);
        userDAO.save(user2);

        Auction auction1 = new Auction(user1, "Item 1", 10.0);
        auction1.setItemDescription("Description....");

        Auction auction2 = new Auction(user2, "Item 2", 50.0);
        auction1.setItemDescription("Description 2....");
        auction2.bid(user1);

        auctionDAO.save(auction1);
        auctionDAO.save(auction2);
    }

}
