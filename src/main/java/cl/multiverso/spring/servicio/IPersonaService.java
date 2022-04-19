package cl.multiverso.spring.servicio;

import cl.multiverso.spring.domain.Persona;
import java.util.List;

public interface IPersonaService {

    public List<Persona> listarPersonas();

    public void guardarPersona(Persona objPersona);

    public void eliminarPersona(Persona objPersona);

    public Persona encontrarPersona(Persona objPersona);
    
}//fin interface
