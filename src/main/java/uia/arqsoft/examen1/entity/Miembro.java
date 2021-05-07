package uia.arqsoft.examen1.entity;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Clase Miembro, con los métodos getters y setters correspondientes.
 * Con la anotación @Entity Se le manda a Spring que va a ser MVC.
 * Con la anotación @Table Se le manda a Spring que es una tabla de la base
 * de datos a usar.
 */
@Entity
@Data
@Table(name = "miembro")
public class Miembro implements Serializable {

    private static final long serialVersionUID = 1L;

    // Llave primaria idMiembro AI.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMiembro;

    // Columna de la tabla de base de datos = nombre_miembro.
    @NotBlank(message = "Escriba un nombre")
    @Column(name = "nombre_miembro")
    private String nombreMiembro;

    // Columna de la tabla de base de datos = apellido_paterno.

    @Column(name = "apellido_paterno")
    @NotBlank(message = "Escriba un apellido")
    private String apellidoPaterno;

    // Columna de la tabla de base de datos = apellido_materno.

    @NotBlank(message = "Escriba un apellido materno")
    @Column(name = "apellido_materno")
    private String apellidoMaterno;

    // Columna de la tabla de base de datos = peso_miembro.

    @Column(name = "peso_miembro")
    private Integer pesoMiembro;

    // Columna de la tabla de base de datos = edad_miembro.

    @Column(name = "edad_miembro")
    private Integer edadMiembro;

    // Columna de la tabla de base de datos = correo_miembro.

    @Column(name = "correo_miembro")
    private String correoMiembro;

    // Columna de la tabla de base de datos = contrasenia.

    @Column(name = "contrasenia")
    private String contraseniaMiembro;

    // Columna de la tabla de base de datos = telefono_miembro.
    @Column(name = "telefono_miembro")
    private Integer telefonoMiembro;

    // Columna de prueba.
    @Column(name = "authority")
    private String autoridad;

    // Columna de la tabla de base de datos = id_direccion_fk.

    @Column(name = "id_direccion_fk")
    private Long idDireccion;

    // Columna de la tabla de base de datos = id_universidad_fk.

    @Column(name = "id_universidad_fk")
    private Long idUniversidad;
}
