package com.company;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CompanyType {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name_short")
    @Expose
    private String nameShort;
    @SerializedName("name_full")
    @Expose
    private String nameFull;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameShort() {
        return nameShort;
    }

    public void setNameShort(String nameShort) {
        this.nameShort = nameShort;
    }

    public String getNameFull() {
        return nameFull;
    }

    public void setNameFull(String nameFull) {
        this.nameFull = nameFull;
    }

}
