package com.devappron.backendjava.models.peticiones;

import java.sql.Time;
import java.util.Date;
import javax.validation.constraints.NotEmpty;

public class ReservaActualizarRequestModel {

    
    @NotEmpty(message="La fecha del evento no puede estar vacio")
    private Date fecha;

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

    @NotEmpty(message="La hora inicial del evento no puede estar vacio")
    private Time  horaini;

    @NotEmpty(message="La hora de terminacion del evento no puede estar vacio")
    private Time  horafin;


    
}
