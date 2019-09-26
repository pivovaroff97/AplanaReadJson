package com.company;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.time.LocalDate;

public class Security {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("name_full")
    @Expose
    private String nameFull;
    @SerializedName("cfi")
    @Expose
    private String cfi;
    @SerializedName("date_to")
    @Expose
    private String dateTo;
    @SerializedName("state_reg_date")
    @Expose
    private String stateRegDate;
    @SerializedName("state")
    @Expose
    private State state;
    @SerializedName("currency")
    @Expose
    private Currency currency;

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

    public String getCfi() {
        return cfi;
    }

    public void setCfi(String cfi) {
        this.cfi = cfi;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    public String getStateRegDate() {
        return stateRegDate;
    }

    public void setStateRegDate(String stateRegDate) {
        this.stateRegDate = stateRegDate;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public boolean isBefore(LocalDate datenow, LocalDate dateSecur) {
        return datenow.isAfter(dateSecur);
    }

    @Override
    public String toString() {
        return "Security " +
                "id = " + id +
                " code = '" + getCurrency().getCode() + '\'' +
                ", дата истечения " + dateTo +
                ", " + nameFull;
    }
}
