package com.example.camilo_pc.vacunacionpenta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.camilo_pc.vacunacionpenta.Models.Adaptador;
import com.example.camilo_pc.vacunacionpenta.Models.Vacunacion;
import com.example.camilo_pc.vacunacionpenta.datosApi.Datos;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private Retrofit retrofit;
    public final static String TAG = "Datos Vacunacion Penta";

    private RecyclerView view;
    private Adaptador adaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view = (RecyclerView) findViewById(R.id.recy);
        view.setLayoutManager(new LinearLayoutManager(this));

        retrofit = new Retrofit.Builder().baseUrl("https://www.datos.gov.co/resource/").addConverterFactory(GsonConverterFactory.create()).build();

        obtenerDatos();

    }
    public void obtenerDatos() {

        Datos service = retrofit.create(Datos.class);
        final Call<List<Vacunacion>> vacunacionCall = service.obtenerListaVacuna();

        vacunacionCall.enqueue(new Callback<List<Vacunacion>>() {
            @Override
            public void onResponse(Call<List<Vacunacion>> call, Response<List<Vacunacion>> response) {

                if (response.isSuccessful()) {
                    List vacunacion = response.body();
                    for (int i = 0; i < vacunacion.size(); i++) {
                        Vacunacion ma = (Vacunacion) vacunacion.get(i);
                        adaptador = new Adaptador(vacunacion);
                        view.setAdapter(adaptador);

                    }
                } else {

                    Toast notificacion = Toast.makeText(MainActivity.this,"error",Toast.LENGTH_LONG);
                    notificacion.show();
                }
            }

            @Override
            public void onFailure(Call<List<Vacunacion>> call, Throwable t) {

                Toast notificacion = Toast.makeText(MainActivity.this,"error",Toast.LENGTH_LONG);
                notificacion.show();
            }
        });

    }
}
