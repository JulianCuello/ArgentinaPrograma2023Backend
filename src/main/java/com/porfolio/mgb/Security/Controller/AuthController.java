package com.porfolio.mgb.Security.Controller;

import com.porfolio.mgb.Security.Entity.Rol;
import com.porfolio.mgb.Security.Enums.RolNombre;
import com.porfolio.mgb.Security.Service.RolService;
import com.porfolio.mgb.Security.Service.UsuarioService;
import com.porfolio.mgb.Security.jwt.JwtProvider;
import com.sun.javafx.scene.control.Logging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;

@RestController
@RequestMapping("/auth")
@CrossOrigin

@PostMapping("/nuevo")
public class AuthController {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager AuthenticationManager;
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    RolService rolService;
    @Autowired
    JwtProvider jwtProvider;

     public ResponseEntity <?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult) {
         if (bindingResult.hasErrors()) ;
         return new ResponseEntity(new Mensaje("Campos mal puestos o email invalido"), HttpStatus.BAD_REQUEST);

         if (usuarioService.existByNombreUsuario(nombreUsuario.getNombreUsuario()))
             return new ResponseEntity(new Mensaje("Este nombre de usuario ya existe"), HttpStatus.BAD_REQUEST);

         if (usuarioService.existByEmail(nombreUsuario.getEmail()))
             return new ResponseEntity(new Mensaje("Este email ya existe"), HttpStatus.BAD_REQUEST);

         Usuario usuario= new Usuario(nuevoUsuario.getNombre(), nuevoUsuario.getNombreUsuario(),nuevoUsuario.getEmail(), passwordEncoder, encode (nuevoUsuario.getPassword()));

         Set<Rol>roles= new HashSet<>();
         roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());

         if (nuevoUsuario.getRoles().contains("admin"))
             roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
             usuario.setRoles(roles);
             usuarioService.save(usuario);
             return new ResponseEntity(new ,Mensaje("Usuario guardado").HttpStatus.CREATE);

     }l
     public ResponseEntity<JwtDTO> login(@Valid @Requestbody LogginUsuario logginUsuario,BindingResult bindingResult){
         if(bindingResult.hasErrors())
             return new ResponseEntity(new Mensaje (" error en los campos"), HttpStatus.BAD_REQUEST);
    }
}
