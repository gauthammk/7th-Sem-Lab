package com.example.toasts;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // flag for toggling colors
    int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showToast("onCreate() was called");

        // declaring the buttons
        Button clickMeButton = findViewById(R.id.colorChanger);
        Button finishButton = findViewById(R.id.finisher);
        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        clickMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RelativeLayout mainLayout = findViewById(R.id.mainLayout);

                // toggle light mode
                if (flag == 1) {
                    mainLayout.setBackgroundColor(Color.WHITE);
                    flag = 0;
                }

                // toggle dark mode
                else {
                    mainLayout.setBackgroundColor(getResources().getColor(R.color.darkModeBackground));
                    flag = 1;
                }
             }
        });
    }

    // displaying life cycle toasts
    @Override
    protected void onStart()
    {
        super.onStart();
        showToast("onStart() was called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        showToast("onStop() was called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        showToast("onPause was called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        showToast("onDestroy was called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        showToast("onResume was called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        showToast("onRestart was called");
    }

    void showToast(String message) {
        Toast.makeText (this,message, Toast.LENGTH_SHORT).show();
    }
}
