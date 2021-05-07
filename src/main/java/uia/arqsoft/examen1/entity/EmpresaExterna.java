package uia.arqsoft.examen1.entity;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

/**
 * Clase EmpresaExterna.
 * Con la anotación @Data La anotación de lombok tiene como propósito
 * evitar el Boilerplate o código repetitivo.
 * Con la anotación @Entity Se le manda a Spring que va a ser MVC.
 * Con la anotación @Table Se le manda a Spring que es una tabla de la base
 * de datos a usar.
 */
@Data
@Entity
@Table(name = "empresa_externa")
public class EmpresaExterna implements Serializable {
    private static final long serialVersionUID = 1L;

    // ID Autoincremental.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empresa_externa")
    private Long idEmpresaExterna;

    // Columna referenciada name = nombre_empresa_externa.
    @NotEmpty
    @Column(name = "nombre_empresa_externa")
    private String nombreEmpresaExterna;

    // Columna referenciada a la base de datos = folio_empresa.
    @NotEmpty
    @Column(name = "folio_empresa")
    private String folioEmpresa;

    // Uno a muchos
    @OneToMany(mappedBy = "empresaExterna", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Cliente> clientes;

    // Uno a muchos
    @OneToMany(mappedBy = "empresaExt", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PersonalEmpresaExterna> personal;
}
