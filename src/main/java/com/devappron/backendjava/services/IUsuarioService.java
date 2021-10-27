package com.devappron.backendjava.services;



import com.devappron.backendjava.shared.UsuarioCrearDto;
import com.devappron.backendjava.shared.UsuarioDto;

import org.springframework.security.core.userdetails.UserDetailsService;


public interface IUsuarioService extends UserDetailsService{

    public UsuarioDto crearUsuario(UsuarioCrearDto usuarioCrearDto);
    public UsuarioDto obtenerUsuario(String userName);
    
}
