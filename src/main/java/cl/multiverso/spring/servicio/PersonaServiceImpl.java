package cl.multiverso.spring.servicio;

import cl.multiverso.spring.dao.IPersonaDao;
import cl.multiverso.spring.domain.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service//anotacion que permite a Spring reconocer la clase, como clase de servicio
public class PersonaServiceImpl implements IPersonaService{

    @Autowired//anotacion que inyecta la capa de datos
    private IPersonaDao objPersonaDao;
    
    @Override
    @Transactional(readOnly = true)    
    public List<Persona> listarPersonas() {
        return  (List<Persona>)objPersonaDao.findAll();        
    }

    @Override
    @Transactional//anotacion que permite efectuar un commit o rollback
    public void guardarPersona(Persona objPersona) {
        objPersonaDao.save(objPersona);
    }

    @Override
    @Transactional//anotacion que permite efectuar un commit o rollback
    public void eliminarPersona(Persona objPersona) {
        objPersonaDao.delete(objPersona);
    }

    @Override
    @Transactional(readOnly = true)
    public Persona encontrarPersona(Persona objPersona) {
        return objPersonaDao.findById(objPersona.getIdPersona()).orElse(null);
    }
    
}//fin clase
