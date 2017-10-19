package com.example.camilo_pc.vacunacionpenta.datosApi;

import com.example.camilo_pc.vacunacionpenta.Models.Vacunacion;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by CAMILO-PC on 19/10/2017.
 */

public interface Datos {

    @GET("r736-gft5.json")
    Call<List<Vacunacion>> obtenerListaVacuna();
}
