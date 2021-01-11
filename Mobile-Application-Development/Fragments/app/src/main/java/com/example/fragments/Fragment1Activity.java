package com.example.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment1Activity extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        Context c = getActivity().getApplicationContext();

        // inflate the xml layout of the first fragment
        View vw = inflater.inflate(R.layout.fragment1, container, false);

        // define list view elements
        final String[] charts = {"Pie Chart", "Doughnut Chart", "Histogram"};
        ListView chartsList = vw.findViewById(R.id.chartsList);

        // create and set adapter to list view
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(c, android.R.layout.simple_list_item_1, charts);
        chartsList.setAdapter(arrayAdapter);
        chartsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ImageView selectedChart = getActivity().findViewById(R.id.selectedChart);
                if (charts[i] == "Pie Chart") {
                    selectedChart.setImageResource(R.drawable.pie);
                } else if (charts[i] == "Doughnut Chart") {
                    selectedChart.setImageResource(R.drawable.doughnut);
                } else if (charts[i] == "Histogram") {
                    selectedChart.setImageResource(R.drawable.histogram);
                } else {
                    selectedChart.setImageResource(R.drawable.error);
                }
            }
        });
        return vw;
    }
}
