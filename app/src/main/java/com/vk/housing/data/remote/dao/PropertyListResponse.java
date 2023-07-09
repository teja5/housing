package com.vk.housing.data.remote.dao;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PropertyListResponse {

    @SerializedName("propertyList")
    @Expose
    private List<Property> propertyList;
    @SerializedName("error")
    @Expose
    private Error error;

    public List<Property> getPropertyList() {
        return propertyList;
    }

    public void setPropertyList(List<Property> propertyList) {
        this.propertyList = propertyList;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }
}
