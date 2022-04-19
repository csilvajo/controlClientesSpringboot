package cl.multiverso.spring.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;


/**
 * Clase de entidad que mapea la tabla persona
 *
 * @author saturno
 */
@Entity//anotacion de hibernate que convierte la clase en una entidad
@Data//anotacion de lombok que genera los metodos que transforman la clase en un bean
@Table(name = "persona")//anotacion que permite hacer la coneversion de nombres de tabla tal cual aparece en la BD
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//anotacion que me indica que la generacion del Id es autoincrementable
    private Long idPersona;
    @NotEmpty//anotacion que indica que el campo no puede estar vacio (para cadenas)
    private String nombre;
    @NotEmpty
    private String apellido;
    @NotEmpty
    @Email
    private String email;
    private String telefono;
    @NotNull//anotacion que indica que el campo no puede estar vacio (para numerios)
    private int saldo;

}//fin clase
