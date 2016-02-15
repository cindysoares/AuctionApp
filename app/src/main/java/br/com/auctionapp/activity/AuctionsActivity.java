package br.com.auctionapp.activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import auctionapp.com.br.auctionapp.R;
import br.com.auctionapp.context.AuctionsAppActivity;
import br.com.auctionapp.dao.DAOFactory;
import br.com.auctionapp.model.Auction;

public class AuctionsActivity extends AuctionsAppActivity {

    private ListView listView;

    private Intent nextIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(null, "onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auctions);

        findViewById(R.id.add_auctions).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startCreateAuction();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_new_auction) {
            startCreateAuction();
        } else if (item.getItemId() == R.id.action_profile) {
            startMyProfile();
        }
        return super.onOptionsItemSelected(item);
    }

    private void startMyProfile() {
        Intent createAuction = new Intent(AuctionsActivity.this, MyProfileActivity.class);
        startActivity(createAuction);
    }

    private void startCreateAuction() {
        Intent createAuction = new Intent(AuctionsActivity.this, ItemFormActivity.class);
        startActivity(createAuction);
    }

    @Override
    protected void onResume() {
        super.onResume();
        listView = (ListView) findViewById(R.id.auctions_list);
        List<Auction> auctions = DAOFactory.getAuctionDAO().findAllActive();
        listView.setAdapter(new ArrayAdapter<Auction>(
                this, android.R.layout.simple_list_item_1, auctions));

        configureListView(auctions);
    }

    private void configureListView(final List<Auction> auctions) {

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int index, long id) {
                Intent showItem = new Intent(AuctionsActivity.this, ItemActivity.class);
                showItem.putExtra("selectedItem", (Auction) listView.getItemAtPosition(index));
                startActivity(showItem);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (nextIntent!=null) {
            startActivity(nextIntent);
            nextIntent = null;
        }
    }
}
