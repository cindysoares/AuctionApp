package br.com.auctionapp;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyWatcher implements TextWatcher {

    private String currentValue;
    private EditText textView;

    public CurrencyWatcher(EditText textView) {
        this.textView = textView;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        currentValue = textView.getText().toString();
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    @Override
    public void afterTextChanged(Editable s) {
        if(!s.toString().equals(currentValue)){
            textView.removeTextChangedListener(this);

            String replaceable = String.format("[%s,.]", NumberFormat.getCurrencyInstance().getCurrency().getSymbol());
            String cleanString = s.toString().replaceAll(replaceable, "");

            double parsed = Double.parseDouble(cleanString);
            String formatted = NumberFormat.getCurrencyInstance().format((parsed/100));

            currentValue = formatted;
            textView.setText(formatted);
            textView.setSelection(formatted.length());

            textView.addTextChangedListener(this);
        }
    }
}
