package com.example.lenovo.stockdarahindonesia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StokActivity extends AppCompatActivity {
   public static String service="AKfycbxENZUqbOHUz7c7CevxlMJMkjxRMtP5rRim-SjFwcLSO9UDiBk";
    DataDarahLengkap dataDarahLengkap;
    ApiInterface apiInterface;
    DataStok dataStok;
    List<LokasiStok> data = new ArrayList<>();
    RecyclerView.LayoutManager layoutManager;
    RecyclerView recyclerView;
    StockRvAdapter stockRvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stok);
        recyclerView=(RecyclerView)findViewById(R.id.rv_darah);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        Intent intent=getIntent();
        dataDarahLengkap=(DataDarahLengkap)intent.getSerializableExtra("darahnya");
        String gol = dataDarahLengkap.getGolnya().toString().trim();
        String produk = dataDarahLengkap.getProduknya().toString().trim();
        String provinsi = dataDarahLengkap.getProvinsinya().toString().trim();
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<DataStok> dataStokCall=apiInterface.getStokDarah(gol,produk,provinsi);
        dataStokCall.enqueue(new Callback<DataStok>() {
            @Override
            public void onResponse(Call<DataStok> call, Response<DataStok> response) {
                dataStok = response.body();
                data=dataStok.getData();
                int jml=data.size();
                stockRvAdapter = new StockRvAdapter(data,StokActivity.this);
                recyclerView.setAdapter(stockRvAdapter);
            }

            @Override
            public void onFailure(Call<DataStok> call, Throwable t) {

            }
        });


    }
}
