package com.devappron.backendjava.controllers;


import javax.validation.Valid;

import com.devappron.backendjava.models.peticiones.UsuarioRegistrarRequestModel;
import com.devappron.backendjava.models.respuestas.UsuarioRestModel;
import com.devappron.backendjava.services.IUsuarioService;
import com.devappron.backendjava.shared.UsuarioCrearDto;
import com.devappron.backendjava.shared.UsuarioDto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios") 
public class UsuarioController {

    @Autowired
    ModelMapper modelmapper;

    @Autowired
    IUsuarioService iUsuarioServicio;

    @GetMapping(produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public UsuarioRestModel obtenerUsuario(){

        Authentication authentication =SecurityContextHolder.getContext().getAuthentication();

        String userName= authentication.getPrincipal().toString();

        UsuarioDto usuarioDto= iUsuarioServicio.obtenerUsuario(userName);

        UsuarioRestModel usuarioRestModel=modelmapper.map(usuarioDto, UsuarioRestModel.class);

        return usuarioRestModel;
    }

    @PostMapping
    public UsuarioRestModel crearUsuario(@RequestBody @Valid UsuarioRegistrarRequestModel usuarioRegistroRequestModel){
       
        UsuarioCrearDto usuarioCrearDto= modelmapper.map(usuarioRegistroRequestModel, UsuarioCrearDto.class);
        
        UsuarioDto usuarioDto= iUsuarioServicio.crearUsuario(usuarioCrearDto);

        UsuarioRestModel usuarioRestModel= modelmapper.map(usuarioDto, UsuarioRestModel.class);

        return usuarioRestModel;
    }
}

    
