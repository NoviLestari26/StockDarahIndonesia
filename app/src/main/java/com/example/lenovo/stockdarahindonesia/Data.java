package com.example.lenovo.stockdarahindonesia;

import java.util.List;

public class Data {
    private List<Golongan> gol;
    private List<Provinsi> provinsi;
    private List<Produk>produk;

    public List<Golongan> getGol() {
        return gol;
    }

    public void setGolongans(List<Golongan> gol) {
        this.gol = gol;
    }

    public List<Provinsi> getProvinsi() {
        return provinsi;
    }

    public void setProvinsi (List<Provinsi> provinsi) {
        this.provinsi= provinsi;
    }

    public List<Produk> getProduk() {
        return produk;
    }

    public void setProduk(List<Produk> produk) {
        this.produk = produk;
    }
}
