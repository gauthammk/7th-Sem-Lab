package com.example.shoppingcart;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView itemListView;
    Button billButton;
    TextView totalDisplay;

    ArrayList<ItemModel> items;
    ItemAdapter itemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);

        // initialise elements
        totalDisplay = findViewById(R.id.totalDisplay);
        billButton = findViewById(R.id.billButton);
        itemListView = findViewById(R.id.itemListView);

        // set divider height to a low value to get a thinner divider
        itemListView.setDividerHeight(1);

        // get predefined item data
        items = getItemData();

        // set the adapter
        itemAdapter = new ItemAdapter(items, this);
        itemListView.setAdapter(itemAdapter);

        // display total bill on button click
        billButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalDisplay.setText("Total = " + String.valueOf(calculateTotal()));
            }
        });

    }

    public ArrayList<ItemModel> getItemData() {
        ArrayList<ItemModel> items = new ArrayList<>();
        items.add(new ItemModel("Banana", 10, 0));
        items.add(new ItemModel("Orange", 20, 0));
        items.add(new ItemModel("Kiwi", 30,0));
        return items;
    }

    public int calculateTotal(){
        int total = 0;
        for(ItemModel item : items){
            total += item.getCost() * item.getQuantity();
        }
        return total;
    }
}