package com.vk.housing.data.remote.dao;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Property {

    @SerializedName("property_id")
    @Expose
    private Integer propertyId;
    @SerializedName("property_for")
    @Expose
    private Integer propertyFor;
    @SerializedName("building_type")
    @Expose
    private Integer buildingType;
    @SerializedName("construction_status")
    @Expose
    private Integer constructionStatus;
    @SerializedName("age_of_property")
    @Expose
    private Integer ageOfProperty;
    @SerializedName("p_address")
    @Expose
    private String pAddress;
    @SerializedName("p_phone")
    @Expose
    private String pPhone;
    @SerializedName("bhk")
    @Expose
    private Integer bhk;
    @SerializedName("uid")
    @Expose
    private Integer uid;

    public Integer getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Integer propertyId) {
        this.propertyId = propertyId;
    }

    public Integer getPropertyFor() {
        return propertyFor;
    }

    public void setPropertyFor(Integer propertyFor) {
        this.propertyFor = propertyFor;
    }

    public Integer getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(Integer buildingType) {
        this.buildingType = buildingType;
    }

    public Integer getConstructionStatus() {
        return constructionStatus;
    }

    public void setConstructionStatus(Integer constructionStatus) {
        this.constructionStatus = constructionStatus;
    }

    public Integer getAgeOfProperty() {
        return ageOfProperty;
    }

    public void setAgeOfProperty(Integer ageOfProperty) {
        this.ageOfProperty = ageOfProperty;
    }

    public String getpAddress() {
        return pAddress;
    }

    public void setpAddress(String pAddress) {
        this.pAddress = pAddress;
    }

    public String getpPhone() {
        return pPhone;
    }

    public void setpPhone(String pPhone) {
        this.pPhone = pPhone;
    }

    public Integer getBhk() {
        return bhk;
    }

    public void setBhk(Integer bhk) {
        this.bhk = bhk;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}
