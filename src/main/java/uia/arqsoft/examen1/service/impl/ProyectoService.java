package uia.arqsoft.examen1.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uia.arqsoft.examen1.entity.Proyecto;
import uia.arqsoft.examen1.repository.IProyectoRepository;
import uia.arqsoft.examen1.service.IProyectoService;
import java.util.List;
import java.util.Optional;
/**
 * ClaseProyectoService, tiene la función de de implementar la interface IProyectoService con
 * los métodos de la interface. Con la anotación @Service indica que es un componente de Spring
 * con la lógica de negocio.
 */
@Service
public class ProyectoService implements IProyectoService {

    // Inyección de dependencias por propiedad
    @Autowired
    private IProyectoRepository proyectoRepository;

    /**
     *
     * @return Retorna la lista de proyectos
     */
    @Override
    @Transactional(readOnly = true)
    public List<Proyecto> getAllProyectos() {
        return proyectoRepository.findAll();
    }

    /**
     *
     * @param proyecto Se le manda como parametro el objeto proyecto
     */
    @Override
    @Transactional
    public void guardarProyecto(Proyecto proyecto) {
        this.proyectoRepository.save(proyecto);
    }

    /**
     *
     * @param id Se le manda como parametro el id
     * @return Retorna el proyecto por id
     */
    @Override
    @Transactional(readOnly = true)
    public Proyecto getProyectoById(long id) {
        Optional<Proyecto> optional = proyectoRepository.findById(id);
        Proyecto proyecto;
        if(optional.isPresent()){
            proyecto = optional.get();
        } else {
            throw new RuntimeException("El proyecto con el id: " + id + " no ha sido encontrado");
        }
        return proyecto;
    }

    /**
     *
     * @param id Se le manda como parametro el id
     */
    @Override
    @Transactional
    public void borrarProyectoById(long id) {
        this.proyectoRepository.deleteById(id);
    }
}
