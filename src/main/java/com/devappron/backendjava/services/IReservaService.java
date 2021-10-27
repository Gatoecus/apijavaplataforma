package com.devappron.backendjava.services;

import java.util.List;

import com.devappron.backendjava.shared.ReservaActualizarDto;
import com.devappron.backendjava.shared.ReservaCrearDto;
import com.devappron.backendjava.shared.ReservaDto;

public interface IReservaService {

    public ReservaDto crearReserva(ReservaCrearDto reservaCreacionDto);

    public List<ReservaDto> obtenerUltimos();

    public ReservaDto obtenerReserva(String id);

    public void eliminarReserva(String reservaId, long usuarioId);

    public ReservaDto actualizarReserva(String reservaId, ReservaActualizarDto reservaActualizarDto);
    
    
}
