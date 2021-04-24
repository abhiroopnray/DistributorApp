package com.abhiroop.desipopzsalesclient.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.abhiroop.desipopzsalesclient.common.Constants;

/**
 * Sample data response
 * {
 * }
 */
@Entity(tableName = Constants.TABLE_NAME)
@TypeConverters({Converters.class})
public class DistributorInfoEntity {
    @PrimaryKey(autoGenerate = false)
    private int id;
    private String shopName;
    private String shopLocation;
    private String itemType;
    private int itemQuantity;
    private int price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopLocation() {
        return shopLocation;
    }

    public void setShopLocation(String shopLocation) {
        this.shopLocation = shopLocation;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}