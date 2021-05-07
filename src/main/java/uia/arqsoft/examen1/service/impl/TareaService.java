package uia.arqsoft.examen1.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uia.arqsoft.examen1.entity.Tarea;
import uia.arqsoft.examen1.repository.ITareaRepository;
import uia.arqsoft.examen1.service.ITareaService;
import java.util.List;
import java.util.Optional;

/**
 * Clase TareaService, tiene la función de de implementar la interface ITareaService con
 * los métodos de la interface. Con la anotación @Service indica que es un componente de Spring
 * con la lógica de negocio.
 */
@Service
public class TareaService implements ITareaService {

    /**
     * Inyeccion de dependencias por propiedad
     */
    @Autowired
    private ITareaRepository tareaRepository;

    /***
     *
     * @return Retorna la lista de tareas.
     */
    @Override
    @Transactional(readOnly = true)
    public List<Tarea> getAllTareas() {
        return tareaRepository.findAll();
    }

    /**
     *
     * @param tarea Se le manda como parametro el objeto tarea
     */
    @Override
    @Transactional
    public void guardarTarea(Tarea tarea) {
        this.tareaRepository.save(tarea);
    }

    /**
     *
     * @param id Se le manda como parametro el id
     * @return Retorna la tarea por medio del id
     */
    @Override
    @Transactional(readOnly = true)
    public Tarea getTareaById(long id) {
        Optional<Tarea> optional = tareaRepository.findById(id);
        Tarea tarea;
        if(optional.isPresent()){
           tarea = optional.get();
        } else {
            throw new RuntimeException("La tarea con el id: " + id + " no ha sido encontrado");
        }
        return tarea;
    }

    /**
     *
     * @param id Se le manda como parametro el id
     */
    @Override
    @Transactional
    public void borrarTareaBy(long id) {
        this.tareaRepository.deleteById(id);
    }
}
