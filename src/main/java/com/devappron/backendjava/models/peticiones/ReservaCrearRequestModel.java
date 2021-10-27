package com.devappron.backendjava.models.peticiones;

import java.sql.Time;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

public class ReservaCrearRequestModel {

    @NotEmpty(message="El nombre del solicitante no puede estar vacio")
    private String nombre;

    @NotEmpty(message="El correo del solicitante no puede estar vacio")
    private String email;

    @NotEmpty(message="La unidad del solicitante no puede estar vacio")
    private String unidad;

    @NotEmpty(message="El apartamento del solicitante no puede estar vacio")
    private String apto;

    @NotEmpty(message="La zona de reserva no puede estar vacio")
    private String zona;
    
    @NotEmpty(message="La fecha del evento no puede estar vacio")
    private Date fecha;

    @NotEmpty(message="La hora inicial del evento no puede estar vacio")
    private Time  horaini;

    @NotEmpty(message="La hora de terminacion del evento no puede estar vacio")
    private Time  horafin;




    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUnidad() {
        return this.unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getApto() {
        return this.apto;
    }

    public void setApto(String apto) {
        this.apto = apto;
    }

    public String getZona() {
        return this.zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHoraini() {
        return this.horaini;
    }

    public void setHoraini(Time horaini) {
        this.horaini = horaini;
    }

    public Time getHorafin() {
        return this.horafin;
    }

    public void setHorafin(Time horafin) {
        this.horafin = horafin;
    }
    
    
    
    

    
}
