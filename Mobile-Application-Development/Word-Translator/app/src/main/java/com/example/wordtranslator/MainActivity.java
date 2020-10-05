package com.example.wordtranslator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner wordSpinner;
    TextView latinTranslationDisplay;
    String[] words = {"None Selected", "Hello", "Good morning", "Coffee", "Cat", "Snake", "Hedge", "Dog", "Fish", "Friend", "Wife", "Religion"};
    String[] latinWords = {"", "Salve", "bonum mane", "capulus", "cattus", "anguis", "sepiam", "canis", "piscis", "amica", "uxorem", "religio"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialise the elements
        wordSpinner = findViewById(R.id.wordSpinner);
        wordSpinner.setOnItemSelectedListener(this);

        // set the adapter for the spinner
        ArrayAdapter<String> aa = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, words);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        wordSpinner.setAdapter(aa);



    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        // setting the latin translation of the selected word in the text view
        latinTranslationDisplay = findViewById(R.id.latinTranslationDisplay);
        latinTranslationDisplay.setText(latinWords[position]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

        // yet to be implemented
    }
}