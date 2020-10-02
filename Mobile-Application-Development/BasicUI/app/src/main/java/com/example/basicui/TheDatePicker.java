package com.example.basicui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class TheDatePicker extends AppCompatActivity {

    TextView textview1;
    DatePicker picker;
    Button displayDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_date_picker);
        textview1=findViewById(R.id.textView1);
        picker = findViewById(R.id.datePicker);
        displayDate = findViewById(R.id.button1);

        textview1.setText("Current Date: "+getCurrentDate());

        displayDate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                textview1.setText("Change Date: " + getCurrentDate());
            }

        });

    }
    public String getCurrentDate(){
        StringBuilder builder=new StringBuilder();;
        builder.append(picker.getMonth() + 1).append("/");//month is 0 based
        builder.append(picker.getDayOfMonth()).append("/");
        builder.append(picker.getYear());
        return builder.toString();
    }
}