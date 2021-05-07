package uia.arqsoft.examen1.entity;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

/**
 * Clase Universidad.
 * Con la anotación @Data La anotación de lombok tiene como propósito
 * evitar el Boilerplate o código repetitivo.
 * Con la anotación @Entity Se le manda a Spring que va a ser MVC.
 * Con la anotación @Table Se le manda a Spring que es una tabla de la base
 * de datos a usar.
 */
@Entity
@Data
@Table(name = "universidad")
public class Universidad implements Serializable {
    private static final long serialVersionUID = 1L;

    // ID Autoincremental.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_universidad")
    private Long idUniversidad;

    // Columna referenciada a name = nombre_plantel
    @NotEmpty
    @Column(name = "nombre_plantel")
    private String nombrePlantel;

    // Columna referenciada a name = ubicacion_plantel
    @NotEmpty
    @Column(name = "ubicacion_plantel")
    private String ubicacionPlantel;

    // Uno a muchos, mapeado por la tabla universidad. 1 -> *.
    @OneToMany(mappedBy = "universidad", cascade = CascadeType.ALL)
    private List<Departamento> departamentos;

    @OneToMany(mappedBy = "universidad", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RegistroProyecto> registroProyectos;
}
