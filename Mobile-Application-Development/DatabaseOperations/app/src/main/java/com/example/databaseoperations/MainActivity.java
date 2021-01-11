package com.example.databaseoperations;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText fname, lname;
    TextView list;
    dbController dbc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fname = (EditText)findViewById(R.id.fname);
        lname = (EditText)findViewById(R.id.lname);
        list = (TextView)findViewById(R.id.textView);
        dbc = new dbController(this, "", null, 1);
    }

    public void btn_click(View v) {
        switch(v.getId())
        {
            case R.id.btnadd:
                try
                {
                    dbc.insert(fname.getText().toString(),lname.getText().toString());
                }
                catch(SQLiteException e)
                {
                    Toast.makeText(MainActivity.this,"Error",Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btndel:
                dbc.delete(fname.getText().toString());
                break;

            case R.id.btnupd:
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("please enter new first name");
                final EditText newFname = new EditText(this);
                dialog.setView(newFname);

                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dbc.update(fname.getText().toString(),newFname.getText().toString());
                    }
                });

                dialog.show();
                break;

            case R.id.btnlis:
                dbc.list(list);
                break;
        }
    }
}