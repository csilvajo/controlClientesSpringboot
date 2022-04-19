package cl.multiverso.spring.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

/**
 * Clase que mapea la tabla de Usuario
 *
 * @author saturno
 */
@Entity//anotacion de hibernate que convierte la clase en una entidad
@Data//anotacion de lombok que genera los metodos que transforman la clase en un bean
@Table(name = "usuario")//anotacion que permite hacer la coneversion de nombres de tabla tal cual aparece en la BD
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//anotacion que me indica que la generacion del Id es autoincrementable
    private Long idUsuario;
    @NotEmpty//anotacion que indica que el campo no puede estar vacio
    private String username;
    @NotEmpty
    private String password;

    //se relaciona la Usuario con Rol
    @OneToMany//un usuario puede tener uno o varios roles
    @JoinColumn(name = "id_usuario")
    private List<Rol> listaRol;//lista que relaciona los roles asociados al usuario

}//fin clase
