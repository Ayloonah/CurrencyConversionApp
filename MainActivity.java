package com.loonahjude.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // Initiates the activity:
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // What happens on button click:
    public void buttonClick(View v){
        // Grabbing info on the selected radio button:
        RadioGroup rGroup = findViewById(R.id.currencyRadioButton);
        int selectedId = rGroup.getCheckedRadioButtonId();

        // If no radio button is selected:
        if(selectedId == -1)
        {
            // Shows a notification that a choice needs to be made:
            Toast.makeText(getApplicationContext(), "Please select a currency type", Toast.LENGTH_SHORT).show();
        }
        // If there was a selected radio button:
        else
        {
            // Navigating to the second activity and passing it the button's text:
            Intent secondActivity = new Intent(this,SecondActivity.class);
            RadioButton selectedRadioButton = findViewById(selectedId);
            secondActivity.putExtra("Currency", selectedRadioButton.getText().toString());
            startActivity(secondActivity);
        }

    }

}