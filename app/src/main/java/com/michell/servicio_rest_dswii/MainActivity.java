package com.michell.servicio_rest_dswii;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import Adapter.RVMainAdapter;
import Client.ApiClient;
import Entity.Persona;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements RVMainAdapter.RVMainAdapterListener {

    private RecyclerView rvMain;
    private RVMainAdapter mRVMainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvMain = (RecyclerView) findViewById(R.id.rvMain);
        rvMain.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        mRVMainAdapter = new RVMainAdapter(MainActivity.this);
        rvMain.setAdapter(mRVMainAdapter);

        ApiClient.getApiClient().getPersonas().enqueue(new Callback<List<Persona>>() {
            @Override
            public void onResponse(Call<List<Persona>> call, Response<List<Persona>> response) {
                List<Persona> lstPersonas = response.body();
                for (Persona p : lstPersonas) {
                    Log.d("SERVICIOS REST","Id: "+p.getId()+" - "+ p.getNombre()+" "+ p.getApellido()+"| edad: "+p.getEdad());
                    mRVMainAdapter.add(p);
                }
                rvMain.setAdapter(mRVMainAdapter);
            }

            @Override
            public void onFailure(Call<List<Persona>> call, Throwable t) {
                Log.d("Error","No hay Servicios Rest");
            }
        });

    }

    @Override
    public void onClickItem(Persona persona) {

    }
}
