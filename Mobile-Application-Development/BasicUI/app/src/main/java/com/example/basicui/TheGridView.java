package com.example.basicui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

public class TheGridView extends AppCompatActivity {

    String[] symbols = {"Alpha", "Beta", "Gamma", "Eta"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_grid_view);

        GridView listView = findViewById(R.id.gridView);
        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, symbols);
        listView.setAdapter(adapter);
    }
}