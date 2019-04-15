package com.example.lenovo.stockdarahindonesia;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.Serializable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashScreen2 extends AppCompatActivity {
    private ApiInterface apiInterface;
    DataDarahLengkap dataDarahLengkap;
    private DataStok dataStok=new DataStok();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen2);
        new AmbilDataStok().execute();
    }
    public class AmbilDataStok extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            Intent intent=getIntent();
            dataDarahLengkap= (DataDarahLengkap) intent.getSerializableExtra("darahnya");
            String gol = dataDarahLengkap.getGolnya().toString().trim();
            String produk = dataDarahLengkap.getProduknya().toString().trim();
            String provinsi = dataDarahLengkap.getProvinsinya().toString().trim();
            apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
            Call<DataStok> dataStokCall = apiInterface.getStokDarah(gol, produk, provinsi);
            dataStokCall.enqueue(new Callback<DataStok>() {
                @Override
                public void onResponse(Call<DataStok> call, Response<DataStok> response) {
                    dataStok = response.body();
                    Intent intent = new Intent(SplashScreen2.this, StokActivity.class);
                    intent.putExtra("datanya", (Serializable) dataStok);
                    startActivity(intent);
                    finish();
                }

                @Override
                public void onFailure(Call<DataStok> call, Throwable t) {

                }
            });
            return null;
        }


        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }
}
