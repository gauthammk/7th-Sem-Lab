package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Spinner currencySpinner;
    TextView result;
    EditText amount;
    String[] currencies = {"None Selected", "US", "UK", "SGD"};
    Button convertButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialise elements
        currencySpinner = findViewById(R.id.currencySpinner);
        currencySpinner.setOnItemSelectedListener(this);
        convertButton = findViewById(R.id.convertButton);
        result = findViewById(R.id.result);
        amount = findViewById(R.id.amount);

        // set the adapter for the spinner
        ArrayAdapter<String> aa = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, currencies);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        currencySpinner.setAdapter(aa);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currency = currencySpinner.getSelectedItem().toString();
                String amountString = amount.getText().toString().trim();

                System.out.println("Amount entered: " + amountString);

                if (amountString.length() > 0) {

                    // parse string to integer
                    int amountInt = 0;
                    try {
                        amountInt = Integer.parseInt(amountString);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (currency == "US") {
                        // US conversion
                        result.setText(Integer.toString(amountInt * 70));
                    } else if (currency == "UK") {
                        // UK conversion
                        result.setText(Integer.toString(amountInt * 80));
                    } else if (currency == "SGD") {
                        // Singapore conversion
                        result.setText(Integer.toString(amountInt * 50));
                    } else {
                        result.setText("Select a currency.");
                    }
                }
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, currencies[position] + " selected", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        // to be implemented
    }
}