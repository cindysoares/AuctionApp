package br.com.auctionapp.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;

import auctionapp.com.br.auctionapp.R;
import br.com.auctionapp.context.AuctionsAppActivity;
import br.com.auctionapp.model.Auction;

public class ItemActivity extends AuctionsAppActivity {

    Auction selectedAuction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        selectedAuction = (Auction) getIntent().getSerializableExtra("selectedItem");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Button bidButton = (Button) findViewById(R.id.bidButton);
        bidButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bid();
            }
        });

        updateItemInfomation();
    }

    private void bid() {
        selectedAuction.bid(getApplicationContext().getLoggedUser());
        updateItemInfomation();
        Toast.makeText(this, "Bidding registered.", Toast.LENGTH_LONG);
    }

    private void updateItemInfomation() {
        TextView descriptionTextView = (TextView) findViewById(R.id.item_description);
        descriptionTextView.setText(selectedAuction.getFullDescription());
    }

}
