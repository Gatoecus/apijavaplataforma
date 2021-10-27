package com.devappron.backendjava.models.peticiones;

import javax.validation.constraints.NotEmpty;

public class ReservaEliminarRequestModel {
    
    @NotEmpty(message="El numero de reserva no puede estar vacio")
    private String reservaId ;


    


    public String getReservaId() {
        return this.reservaId;
    }

    public void setReservaId(String reservaId) {
        this.reservaId = reservaId;
    }
}