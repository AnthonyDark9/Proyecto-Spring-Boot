package uia.arqsoft.examen1.entity;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * Clase Cliente.
 * Con la anotación @Data La anotación de lombok tiene como propósito
 * evitar el Boilerplate o código repetitivo.
 * Con la anotación @Entity Se le manda a Spring que va a ser MVC.
 * Con la anotación @Table Se le manda a Spring que es una tabla de la base
 * de datos a usar.
 */
@Entity
@Data
@Table(name = "cliente")
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;

    // Llave primaria y AI.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long idCliente;

    // Columna de la tabla de base de datos = username.
    @NotEmpty
    @Column(name = "username")
    private String nombreUsuario;

    // Columna de la tabla de base de datos = contrasenia.
    @NotEmpty
    @Column(name = "contrasenia")
    private String contraseniaUsuario;

    // Columna de la tabla de base de datos = nombre_cliente.
    @Column(name = "nombre_cliente")
    @NotEmpty
    private String nombreCliente;

    // Columna de la tabla de base de datos = apellido_paterno_cliente.
    @NotEmpty
    @Column(name = "apellido_paterno_cliente")
    private String apellidoPaterno;

    // Columna de la tabla de base de datos = apellido_materno_cliente.
    @NotEmpty
    @Column(name = "apellido_materno_cliente")
    private String apellidoMaterno;

    // Columna de la tabla de base de datos = numero_folio.
    @NotEmpty
    @Column(name = "numero_folio")
    private String numeroFolio;

    // Columna de la tabla de base de datos = id_empresa_externa_fk.
    @ManyToOne
    @JoinColumn(name = "id_empresa_externa_fk", referencedColumnName = "id_empresa_externa")
    private EmpresaExterna empresaExterna;
}
