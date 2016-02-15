package br.com.auctionapp.context;

import android.content.Intent;

import br.com.auctionapp.model.User;

public class LoginState implements AuthenticationState {

    private User loggedUser;

    public LoginState(User loggedUser) {
        if(loggedUser == null) throw new IllegalArgumentException();
        this.loggedUser = loggedUser;
    }

    @Override
    public void startActivity(AuctionsAppActivity context, Intent intent) {
        context.doStartActivity(intent);
    }

    @Override
    public User getLoggedUser() {
        return loggedUser;
    }
}
