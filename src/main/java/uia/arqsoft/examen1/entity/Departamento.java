package uia.arqsoft.examen1.entity;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * Clase Departamento.
 * Con la anotación @Data La anotación de lombok tiene como propósito
 * evitar el Boilerplate o código repetitivo.
 * Con la anotación @Entity Se le manda a Spring que va a ser MVC.
 * Con la anotación @Table Se le manda a Spring que es una tabla de la base
 * de datos a usar.
 */
@Entity
@Data
@Table(name = "departamento")
public class Departamento implements Serializable {
    private static final long serialVersionUID = 1L;

    // ID Autoincremental
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_departamento")
    private Long idDepartamento;

    // Columna de la base de datos name = nombre_ departamento.
    @NotEmpty
    @Column(name = "nombre_departamento")
    private String nombreDepartamento;

    // Se unen las tablas relacionales, y se le indica si es muchos a uno. * -> 1.
    @JoinColumn(name = "id_universidad_three_fk", referencedColumnName = "id_universidad")
    @ManyToOne
    private Universidad universidad;
}
