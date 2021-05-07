package uia.arqsoft.examen1.entity;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * Clase PersonalEmpresaExterna.
 * Con la anotación @Data La anotación de lombok tiene como propósito
 * evitar el Boilerplate o código repetitivo.
 * Con la anotación @Entity Se le manda a Spring que va a ser MVC.
 * Con la anotación @Table Se le manda a Spring que es una tabla de la base
 * de datos a usar.
 */
@Data
@Table(name = "personal_empresa_externa")
@Entity
public class PersonalEmpresaExterna implements Serializable {
    private static final long serialVersionUID = 1L;

    // ID Autoincremental
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_personal_empresa_externa")
    private Long idPersonalExterno;

    // Columna referenciada a name = puesto_personal;
    @NotEmpty
    @Column(name = "puesto_personal")
    private String puestoPersonalExterno;

    // Columna referenciada a name = categoria_personal.
    @NotEmpty
    @Column(name = "categoria_personal")
    private String categoriaPersonalExterno;

    // Clase relacional referenciada a la empresa externa.
    @ManyToOne
    @JoinColumn(name = "id_empresa_externa_three_fk", referencedColumnName = "id_empresa_externa")
    private EmpresaExterna empresaExt;
}
