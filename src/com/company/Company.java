package com.company;

import java.time.LocalDate;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Company {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("name_full")
    @Expose
    private String nameFull;
    @SerializedName("name_short")
    @Expose
    private String nameShort;
    @SerializedName("inn")
    @Expose
    private String inn;
    @SerializedName("company_type")
    @Expose
    private CompanyType companyType;
    @SerializedName("ogrn")
    @Expose
    private String ogrn;
    @SerializedName("egrul_date")
    @Expose
    private String egrulDate;
    @SerializedName("country")
    @Expose
    private Country country;
    @SerializedName("fio_head")
    @Expose
    private String fioHead;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("e_mail")
    @Expose
    private String eMail;
    @SerializedName("www")
    @Expose
    private String www;
    @SerializedName("is_resident")
    @Expose
    private Boolean isResident;
    @SerializedName("securities")
    @Expose
    private List<Security> securities = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNameFull() {
        return nameFull;
    }

    public void setNameFull(String nameFull) {
        this.nameFull = nameFull;
    }

    public String getNameShort() {
        return nameShort;
    }

    public void setNameShort(String nameShort) {
        this.nameShort = nameShort;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public CompanyType getCompanyType() {
        return companyType;
    }

    public void setCompanyType(CompanyType companyType) {
        this.companyType = companyType;
    }

    public String getOgrn() {
        return ogrn;
    }

    public void setOgrn(String ogrn) {
        this.ogrn = ogrn;
    }

    public String getEgrulDate() {
        return egrulDate;
    }

    public void setEgrulDate(String egrulDate) {
        this.egrulDate = egrulDate;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getFioHead() {
        return fioHead;
    }

    public void setFioHead(String fioHead) {
        this.fioHead = fioHead;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public String getWww() {
        return www;
    }

    public void setWww(String www) {
        this.www = www;
    }

    public Boolean getIsResident() {
        return isResident;
    }

    public void setIsResident(Boolean isResident) {
        this.isResident = isResident;
    }

    public List<Security> getSecurities() {
        return securities;
    }

    public void setSecurities(List<Security> securities) {
        this.securities = securities;
    }

    public boolean isBefore(LocalDate userDate, LocalDate egrulDate) {
        return userDate.isBefore(egrulDate);
    }

    @Override
    public String toString() {
        return "Company " +
                nameShort + " - " + egrulDate;
    }
}
