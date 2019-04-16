package com.example.lenovo.stockdarahindonesia;

import android.provider.ContactsContract;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterfaceDua {
    @GET("exec")
    Call<List<DataDarah>> getStokDarah(@Query("gol") String gol , @Query("produk") String produk, @Query("provinsi") String provinsi);
}
