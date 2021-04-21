package com.abhiroop.desipopzsalesclient.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.abhiroop.desipopzsalesclient.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private LinearLayout parentLayout;
    private ConstraintLayout content_item;
    private LayoutInflater inflater;
    private Button addButton;
    private AutoCompleteTextView autoCompleteTextView_type, autoCompleteTextView_number, autoCompleteTextView_rate;
    private int id = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initBaseLayout();

/*
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LayoutInflater inflater=(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View rowView=inflater.inflate(R.layout.content_main, null);
                parentLayout.addView(rowView);
            }
        });
*/

    }

    private void initBaseLayout() {
        LayoutInflater inflater=(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView=inflater.inflate(R.layout.content_main, null);
        parentLayout.addView(rowView);
        addButton.setOnClickListener(this);
    }

    private void initView(){
        parentLayout = (LinearLayout) findViewById(R.id.parent_layout);
        LayoutInflater inflater=(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View content_item = inflater.inflate(R.layout.content_item, null);
        addButton = findViewById(R.id.btn_add_more);
        autoCompleteTextView_number = content_item.findViewById(R.id.no_of_items);
        autoCompleteTextView_rate = content_item.findViewById(R.id.rate_of_items);
        autoCompleteTextView_type = content_item.findViewById(R.id.type_of_item);
        
        initAutoComplete();
    }

    private void initAutoComplete() {
        ArrayAdapter<String> itemTypeAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_dropdown_item_1line,
                getResources().getStringArray(R.array.item_array));
          autoCompleteTextView_type.setAdapter(itemTypeAdapter);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btn_add_more:
                LayoutInflater inflater=(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View rowView=inflater.inflate(R.layout.content_main, null);
                rowView.setId(++id);
                parentLayout.addView(rowView);
                break;

                //AutoComplete
            case R.id.type_of_item:
                autoCompleteTextView_type.showDropDown();
                break;
        }
    }
}