package uia.arqsoft.examen1.entity;
import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

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
@Table(name = "tarea")
public class Tarea implements Serializable {
    private static final long serialVersionUID = 1L;

    //Columna referenciada a id_tarea
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tarea")
    private Long idTarea;

    // Columna referenciada a nombre_tarea
    @Column(name = "nombre_tarea")
    private String nombreTarea;

    // Columna referenciada a duracion_eztimada_total
    //@DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "duracion_estimada_total")
    private Date duracionEstimadaTotal;

    //Muchos a uno
    @ManyToOne
    @JoinColumn(name = "id_proyecto_fk", referencedColumnName = "id_proyecto")
    private Proyecto proyecto;
}
