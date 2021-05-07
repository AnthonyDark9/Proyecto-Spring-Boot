package uia.arqsoft.examen1.entity;
import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * Clase Proyecto.
 * Con la anotación @Data La anotación de lombok tiene como propósito
 * evitar el Boilerplate o código repetitivo.
 * Con la anotación @Entity Se le manda a Spring que va a ser MVC.
 * Con la anotación @Table Se le manda a Spring que es una tabla de la base
 * de datos a usar.
 */
@Entity
@Data
@Table(name = "proyecto")
public class Proyecto implements Serializable {
    private static final long serialVersionUID = 1L;

    // Nombre en la base de datos id_proyecto
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proyecto")
    private Long idProyecto;

    // Nombre en la base de datos nombre_proyecto
    @Column(name = "nombre_proyecto")
    private String nombreProyecto;

    // Nombre en la base de datos duracion_estimada_proyecto
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "duracion_estimada_proyecto")
    private Date duracionEstimadaProyecto;

    // Nombre en la base de datos fecha_inicio_prevista
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fecha_inicio_prevista")
    private Date fechaInicioPrevista;

    // Muchos a uno
    @ManyToOne
    @JoinColumn(name = "id_registro_proyecto_fk", referencedColumnName = "id_registro_proyecto")
    private RegistroProyecto registroProyecto;

    // Uno a muchos
    @OneToMany(mappedBy = "proyecto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Tarea> tareas;
}
