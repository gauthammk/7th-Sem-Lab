package com.example.gradecalculator;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Arrays;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    Button calculateButton;
    EditText test1, test2, test3, activity;
    TextView result;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            Objects.requireNonNull(this.getSupportActionBar()).hide();
        }
        catch (NullPointerException e){
            System.out.println("Toolbar exception.");
        }
        setContentView(R.layout.activity_main);

        // initialise elements
        calculateButton = findViewById(R.id.calculateButton);
        test1 = findViewById(R.id.test1);
        test2 = findViewById(R.id.test2);
        test3 = findViewById(R.id.test3);
        activity = findViewById(R.id.activity);
        result = findViewById(R.id.result);

        // calculate marks on click of the calculate button
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String test1Str = test1.getText().toString().trim();
                String test2Str = test2.getText().toString().trim();
                String test3Str = test3.getText().toString().trim();
                String activityStr = activity.getText().toString().trim();

                // check if the marks are valid
                if (test1Str.length() > 0 && test2Str.length() > 0 && test3Str.length() > 0 && activityStr.length() > 0){

                    int[] testMarks = new int[3];
                    testMarks[0] = Integer.parseInt(test1Str);
                    testMarks[1] = Integer.parseInt(test2Str);
                    testMarks[2] = Integer.parseInt(test3Str);
                    int activityMarks = Integer.parseInt(activityStr);

                    // find best of three tests
                    Arrays.sort(testMarks);
                    int resultMarks = (testMarks[1] + testMarks[2]) + activityMarks;
                    System.out.println("RESULT: " + resultMarks);

                    // display the result
                    if (resultMarks >= 50) {
                        result.setTextColor(Color.parseColor("#008000"));
                    } else {
                        result.setTextColor(Color.parseColor("#FF0000"));
                    }
                    result.setText("Result = " + resultMarks);
                } else {

                    // display error message as a toast
                    Toast.makeText(getApplicationContext(), "Please enter marks in all 4 fields.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}