package uia.arqsoft.examen1.service.impl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uia.arqsoft.examen1.entity.RegistroProyecto;
import uia.arqsoft.examen1.repository.IRegistroProyectoRepository;
import uia.arqsoft.examen1.service.IRegistroProyectoService;
import java.util.List;
import java.util.Optional;

/**
 * Clase RegistroProyectiService, tiene la función de de implementar la interface IRegistroProyectoService con
 * los métodos de la interface. Con la anotación @Service indica que es un componente de Spring
 * con la lógica de negocio.
 */
@Service
public class RegistroProyectoService implements IRegistroProyectoService {

    private final IRegistroProyectoRepository registroProyectoRepository;

    /**
     * Inyección de dependencias por constructor.
     * @param registroProyectoRepository Se le manda como parametro la interface.
     */
    public RegistroProyectoService(IRegistroProyectoRepository registroProyectoRepository) {
        this.registroProyectoRepository = registroProyectoRepository;
    }

    /**
     *
     * @return Retorna la lista de registros.
     */
    @Override
    @Transactional(readOnly = true)
    public List<RegistroProyecto> getAllRegistros() {
        return this.registroProyectoRepository.findAll();
    }

    /**
     *
     * @param registroProyecto Se le manda como parametro el objeto RegistroProyecto
     */
    @Override
    @Transactional
    public void guardarRegistroProyecto(RegistroProyecto registroProyecto){
        registroProyectoRepository.save(registroProyecto);
    }

    /**
     *
     * @param id Se le manda como parametro el id
     * @return Retorna el registro del proyecto por id
     */
    @Override
    @Transactional(readOnly = true)
    public RegistroProyecto getRegistroProyectoById(long id) {
        Optional<RegistroProyecto> optional = registroProyectoRepository.findById(id);
        RegistroProyecto registroProyecto;
        if (optional.isPresent()){
            registroProyecto = optional.get();
        } else {
            throw new RuntimeException("El proyecto con el id: " + id + " no ha sido encontrado");
        }
        return registroProyecto;
    }

    /**
     *
     * @param id Se le manda como parametro el id
     */
    @Override
    @Transactional
    public void borrarRegistroProyectoById(long id) {
        registroProyectoRepository.deleteById(id);
    }

}
