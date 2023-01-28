package com.porfolio.mgb.Interface;


import com.porfolio.mgb.entity.Persona;
import java.util.List;

public interface IPersonaService {
    //traer una persona

    public List<Persona>GetPersona();

    //Guardar una persona
    public void savePersona (Persona persona);

    //Eliminar una persona
    public void deletePersona (Long id);

    //buscar una persona por id
    public Persona findPersona (Long id);

}
