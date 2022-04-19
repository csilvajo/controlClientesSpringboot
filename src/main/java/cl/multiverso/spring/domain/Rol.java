package cl.multiverso.spring.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

/**
 * Clase que mapea la tabla de Rol
 *
 * @author saturno
 */
@Entity//anotacion de hibernate que convierte la clase en una entidad
@Data//anotacion de lombok que genera los metodos que transforman la clase en un bean
@Table(name = "rol")//anotacion que permite hacer la coneversion de nombres de tabla tal cual aparece en la BD
public class Rol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//anotacion que me indica que la generacion del Id es autoincrementable
    private Long idRol; 
    @NotEmpty//anotacion que indica que el campo no puede estar vacio
    private String nombreRol;

}//fin clase
