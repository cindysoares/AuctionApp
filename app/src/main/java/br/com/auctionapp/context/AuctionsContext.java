package br.com.auctionapp.context;

import android.app.Application;
import android.content.Intent;

import br.com.auctionapp.bot.CreateUsersAndAuctionsService;
import br.com.auctionapp.model.User;

public class AuctionsContext extends Application {

    AuthenticationState state = new LogoutState();

    public User getLoggedUser() {
        return state.getLoggedUser();
    }

    public void setLoggedUser(User loggedUser) {
        if(loggedUser == null) {
            this.state = new LogoutState();
        } else {
            this.state = new LoginState(loggedUser);
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Intent createUsersAndAuctions = new Intent(this, CreateUsersAndAuctionsService.class);
        startService(createUsersAndAuctions);
    }

}
