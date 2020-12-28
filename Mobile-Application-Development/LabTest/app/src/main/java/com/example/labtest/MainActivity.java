package com.example.labtest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ActionBar.TabListener {

    TextView selectedDisplay, contextMenuTrigger;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // register textview for context menu
        contextMenuTrigger = findViewById(R.id.contextMenuTrigger);
        registerForContextMenu(contextMenuTrigger);

        // load action bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Lab Test");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.addTab(actionBar.newTab().setText("Tab 1").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("Tab 2").setTabListener(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.custom_menu, menu);
        return true;
    }

    // respond to menu clicks
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        selectedDisplay = findViewById(R.id.selectedDisplay);
        if (item.getItemId() == R.id.search) {
            selectedDisplay.setText("Search was selected!");
        } else if (item.getItemId() == R.id.favourite) {
            selectedDisplay.setText("Favourite was selected!");
        } else {
            selectedDisplay.setText("Login was selected!");
        }
        return super.onOptionsItemSelected(item);
    }

    // add context menu element
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        menu.setHeaderTitle("Sample Context Menu");
        menu.add(200, 200, 200, "item1");
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        int nTabSelected = tab.getPosition();
        switch (nTabSelected) {
            case 0:
                setContentView(R.layout.actionbar_tab_1);
                break;
            case 1:
                setContentView(R.layout.actionbar_tab_2);
                break;
        }
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}