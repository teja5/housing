package com.vk.housing.data.remote.dao;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PropertyResponse {

    @SerializedName("property")
    @Expose
    private Property property;
    @SerializedName("error")
    @Expose
    private Error error;
    @SerializedName("status")
    @Expose
    private Integer status;

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
