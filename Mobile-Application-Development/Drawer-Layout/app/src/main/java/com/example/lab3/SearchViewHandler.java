package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchViewHandler extends AppCompatActivity {

    SearchView searchView;
    ListView listView;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        setContentView(R.layout.activity_search_view_handler);

        searchView = (SearchView) findViewById(R.id.searchView);
        listView = (ListView) findViewById(R.id.lv);
        listView.setVisibility(View.INVISIBLE);
        list = new ArrayList<>();
        list.add("Alpha");
        list.add("Beta");
        list.add("Gamma");
        list.add("Epsilon");

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if(list.contains(query)){
                    listView.setVisibility(View.VISIBLE);
                    adapter.getFilter().filter(query);
                }else{
                    Toast.makeText(SearchViewHandler.this,"No match found", Toast.LENGTH_SHORT).show();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }
}