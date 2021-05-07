package uia.arqsoft.examen1.entity;
import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * Clase RegistroProyecto.
 * Con la anotación @Data La anotación de lombok tiene como propósito
 * evitar el Boilerplate o código repetitivo.
 * Con la anotación @Entity Se le manda a Spring que va a ser MVC.
 * Con la anotación @Table Se le manda a Spring que es una tabla de la base
 * de datos a usar.
 */
@Entity
@Data
@Table(name = "registro_proyecto")
public class RegistroProyecto implements Serializable {
    private static final long serialVersionUID = 1L;

    // nombre en la base de datos id_registro_proyecto
    @Id
    @Column(name = "id_registro_proyecto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRegistroProyecto;

    // Nombre en la base de datos titulo_registro_proyecto
    @Column(name = "titulo_registro_proyecto")
    private String tituloRegistroProyecto;

    //Nombre en la base de datos descripcion_registro_proyectos
    @Column(name = "descripcion_registro_proyecto")
    private String descripcionRegistroProyecto;

    //Nombre en l base de datos historial_version
    //@DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "historial_version")
    private Date historialVersion;

    // Nombre en la base de datos fecha_inicio
    //@DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "fecha_inicio")
    private Date fechaInicio;

    // Nombre en la base de datos fecha_finalizacion_estimada
    //@DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "fecha_finalizacion_estimada")
    private Date fechaFinalizacionEstimada;

    //Muchos a uno
    @ManyToOne
    @JoinColumn(name = "id_universidad_fk", referencedColumnName = "id_universidad")
    private Universidad universidad;

    // Uno a muchos
    @OneToMany(mappedBy = "registroProyecto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Proyecto> proyecto;
}
