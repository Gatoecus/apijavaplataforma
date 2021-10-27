package com.devappron.backendjava.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.devappron.backendjava.data.entidades.ReservaEntity;
import com.devappron.backendjava.data.entidades.UsuarioEntity;
import com.devappron.backendjava.data.repositorios.IReservaRepository;
import com.devappron.backendjava.data.repositorios.IUsuarioRepository;
import com.devappron.backendjava.shared.ReservaActualizarDto;
import com.devappron.backendjava.shared.ReservaCrearDto;
import com.devappron.backendjava.shared.ReservaDto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaService implements IReservaService{

    @Autowired
    ModelMapper modelmapper;

    @Autowired
    IUsuarioRepository iUsuarioRepository;

    @Autowired
    IReservaRepository iReservaRepository;

    @Override
    public ReservaDto crearReserva(ReservaCrearDto reservaCrearDto) {

        UsuarioEntity usuarioEntity = iUsuarioRepository.findByUserName(reservaCrearDto.getUserName());

        ReservaEntity reservaEntity= new ReservaEntity();
        reservaEntity.setReservaId(UUID.randomUUID().toString());
        reservaEntity.setNombre(reservaCrearDto.getNombre());
        reservaEntity.setEmail(reservaCrearDto.getEmail());
        reservaEntity.setUnidad(reservaCrearDto.getUnidad());
        reservaEntity.setApto(reservaCrearDto.getApto());
        reservaEntity.setFecha(reservaCrearDto.getFecha());
        reservaEntity.setHoraini(reservaCrearDto.getHoraini());
        reservaEntity.setHorafin(reservaCrearDto.getHorafin());
        reservaEntity.setUsuarioEntity(usuarioEntity);

        ReservaEntity reservaCreado= iReservaRepository.save(reservaEntity);
     
        ReservaDto reservaDto= modelmapper.map(reservaCreado, ReservaDto.class);            
        
        return reservaDto;
    }
    @Override
    public List<ReservaDto> obtenerUltimos() {
        
        List<ReservaEntity> reservaEntityList= iReservaRepository.getUltimosReservas();

        List<ReservaDto> reservaDtoList=new ArrayList<>();

        for(ReservaEntity reservaEntity: reservaEntityList){
            ReservaDto reservaDto=modelmapper.map(reservaEntity, ReservaDto.class);
            reservaDtoList.add(reservaDto);
        }

        return reservaDtoList;
    }
    @Override
    public ReservaDto obtenerReserva (String id) {

        ReservaEntity reservaEntity= iReservaRepository.findByReservaId(id);

        ReservaDto postDto= modelmapper.map(reservaEntity, ReservaDto.class);

        return postDto;
    }
    @Override
    public void eliminarReserva(String reservaId, long usuarioId) {
       
        ReservaEntity partidoEntity= iReservaRepository.findByReservaId(reservaId);

        if(partidoEntity.getUsuarioEntity().getId() != usuarioId){
            throw new  RuntimeException("No se puede eliminar esta reserva");
        }

        iReservaRepository.delete(partidoEntity);        
    }
    @Override
    public ReservaDto actualizarReserva(String reservaId, ReservaActualizarDto reservaActualizarDto) {
        
        ReservaEntity reservaEntity = iReservaRepository.findByReservaId(reservaId);

        UsuarioEntity usuarioEntity= iUsuarioRepository.findByUserName(reservaActualizarDto.getUserName());

        if(reservaEntity.getUsuarioEntity().getId() != usuarioEntity.getId()){
            throw new RuntimeException("No se puede realizar esta acccion");
        }

        reservaEntity.setFecha(reservaActualizarDto.getFecha());
        reservaEntity.setHoraini(reservaActualizarDto.getHoraini());
        reservaEntity.setHorafin(reservaActualizarDto.getHorafin());

        ReservaEntity reservaEntityActualizado= iReservaRepository.save(reservaEntity);

        ReservaDto reservaDto=modelmapper.map(reservaEntityActualizado, ReservaDto.class);

        return reservaDto;
    }
    
    
    
    
    
    












    
}
