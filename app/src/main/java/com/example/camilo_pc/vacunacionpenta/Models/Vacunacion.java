package com.example.camilo_pc.vacunacionpenta.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by CAMILO-PC on 19/10/2017.
 */

public class Vacunacion {


    @SerializedName("a_o")
    @Expose
    private String aO;
    @SerializedName("mes")
    @Expose
    private String mes;
    @SerializedName("municipio")
    @Expose
    private String municipio;
    @SerializedName("valor")
    @Expose
    private String valor;

    public String getAO() {
        return aO;
    }

    public void setAO(String aO) {
        this.aO = aO;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

}

