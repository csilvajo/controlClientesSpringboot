package cl.multiverso.spring.dao;

import cl.multiverso.spring.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface que genera los metodos mas comunes de manejo con BD, como es el
 * CRUD
 * @author saturno
 */
public interface IPersonaDao extends JpaRepository<Persona, Long>{
    
}//fin interface
