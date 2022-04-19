package cl.multiverso.spring.dao;

import cl.multiverso.spring.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface que genera los metodos mas comunes de manejo con BD, como es el
 * CRUD
 *
 * @author saturno
 */
public interface IUsuarioDao extends JpaRepository<Usuario, Long> {

    Usuario findByUsername(String username);

}//fin interface
