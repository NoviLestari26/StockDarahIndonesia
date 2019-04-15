package com.example.lenovo.stockdarahindonesia;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataStok {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("data")
    @Expose
    private List<LokasiStok> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<LokasiStok> getData() {
        return data;
    }

    public void setData(List<LokasiStok> data) {
        this.data = data;
    }
}
