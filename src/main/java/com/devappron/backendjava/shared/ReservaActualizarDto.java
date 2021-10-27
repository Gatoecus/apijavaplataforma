package com.devappron.backendjava.shared;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

public class ReservaActualizarDto implements Serializable{
    private static final long serialVersionUID= 1L;

    private Date fecha;
    private Time horaini;
    private Time horafin;
    private String userName;

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

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    


}
