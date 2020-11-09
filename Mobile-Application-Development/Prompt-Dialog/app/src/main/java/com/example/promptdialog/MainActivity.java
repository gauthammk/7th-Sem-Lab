package com.example.promptdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    Button getDetailsButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialise elements
        getDetailsButton = findViewById(R.id.getDetailsButton);
        final HashMap<String, String> usnMap = new HashMap<String, String>();

        // add id-name pairs to the hash map
        usnMap.put("1BM17IS026", "GMK");
        usnMap.put("1BM17IS030", "Lily");
        usnMap.put("1BM17IS014", "iyengarGaru");
        usnMap.put("1BM17IS009", "Teddy");
        usnMap.put("1BM17IS008", "Boo");

        // onclick listener
        getDetailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final View v = LayoutInflater.from(MainActivity.this).inflate(R.layout.prompt_dialog, null);
                final EditText studentUSN = v.findViewById(R.id.studentUSN);
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Student Details").setView(v)
                        .setPositiveButton("DISPLAY", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String id = studentUSN.getText().toString();
                                if (usnMap.containsKey(id)){
                                    Toast.makeText(MainActivity.this, usnMap.get(id), Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(MainActivity.this, "Sorry, cannot find that USN :(", Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .setNegativeButton("HELP", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this, "Enter USN to find details", Toast.LENGTH_SHORT).show();
                            }
                        }).setCancelable(true);
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }
}