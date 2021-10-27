package com.devappron.backendjava.controllers;

import java.util.ArrayList;
import java.util.List;


import javax.validation.Valid;

import com.devappron.backendjava.models.peticiones.ReservaActualizarRequestModel;
import com.devappron.backendjava.models.peticiones.ReservaCrearRequestModel;
import com.devappron.backendjava.models.respuestas.MensajeOperacionModel;
import com.devappron.backendjava.models.respuestas.ReservaRestModel;
import com.devappron.backendjava.services.IReservaService;
import com.devappron.backendjava.services.IUsuarioService;
import com.devappron.backendjava.shared.ReservaActualizarDto;
import com.devappron.backendjava.shared.ReservaCrearDto;
import com.devappron.backendjava.shared.UsuarioDto;
import com.devappron.backendjava.shared.ReservaDto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    ModelMapper modelmapper;

    @Autowired
    IReservaService iReservaService;

    @Autowired
    IUsuarioService iUsuarioService;

    
    @PostMapping
    public ReservaRestModel crearReserva(@RequestBody @Valid ReservaCrearRequestModel reservaCrearRequestModel){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String userName = authentication.getPrincipal().toString();

        ReservaCrearDto reservaCrearDto = modelmapper.map(reservaCrearRequestModel, ReservaCrearDto.class);
        reservaCrearDto.setUserName(userName);

        ReservaDto reservaDto= iReservaService.crearReserva ( reservaCrearDto);
        ReservaRestModel reservaRestModel= modelmapper.map(reservaDto, ReservaRestModel.class);

      

        return reservaRestModel;
    }

    @GetMapping(path="/ultimos")
    public List<ReservaRestModel> ultimosReservas(){
        
        List<ReservaDto> reservaDtoList=iReservaService.obtenerUltimos();

        List<ReservaRestModel> reservaRestModelList=new ArrayList<>();

        for(ReservaDto reservaDto : reservaDtoList){
            ReservaRestModel reservaRestModel= modelmapper.map(reservaDto, ReservaRestModel.class);
            reservaRestModelList.add(reservaRestModel);
        }

        return reservaRestModelList;
    }

    @GetMapping(path="/{id}")
    public ReservaRestModel obtenerReserva(@PathVariable String id){

        ReservaDto reservaDto= iReservaService.obtenerReserva(id);

        ReservaRestModel reservaRestModel = modelmapper.map(reservaDto, ReservaRestModel.class);

        // if(partidoRestModel.getFecha().compareTo(new Date(System.currentTimeMillis())) < 0 ){
        //     partidoRestModel.setJugado(true);
        // }

        return reservaRestModel;
    }

    @DeleteMapping(path="/{id}")
    public MensajeOperacionModel eliminarReserva(@PathVariable String id){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getPrincipal().toString();

        UsuarioDto usuarioDto= iUsuarioService.obtenerUsuario(username);

        MensajeOperacionModel mensajeOperacionModel= new MensajeOperacionModel();
        mensajeOperacionModel.setNombre("Eliminar");

        iReservaService.eliminarReserva(id, usuarioDto.getId());

        mensajeOperacionModel.setResultado("Exitoso");

        return mensajeOperacionModel;
    }

    @PutMapping(path = "/{id}")
    public ReservaRestModel actualizarReserva(@RequestBody @Valid ReservaActualizarRequestModel reservaActualizarRequestModel, @PathVariable String id){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getPrincipal().toString();

        ReservaActualizarDto reservaActualizarDto= modelmapper.map(reservaActualizarRequestModel, ReservaActualizarDto.class);
        reservaActualizarDto.setUserName(username);

        ReservaDto reservaDto= iReservaService.actualizarReserva(id, reservaActualizarDto);

        ReservaRestModel reservaRestModel = modelmapper.map(reservaDto, ReservaRestModel.class);

        return reservaRestModel;

    }
    
}
