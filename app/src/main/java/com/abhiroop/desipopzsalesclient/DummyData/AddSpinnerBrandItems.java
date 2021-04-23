package com.abhiroop.desipopzsalesclient.DummyData;

import com.abhiroop.desipopzsalesclient.pojo.BrandName;

import java.util.ArrayList;

public class AddSpinnerBrandItems {

    private BrandName brandName;
    private String mName, id;

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public AddSpinnerBrandItems(String name, String id) {
        mName = name;
        this.id = id;
        addSpinnerBrandName(name, id);
    }

    public void addSpinnerBrandName(String name, String id){
        brandName = new BrandName();
        brandName.setBrandName(name);
        brandName.setId(id);
    }

    private void addMoreSpinnerItem(String name, String id){
        brandName = new BrandName();
        brandName.setBrandName(name);
        brandName.setId(id);
    }
}
