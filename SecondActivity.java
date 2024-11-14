package com.loonahjude.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.*;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.appbar.MaterialToolbar;
import java.text.DecimalFormat;
import java.util.Objects;

public class SecondActivity extends AppCompatActivity {

    // Initiates the activity:
    @SuppressLint("UseSupportActionBar")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Updating the view with the clicked radio button's text on create:
        String targetCurrency = getIntent().getStringExtra("Currency");
        TextView trgtCurrency = findViewById(R.id.targetCurrency);
        trgtCurrency.setText(targetCurrency);

        // Making the return button in the toolbar work:
        MaterialToolbar toolbar = findViewById(R.id.topBar);
        toolbar.setNavigationOnClickListener(v -> finish());

        // Grabbing my two currency text fields:
        EditText usd = findViewById(R.id.usdAmount);
        EditText convertedCurrency = findViewById(R.id.convertedAmount);

        // Creating the USD field listener:
        usd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (usd.isFocused()) {
                    String amountUsd = usd.getText().toString();
                    if (!amountUsd.isEmpty()) {
                        String unformattedAmount = String.valueOf(currencyConvert(Double.parseDouble(amountUsd)));
                        String newAmount = formatDouble(unformattedAmount);
                        convertedCurrency.setText(newAmount);
                    } else {
                        convertedCurrency.setText("");
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        // Creating the second field's listener:
        convertedCurrency.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (convertedCurrency.isFocused()) {
                    String amountConverted = convertedCurrency.getText().toString();
                    if (!amountConverted.isEmpty()) {
                        String unformattedAmount = String.valueOf(backwardsConvert(Double.parseDouble(amountConverted)));
                        String newAmount = formatDouble(unformattedAmount);
                        usd.setText(newAmount);
                    } else {
                        usd.setText("");
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    // Creating the method for the currency conversion:
    public double currencyConvert(double amountToConvert) {
        double convertedAmount;
        // Grabbing the clicked radio button's text:
        String targetCurrency = getIntent().getStringExtra("Currency");

        // Converting based on the requested currency:
        if (Objects.equals(targetCurrency, "YEN")) {
            convertedAmount = amountToConvert * 109.94;
        } else if (Objects.equals(targetCurrency, "CAD")) {
            convertedAmount = amountToConvert * 1.26;
        } else {
            convertedAmount = amountToConvert * 0.85;
        }

        return convertedAmount;
    }

    // If the user enters an amount in the other currency's field, it'll convert to USD:
    public double backwardsConvert(double amountToUnconvert){
        double unconvertedAmount;

        // Grabbing the clicked radio button's text:
        String targetCurrency = getIntent().getStringExtra("Currency");

        // Unconverting based on the requested currency:
        if (Objects.equals(targetCurrency, "YEN")) {
            unconvertedAmount = amountToUnconvert * 0.0090958704748;
        } else if (Objects.equals(targetCurrency, "CAD")) {
            unconvertedAmount = amountToUnconvert * 0.7936507936507;
        } else {
            unconvertedAmount = amountToUnconvert * 1.1764705882352;
        }

        return unconvertedAmount;
    }

    // Formatting the doubles so that only 2 decimals are shown:
    public String formatDouble(String str) {
        String formattedValue;
        double unformattedValue = Double.parseDouble(str);
        DecimalFormat df = new DecimalFormat("#.##");
        formattedValue = df.format(unformattedValue);

        return formattedValue;
    }
}