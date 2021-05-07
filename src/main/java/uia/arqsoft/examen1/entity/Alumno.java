package uia.arqsoft.examen1.entity;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * Clase Alumno
 * Con la anotación @Data La anotación de lombok tiene como propósito
 * evitar el Boilerplate o código repetitivo.
 * Con la anotación @Entity Se le manda a Spring que va a ser MVC.
 * Con la anotación @Table Se le manda a Spring que es una tabla de la base
 * de datos a usar.
 */
@Entity
@Data
@Table(name = "alumnos")
public class Alumno {
    private static final long serialVersionUID = 1L;

    // LLave primaria
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAlumno;

    // Nombre en la base de datos = nombre_alumno
    @Column(name = "nombre_alumno")
    private String nombreAlumno;

    // Nombre en la base de datos = apellido_paterno
    @NotBlank(message = "Escriba un apellido")
    @Column(name = "apellido_paterno")
    private String apellidoPaterno;

    //Nombre en la base de datos apellido_materno
    @NotBlank(message = "Escriba un nombre")
    @Column(name = "apellido_materno")
    private String apellidoMaterno;

    // nombre en la base de datos calificacion_alumno
    @Column(name = "calificacion_alumno")
    private Float calificacionAlumno;
}
