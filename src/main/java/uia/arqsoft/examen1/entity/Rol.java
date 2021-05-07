package uia.arqsoft.examen1.entity;
import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

/**
 * Clase Rol.
 * Con la anotación @Data La anotación de lombok tiene como propósito
 * evitar el Boilerplate o código repetitivo.
 * Con la anotación @Entity Se le manda a Spring que va a ser MVC.
 * Con la anotación @Table Se le manda a Spring que es una tabla de la base
 * de datos a usar.
 */
@Entity
@Data
@Table(name = "rol")
public class Rol implements Serializable {
    private static long serialVersionUID = 1L;

    // ID autoincremental.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private Long idRol;

    // Columna referenciada a nombre.
    @Column(name = "nombre")
    private String nombre;
}
