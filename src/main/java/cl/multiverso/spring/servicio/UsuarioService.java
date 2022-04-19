package cl.multiverso.spring.servicio;

import cl.multiverso.spring.dao.IUsuarioDao;
import cl.multiverso.spring.domain.Rol;
import cl.multiverso.spring.domain.Usuario;
import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author saturno
 */
@Service("userDetailService")//anotacion de Spring que permite reconocer a esta clase como clase de servicio
@Slf4j
public class UsuarioService implements UserDetailsService {

    @Autowired
    private IUsuarioDao objIUsuarioDao;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        Usuario objUsuario = objIUsuarioDao.findByUsername(username);
        if (objUsuario == null) {
            throw new UsernameNotFoundException(username);
        }

        var roles = new ArrayList<GrantedAuthority>();
        for (Rol objRol : objUsuario.getListaRol()) {
            roles.add(new SimpleGrantedAuthority(objRol.getNombreRol()));
        }

        return new User(objUsuario.getUsername(), objUsuario.getPassword(), roles);
    }

}//fin interface
