package uia.arqsoft.examen1.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uia.arqsoft.examen1.entity.Universidad;
import uia.arqsoft.examen1.repository.IUniversidadRepository;
import uia.arqsoft.examen1.service.IUniversidadService;
import java.util.List;

/**
 * Clase UniversidadService, tiene la función de de implementar la interface IUniversidadService con
 * los métodos de la interface. Con la anotación @Service indica que es un componente de Spring
 * con la lógica de negocio.
 */
@Service
public class UniversidadService implements IUniversidadService {

    // Inyección de la interface repository.
    private final IUniversidadRepository universidadRepository;

    public UniversidadService(IUniversidadRepository universidadRepository) {
        this.universidadRepository = universidadRepository;
    }

    /**
     *
     * @return Retorna la lista de la Universidad, método usado para
     * las tablas relacionales.
     */
    @Transactional(readOnly = true)
    @Override
    public List<Universidad> getAllUniversidades() {
        return universidadRepository.findAll();
    }
}
