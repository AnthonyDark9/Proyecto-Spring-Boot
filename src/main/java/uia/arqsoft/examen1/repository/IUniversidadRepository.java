package uia.arqsoft.examen1.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uia.arqsoft.examen1.entity.Universidad;

/**
 * Interface IUniversidadRepository con la anotación @Repository para la persistencia
 * de datos encargado de almacenar los datos de la base de datos o repositorio de información
 * que se necesite. Heredando los métodos CRUD de JpaResporitory.
 */
@Repository
public interface IUniversidadRepository extends JpaRepository<Universidad, Long> {
}
