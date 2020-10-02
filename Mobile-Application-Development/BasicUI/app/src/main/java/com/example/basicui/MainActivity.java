package com.example.basicui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button editTextButton, checkboxButton, spinnerButton, autoCompleteButton, progressButton, datePickerButton, listViewButton, gridViewButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextButton = findViewById(R.id.editTextButton);
        editTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent opener = new Intent(MainActivity.this, TheEditText.class);
                startActivity(opener);
            }
        });
        checkboxButton = findViewById(R.id.checkBoxButton);
        checkboxButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent opener = new Intent(MainActivity.this, TheCheckbox.class);
                startActivity(opener);
            }
        });
        spinnerButton = findViewById(R.id.spinnerButton);
        spinnerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent opener = new Intent(MainActivity.this, TheSpinner.class);
                startActivity(opener);
            }
        });
        autoCompleteButton = findViewById(R.id.autoCompleteButton);
        autoCompleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent opener = new Intent(MainActivity.this, TheAutocomplete.class);
                startActivity(opener);
            }
        });
        progressButton = findViewById(R.id.progressButton);
        progressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent opener = new Intent(MainActivity.this, TheProgressBar.class);
                startActivity(opener);
            }
        });
        datePickerButton = findViewById(R.id.datePickerButton);
        datePickerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent opener = new Intent(MainActivity.this, TheDatePicker.class);
                startActivity(opener);
            }
        });
        listViewButton = findViewById(R.id.listViewButton);
        listViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent opener = new Intent(MainActivity.this, TheListView.class);
                startActivity(opener);
            }
        });
        gridViewButton = findViewById(R.id.gridViewButton);
        gridViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent opener = new Intent(MainActivity.this, TheGridView.class);
                startActivity(opener);
            }
        });
    }
}