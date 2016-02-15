package br.com.auctionapp.context;

import android.content.Intent;

import br.com.auctionapp.activity.LoginActivity;
import br.com.auctionapp.model.User;

public class LogoutState implements AuthenticationState {

    public LogoutState() {
    }

    @Override
    public void startActivity(AuctionsAppActivity context, Intent intent) {
        Intent loginIntent = new Intent(context, LoginActivity.class);
        loginIntent.putExtra("nextIntent", intent);
        context.doStartActivity(loginIntent);
    }

    @Override
    public User getLoggedUser() {
        return null;
    }
}


