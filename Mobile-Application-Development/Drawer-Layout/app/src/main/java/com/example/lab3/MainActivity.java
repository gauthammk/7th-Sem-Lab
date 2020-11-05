package com.example.lab3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        setContentView(R.layout.activity_main);
        DrawerLayout mDrawLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        menuItem.setChecked(true);

                        if(menuItem.getItemId() == R.id.contacts)
                            startActivity(new Intent(Intent.ACTION_DEFAULT, ContactsContract.Contacts.CONTENT_URI));

                        else if (menuItem.getItemId()==R.id.browser)
                            startActivity(new Intent (getApplicationContext(),BrowserActivity.class));

                        else if (menuItem.getItemId()==R.id.Search)
                            startActivity(new Intent (getApplicationContext(),SearchViewHandler.class));

                        else if (menuItem.getItemId()==R.id.map)
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?z=4&q=current+location")));
                        return true;
                    }
                });
    }
}