package com.example.lenovo.stockdarahindonesia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
   TextView test;
    private ApiInterface apiInterface;
    private Darah darah;
    Data data;
    List<Golongan> gols;
    List<Provinsi> provs;
    List<Produk> prods;
    List<String> golnya=new ArrayList<>();
    List<String> produknya=new ArrayList<>();
    List<String> provnya=new ArrayList<>();
    Spinner spinner,spinner2,spinner3;
    private List<Golongan> golongan;
    DataDarahLengkap dataDarahLengkap;
    String golongannya,produknyaa,provinsinya;
    Button btnCari;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        test=(TextView)findViewById(R.id.dsti);
        spinner = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner3 = (Spinner) findViewById(R.id.spinner3);
        final ArrayAdapter<String> adapter= new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,golnya);
        final ArrayAdapter<String> adapter2= new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,produknya);
        final ArrayAdapter<String> adapter3= new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,provnya);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        adapter3.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner2.setAdapter(adapter2);
        spinner3.setAdapter(adapter3);

        List<String> list= Arrays.asList(getResources().getStringArray(R.array.names));
        List<String> list1= Arrays.asList(getResources().getStringArray(R.array.namess));
        List<String> list2= Arrays.asList(getResources().getStringArray(R.array.namesss));
        apiInterface=ApiClient.getApiClient().create(ApiInterface.class);
        Call<Darah> call = apiInterface.getAll();
        call.enqueue(new Callback<Darah>() {
            @Override
            public void onResponse(Call<Darah> call, Response<Darah> response) {
                darah=response.body();
                data=darah.getData();
                golongan=data.getGol();
                int ukuran=golongan.size();
                for (int i=0;i<ukuran;i++){
                    golnya.add(golongan.get(i).getValue());
                    adapter.notifyDataSetChanged();
                }
                prods=data.getProduk();
                int ukuranProd=prods.size();
                for (int a=0;a<ukuranProd;a++){
                    produknya.add(prods.get(a).getContent());
                    adapter2.notifyDataSetChanged();
                }
                provs=data.getProvinsi();
                int ukuranProv=provs.size();
                for (int b=0;b<ukuranProv;b++){
                    provnya.add(provs.get(b).getContent());
                    adapter3.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<Darah> call, Throwable t) {

            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                golongannya=spinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                produknyaa=spinner2.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                provinsinya=spinner3.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        btnCari=(Button)findViewById(R.id.btn_cari);
        btnCari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataDarahLengkap=new DataDarahLengkap();
                dataDarahLengkap.setGolnya(golongannya);
                dataDarahLengkap.setProduknya(produknyaa);
                dataDarahLengkap.setProvinsinya(provinsinya);
                Intent intent=new Intent(MainActivity.this,SplashScreen2.class);
                intent.putExtra("darahnya",dataDarahLengkap);
                startActivity(intent);
            }
        });

    }
}
