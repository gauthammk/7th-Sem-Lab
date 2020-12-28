package com.example.framelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageOne = null;
    ImageView imageTwo = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageOne = findViewById(R.id.oneImgView);
        imageTwo = findViewById(R.id.twoImgView);

        imageOne.setOnClickListener(new View.OnClickListener(){
        public void onClick(View view) {
            imageTwo.setVisibility(View.VISIBLE);
            view.setVisibility(View.GONE);
        }});
        imageTwo.setOnClickListener(new View.OnClickListener(){
        public void onClick(View view) {
            imageOne.setVisibility(View.VISIBLE);
            view.setVisibility(View.GONE);
        }});
    }
}