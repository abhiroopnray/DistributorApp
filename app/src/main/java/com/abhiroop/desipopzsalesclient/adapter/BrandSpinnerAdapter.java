package com.abhiroop.desipopzsalesclient.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.abhiroop.desipopzsalesclient.DummyData.AddSpinnerBrandItems;
import com.abhiroop.desipopzsalesclient.R;
import com.abhiroop.desipopzsalesclient.pojo.BrandName;

import java.util.ArrayList;
import java.util.List;

public class BrandSpinnerAdapter extends ArrayAdapter<AddSpinnerBrandItems> {

    public BrandSpinnerAdapter(Context context,
                            ArrayList<AddSpinnerBrandItems> items)
    {
        super(context, 0, items);
    }

    @Override
    public int getCount() {
        Toast.makeText(getContext(), "adapter count: " + super.getCount(), Toast.LENGTH_SHORT).show();
        return super.getCount();
    }

    @NonNull
    @Override
    public View  getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        /*View view = super.getView(position, convertView, parent);
        view.setPadding(0, view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());*/
        return initView(position, convertView, parent);
    }

  /*  public BrandSpinnerAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull List objects) {
        super(context, resource, textViewResourceId, objects);
    }*/

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    private View initView(int position, View convertView, ViewGroup parent) {
        // It is used to set our custom view.
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.more_layout, parent, false);
        }
        TextView textViewName = convertView.findViewById(R.id.tv);
        AddSpinnerBrandItems currentItem = getItem(position);
        // It is used the name to the TextView when the
        // current item is not null.
        if (currentItem != null) {
            textViewName.setText(currentItem.getmName());
        }
        return convertView;
    }
}
