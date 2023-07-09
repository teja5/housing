package com.vk.housing.data.remote.dao;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Property {

    @SerializedName("parking")
    @Expose
    private Integer parking;
    @SerializedName("age_of_property")
    @Expose
    private Integer ageOfProperty;
    @SerializedName("property_for")
    @Expose
    private Integer propertyFor;
    @SerializedName("images")
    @Expose
    private List<List<Object>> images;
    @SerializedName("bhk")
    @Expose
    private Integer bhk;
    @SerializedName("balcony")
    @Expose
    private Integer balcony;
    @SerializedName("p_phone")
    @Expose
    private String pPhone;
    @SerializedName("property_id")
    @Expose
    private Integer propertyId;
    @SerializedName("uid")
    @Expose
    private Integer uid;
    @SerializedName("p_address")
    @Expose
    private String pAddress;
    @SerializedName("bath_room")
    @Expose
    private Integer bathRoom;
    @SerializedName("property_type")
    @Expose
    private Integer propertyType;
    @SerializedName("construction_status")
    @Expose
    private Integer constructionStatus;
    @SerializedName("furnish_type")
    @Expose
    private Integer furnishType;
    @SerializedName("building_type")
    @Expose
    private Integer buildingType;
    @SerializedName("image_path")
    @Expose
    private String imagePath;


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

    public Integer getParking() {
        return parking;
    }

    public void setParking(Integer parking) {
        this.parking = parking;
    }

    public List<List<Object>> getImages() {
        return images;
    }

    public void setImages(List<List<Object>> images) {
        this.images = images;
    }

    public Integer getBalcony() {
        return balcony;
    }

    public void setBalcony(Integer balcony) {
        this.balcony = balcony;
    }

    public Integer getBathRoom() {
        return bathRoom;
    }

    public void setBathRoom(Integer bathRoom) {
        this.bathRoom = bathRoom;
    }

    public Integer getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(Integer propertyType) {
        this.propertyType = propertyType;
    }

    public Integer getFurnishType() {
        return furnishType;
    }

    public void setFurnishType(Integer furnishType) {
        this.furnishType = furnishType;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
