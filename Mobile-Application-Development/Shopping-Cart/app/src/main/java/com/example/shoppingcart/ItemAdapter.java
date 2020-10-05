package com.example.shoppingcart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends ArrayAdapter<ItemModel> {
    private List<ItemModel> dataSet;
    private Context context;
    private TextView itemName, itemCost, itemQuantity;
    private ImageView increaseButton, decreaseButton;

    public ItemAdapter(List<ItemModel> items, Context context) {
        super(context, 0, items);
        this.dataSet = items;
        this.context = context;
    }

    public View getView(final int position, View convertView, ViewGroup parent){
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.row_item, parent,false
            );
        }

        // initialise elements
        final ItemModel item = getItem(position);
        itemName = listItemView.findViewById(R.id.itemName);
        itemCost = listItemView.findViewById(R.id.itemCost);
        itemQuantity = listItemView.findViewById(R.id.itemQuantity);
        increaseButton = listItemView.findViewById(R.id.increaseButton);
        decreaseButton = listItemView.findViewById(R.id.decreaseButton);

        // set the appropriate fields from the model
        itemName.setText(item.getName());
        itemCost.setText(String.valueOf(item.getCost()));
        itemQuantity.setText(String.valueOf(item.getQuantity()));

        // increase on button click
        increaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item.incrementQuantity();
                itemQuantity.setText(String.valueOf(item.getQuantity()));
                notifyDataSetChanged();
            }
        });

        // decrease on button click
        decreaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item.decrementQuantity();
                itemQuantity.setText(String.valueOf(item.getQuantity()));
                notifyDataSetChanged();
            }
        });

        return listItemView;
    }
}
