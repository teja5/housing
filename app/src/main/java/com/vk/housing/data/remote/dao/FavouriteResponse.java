package com.vk.housing.data.remote.dao;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FavouriteResponse {
    @SerializedName("error")
    @Expose
    private Error error;
    @SerializedName("status")
    @Expose
    private Integer status;

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
