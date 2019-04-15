package com.example.lenovo.stockdarahindonesia;

import java.io.Serializable;

public class DataDarahLengkap implements Serializable {
    String golnya;
    String produknya;
    String provinsinya;

    public String getGolnya() {
        return golnya;
    }

    public void setGolnya(String golnya) {
        this.golnya = golnya;
    }

    public String getProduknya() {
        return produknya;
    }

    public void setProduknya(String produknya) {
        this.produknya = produknya;
    }

    public String getProvinsinya() {
        return provinsinya;
    }

    public void setProvinsinya(String provinsinya) {
        this.provinsinya = provinsinya;
    }
}
