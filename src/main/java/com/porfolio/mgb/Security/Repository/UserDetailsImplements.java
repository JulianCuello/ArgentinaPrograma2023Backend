package com.porfolio.mgb.Security.Repository;

import com.porfolio.mgb.Security.Entity.Usuario;
import com.porfolio.mgb.Security.Entity.UsuarioPrincipal;
import com.porfolio.mgb.Security.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsImplements implements UserDetailsService {
    @Autowired
    UsuarioService usuarioService;


    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.getByNombreUsuario (nombreUsuario).get();
        return UsuarioPrincipal.build(usuario);
    }
}

