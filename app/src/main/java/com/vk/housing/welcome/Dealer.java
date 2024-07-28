package com.vk.housing.welcome;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Dealer {

    @SerializedName("dealer_id")
    @Expose
    private Integer dealerId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("phone")
    @Expose
    private Object phone;
    @SerializedName("village")
    @Expose
    private Object village;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("landmark")
    @Expose
    private Object landmark;
    @SerializedName("dTransactions")
    @Expose
    private Object dTransactions;

    public Integer getDealerId() {
        return dealerId;
    }

    public void setDealerId(Integer dealerId) {
        this.dealerId = dealerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getPhone() {
        return phone;
    }

    public void setPhone(Object phone) {
        this.phone = phone;
    }

    public Object getVillage() {
        return village;
    }

    public void setVillage(Object village) {
        this.village = village;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Object getLandmark() {
        return landmark;
    }

    public void setLandmark(Object landmark) {
        this.landmark = landmark;
    }

    public Object getdTransactions() {
        return dTransactions;
    }

    public void setdTransactions(Object dTransactions) {
        this.dTransactions = dTransactions;
    }
}
