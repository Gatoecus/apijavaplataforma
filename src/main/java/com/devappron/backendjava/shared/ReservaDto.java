package com.devappron.backendjava.shared;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

public class ReservaDto implements Serializable{
    private static final long serialVersionUID= 1L;

    private long id;
    private String reservaId;
    private String nombre;
    private String email;
    private String unidad;
    private String apto;
    private String zona;
    private Date fecha;
    private Time horaini;
    private Time horafin;
    private Date createdAt;    
    private UsuarioDto usuarioDto;

    public String getUnidad() {
        return this.unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getReservaId() {
        return this.reservaId;
    }

    public void setReservaId(String reservaId) {
        this.reservaId = reservaId;
    }

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

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public UsuarioDto getUsuarioDto() {
        return this.usuarioDto;
    }

    public void setUsuarioDto(UsuarioDto usuarioDto) {
        this.usuarioDto = usuarioDto;
    }

    

    
}
