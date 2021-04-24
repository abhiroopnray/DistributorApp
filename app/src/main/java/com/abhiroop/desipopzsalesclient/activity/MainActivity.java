package com.abhiroop.desipopzsalesclient.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.abhiroop.desipopzsalesclient.R;
import com.abhiroop.desipopzsalesclient.database.AppInfoEntity;
import com.abhiroop.desipopzsalesclient.database.DistributorInfoEntity;
import com.abhiroop.desipopzsalesclient.repository.LocalRepository;

import java.util.ArrayList;

import java.security.PrivateKey;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {


    private LinearLayout parentLayout;
    private ConstraintLayout content_item;
    private Button addButton;
    private AutoCompleteTextView autoCompleteTextView_type, autoCompleteTextView_number, autoCompleteTextView_rate;
    private int id = 1;

    private Button addMoreButton, addToDb;
    private EditText shopName, shopLocation;
    private Spinner brand_spinner, product_spinner;
    // private ArrayList<AddSpinnerBrandItems> brandSpinnerBrandModel;
    private ArrayList<String> brandNamesList;
    // private BrandName brandName;
    private ArrayAdapter<CharSequence> adapter;
    private String[] names = new String[]{"Select Iem", "Add", "Milk Mantra", "Shelly", "Desi Popz", "Add More"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initBaseLayout();
        initItemView();
        //TODO: fetch from API
      //  initBrandSpinner();
    }

    private void initItemView() {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.content_main, parentLayout, true);

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

    private void initView() {
        parentLayout = (LinearLayout) findViewById(R.id.parent_layout);
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View content_item = inflater.inflate(R.layout.product_item_spinner, /*parentLayout, false*/null);
        addMoreButton = findViewById(R.id.btn_add_more);
        brand_spinner = content_item.findViewById(R.id.brand_spinner);
        product_spinner = content_item.findViewById(R.id.product_spinner);
        parentLayout.addView(content_item);
        addMoreButton.setOnClickListener(this::onClick);
        // brandSpinnerBrandModel = new ArrayList();
    }

    private void initBaseLayout() {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView = inflater.inflate(R.layout.content_main, null);
        parentLayout.addView(rowView);
//        addButton.setOnClickListener(this);
    }


    private void initAutoComplete() {
        ArrayAdapter<String> itemTypeAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_dropdown_item_1line,
                getResources().getStringArray(R.array.item_array));
        autoCompleteTextView_type.setAdapter(itemTypeAdapter);

/*

        for (int i = 0 ; i < names.length; i ++){
            AddSpinnerBrandItems addSpinnerBrandItems= new AddSpinnerBrandItems(names[i], Integer.toString(i));
            brandSpinnerBrandModel.add(addSpinnerBrandItems);
        }

        Toast.makeText(this, "Model size: " + brandSpinnerBrandModel.size(), Toast.LENGTH_SHORT).show();
*/

            brandNamesList = new ArrayList<>();
/*
        for(int i = 0; i < brandSpinnerBrandModel.size(); i ++){
            brandNamesList.add(brandSpinnerBrandModel.get(i).getmName());
        }
*/


//        Toast.makeText(this, "Name list first item: " +brandNamesList.get(0), Toast.LENGTH_SHORT).show();
            //BrandSpinnerAdapter adapter = new BrandSpinnerAdapter(this, brandSpinnerBrandModel);
            adapter
                    = new ArrayAdapter(
                    getApplicationContext(),
                    android.R.layout.simple_spinner_item,
                    names);
            //      Toast.makeText(this, "ARRAYADAPTER: " + adapter.getCount(), Toast.LENGTH_SHORT).show();

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            brand_spinner.setAdapter(adapter);
            brand_spinner.setSelection(0);
            //brandSpinnerAdapter.notifyDataSetChanged();
            brand_spinner.setOnItemSelectedListener(this);

        }

        @Override
        public void onClick (View v){
            int id = v.getId();
            switch (id) {
                case R.id.btn_add_more:
                    LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    final View rowView = inflater.inflate(R.layout.content_main, parentLayout, false);
                    rowView.setId(++id);

                    parentLayout.addView(rowView);
                    brand_spinner.setAdapter(adapter);
                    break;

                //AutoComplete
                case R.id.type_of_item:
                    autoCompleteTextView_type.showDropDown();
                    break;
            }
        }


        private void insertToDB () {
            String name_of_shop = shopName.getText().toString().trim();
            String location = shopLocation.getText().toString().trim();
            DistributorInfoEntity appInfoEntity = LocalRepository.getInstance(this).appRoomDao().getEntity();
            appInfoEntity.setShopName(name_of_shop);
            appInfoEntity.setShopLocation(location);
            LocalRepository.getInstance(this).appRoomDao().update(appInfoEntity);

            Log.d("Abhiroop", "room value: " + LocalRepository.getInstance(this).appRoomDao().getEntity().getShopName());
        }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}