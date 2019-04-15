package com.example.lenovo.stockdarahindonesia;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LokasiStok {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("unit")
    @Expose
    private String unit;
    @SerializedName("provinsi")
    @Expose
    private String provinsi;
    @SerializedName("jumlah")
    @Expose
    private String jumlah;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }
}
