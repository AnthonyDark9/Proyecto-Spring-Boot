package uia.arqsoft.examen1.entity;
import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Clase Usuario.
 * Con la anotación @Data La anotación de lombok tiene como propósito
 * evitar el Boilerplate o código repetitivo.
 * Con la anotación @Entity Se le manda a Spring que va a ser MVC.
 * Con la anotación @Table Se le manda a Spring que es una tabla de la base
 * de datos a usar.
 */
@Entity
@Data
@Table(name = "usuario")
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    // Id Autoicremental
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    // Columna referenciada a name = username
    @Column(name = "username")
    private String username;

    // Columna referenciada a name = password.
    @Column(name = "password")
    private String password;

    // Uno a muchos, referenciada a la tabla de Rol. 1 -> *.
    @OneToMany
    @JoinColumn(name = "id_usuario_fk")
    private List<Rol> roles;
}
