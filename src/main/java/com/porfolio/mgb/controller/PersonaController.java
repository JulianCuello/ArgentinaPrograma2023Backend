package com.porfolio.mgb.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import com.porfolio.mgb.Interface.IPersonaService;
import com.porfolio.mgb.entity.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@CrossOrigin(origins ="http://localhost:4200")

public class PersonaController {
    @Autowired IPersonaService iPersonaService;

    @GetMapping("personas/traer")
    public List<Persona> getPersona(){

        return iPersonaService.GetPersona();
    }
    @PostMapping ("/personas/crear")
    public String createPersona (@RequestBody Persona persona) {
        iPersonaService.savePersona(persona);
                return "la persona fue creada correctamente";
    }
    @DeleteMapping("/personas/borrar(id)")
    public String deletePersona(@PathVariable Long id){
        iPersonaService.deletePersona(id);
        return "la persona fue eliminada correctamente";
    }

    @PutMapping ("/personas/editar/(id)")
        public Persona editPersona(@PathVariable Long id,
                                   @RequestParam ("nombre") String nuevoNombre,
                                   @RequestParam ("apellido") String nuevoApellido,
                                   @RequestParam ("img") String nuevoImg) {

        Persona persona =iPersonaService.findPersona(id);
                persona.setNombre(nuevoNombre);
                persona.setApellido(nuevoApellido);
                persona.setImg(nuevoImg);

        iPersonaService.savePersona(persona);
        return persona;

    }
}
