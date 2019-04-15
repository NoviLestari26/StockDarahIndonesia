package com.example.lenovo.stockdarahindonesia;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {


    @GET("exec?service=AKfycbxENZUqbOHUz7c7CevxlMJMkjxRMtP5rRim-SjFwcLSO9UDiBk")
    Call <Darah> getAll();


    @GET("exec?service=AKfycbxENZUqbOHUz7c7CevxlMJMkjxRMtP5rRim-SjFwcLSO9UDiBk")
    Call<DataStok> getStokDarah(@Query("gol") String gol ,@Query("produk") String produk,@Query("provinsi") String provinsi);
}

