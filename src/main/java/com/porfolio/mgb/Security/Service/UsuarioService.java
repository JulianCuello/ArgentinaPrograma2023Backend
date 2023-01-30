package com.porfolio.mgb.Security.Service;

import com.porfolio.mgb.Security.Entity.Usuario;
import com.porfolio.mgb.Security.Repository.iUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    iUsuarioRepository usuariorepository;
    public Optional <Usuario>getByNombreUsuario(String nombreUsuario){
         return usuariorepository.findByNombreUsuario(nombreUsuario);
    }
    public boolean existByNombreUsuario (String nombreUsuario){
        return usuariorepository.existsByNombreUsuario(nombreUsuario);
    }
    public boolean existByEmail (String email){
        return usuariorepository.existsByEmail(email);
   }
    public void save (Usuario usuario){
       usuariorepository.save(usuario);
  }
}
