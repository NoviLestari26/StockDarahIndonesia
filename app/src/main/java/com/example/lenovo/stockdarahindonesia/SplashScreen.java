package com.example.lenovo.stockdarahindonesia;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashScreen extends AppCompatActivity {
    private ApiInterface apiInterface;
    private Darah darah = new Darah();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new AmbilDataDarah().execute();

    }

    public class AmbilDataDarah extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
            Call<Darah> call = apiInterface.getAll();
            call.enqueue(new Callback<Darah>() {
                @Override
                public void onResponse(Call<Darah> call, Response<Darah> response) {
                    darah = response.body();
                    Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                    intent.putExtra("datanya", (Serializable) darah);
                    startActivity(intent);
                    finish();
                }

                @Override
                public void onFailure(Call<Darah> call, Throwable t) {

                }
            });
            return null;
        }
    }
}

