package com.devappron.backendjava.data.entidades;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;



@Entity(name = "reservas")
@EntityListeners(AuditingEntityListener.class)
@Table(indexes = {
    @Index(columnList = "reservaId", name="index_reservaId", unique = true) 
})

public class ReservaEntity implements Serializable{
    
    private static final long serialVersionUID= 1L;
    
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String reservaId;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String unidad;

    @Column(nullable = false)
    private String apto;

    @Column(nullable = false)
    private String zona;
    
    @Column(nullable = false)
    private Date fecha;
    
    
    @Column(nullable = false)
    private Time  horaini;

    @Column(nullable = false)
    private Time  horafin;
    

    @CreatedDate
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UsuarioEntity usuarioEntity;

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

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public UsuarioEntity getUsuarioEntity() {
        return this.usuarioEntity;
    }

    public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
        this.usuarioEntity = usuarioEntity;
    }







    


    
    



    
}
