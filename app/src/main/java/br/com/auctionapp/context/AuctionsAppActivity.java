package br.com.auctionapp.context;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import br.com.auctionapp.context.AuctionsContext;

/**
 * Created by Cindy on 03/02/2016.
 */
public abstract class AuctionsAppActivity extends AppCompatActivity {

    @Override
    public AuctionsContext getApplicationContext() {
        return (AuctionsContext) super.getApplicationContext();
    }

    @Override
    public void startActivity(Intent intent) {
        getApplicationContext().state.startActivity(this, intent);
    }

    void doStartActivity(Intent intent) {
        super.startActivity(intent);
    }
}
