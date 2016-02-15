package br.com.auctionapp.activity;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import auctionapp.com.br.auctionapp.R;
import br.com.auctionapp.CurrencyWatcher;
import br.com.auctionapp.context.AuctionsAppActivity;
import br.com.auctionapp.dao.DAOFactory;
import br.com.auctionapp.fragment.DatePickerDialogFragment;
import br.com.auctionapp.model.Auction;

public class ItemFormActivity extends AuctionsAppActivity {

    private EditText itemName;
    private EditText itemDescription;
    private EditText startTimeText;
    private EditText endTimeText;
    private EditText startingBid;
    private EditText bidIncrement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_form);
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

        itemDescription = (EditText) findViewById(R.id.itemDescription);
        itemName = (EditText) findViewById(R.id.itemName);

        startTimeText = (EditText) findViewById(R.id.startTime);
        startTimeText.setOnClickListener(new OnDateTextClickListener(getFragmentManager(), startTimeText));

        endTimeText = (EditText) findViewById(R.id.endTime);
        endTimeText.setOnClickListener(new OnDateTextClickListener(getFragmentManager(), endTimeText));

        startingBid = (EditText) findViewById(R.id.startingBid);
        startingBid.addTextChangedListener(new CurrencyWatcher(startingBid));

        bidIncrement = (EditText) findViewById(R.id.bitIncrement);
        bidIncrement.addTextChangedListener(new CurrencyWatcher(bidIncrement));

        Button buttonSave = (Button) findViewById(R.id.saveButton);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    createNewAuction();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    private void createNewAuction() throws ParseException {
        Auction newAuction = new Auction(getApplicationContext().getLoggedUser(), itemName.getText().toString(), 10D);
        newAuction.setItemDescription(itemDescription.getText().toString());
        newAuction.setStartTime(new SimpleDateFormat().parse(startTimeText.getText().toString()));
        newAuction.setEndTime(new SimpleDateFormat().parse(endTimeText.getText().toString()));
        newAuction.setBidIncrement(1D);

        DAOFactory.getAuctionDAO().save(newAuction);
        finish();
    }

    private static class OnDateTextClickListener implements View.OnClickListener {

        FragmentManager manager;
        EditText editText;

        OnDateTextClickListener(FragmentManager manager, EditText editText) {
            this.manager =  manager;
            this.editText = editText;
        }

        @Override
        public void onClick(View v) {
            FragmentTransaction ft = manager.beginTransaction();
            DialogFragment newFragment = new DatePickerDialogFragment(editText, new SimpleDateFormat());
            newFragment.show(ft, "date_dialog");
        }

    }

}
