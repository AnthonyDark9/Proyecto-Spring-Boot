package uia.arqsoft.examen1.service;
import uia.arqsoft.examen1.entity.RegistroProyecto;
import java.util.List;

/**
 * Interface IRegistroProyectoService, tiene la función de tener los métodos
 * de un CRUD para implementarlos en el Controller.
 */
public interface IRegistroProyectoService {
    List<RegistroProyecto> getAllRegistros();
    void guardarRegistroProyecto(RegistroProyecto registroProyecto);
    RegistroProyecto getRegistroProyectoById(long id);
    void borrarRegistroProyectoById(long id);
}
