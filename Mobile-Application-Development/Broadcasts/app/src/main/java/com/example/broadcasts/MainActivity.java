package com.example.broadcasts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BroadcastReceiver x = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)){
                    Toast.makeText(context, "Power Connected", Toast.LENGTH_SHORT).show();
                } else if (intent.getAction().equals(Intent.ACTION_POWER_DISCONNECTED)){
                    Toast.makeText(context, "Power Disconnected", Toast.LENGTH_SHORT).show();
                } else if (intent.getAction().equals(Intent.ACTION_HEADSET_PLUG)){
                    Toast.makeText(context, "Headset plugged", Toast.LENGTH_SHORT).show();
                } else if (intent.getAction().equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)){
                    Toast.makeText(context, "Airplane Mode Changed", Toast.LENGTH_SHORT).show();
                }
            }
        };
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_POWER_CONNECTED);
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        filter.addAction(Intent.ACTION_HEADSET_PLUG);
        this.registerReceiver(x, filter);
    }
}