package uia.arqsoft.examen1.service;
import uia.arqsoft.examen1.entity.Tarea;
import java.util.List;

/**
 * Interface ITareaService, tiene la función de tener los métodos
 * de un CRUD para implementarlos en el Controller.
 */
public interface ITareaService {
    List<Tarea> getAllTareas();
    void guardarTarea(Tarea tarea);
    Tarea getTareaById(long id);
    void borrarTareaBy(long id);
}
