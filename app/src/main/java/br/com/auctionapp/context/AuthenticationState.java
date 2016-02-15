package br.com.auctionapp.context;

import android.content.Intent;

import br.com.auctionapp.model.User;

/**
 * Created by Cindy on 03/02/2016.
 */
public interface AuthenticationState {

    public void startActivity(AuctionsAppActivity context, Intent intent);
    public User getLoggedUser();

}
