package uia.arqsoft.examen1.service;
import uia.arqsoft.examen1.entity.Proyecto;
import java.util.List;

/**
 * Interface IProyectoService, tiene la función de tener los métodos
 * de un CRUD para implementarlos en el Controller.
 */
public interface IProyectoService {
    List<Proyecto> getAllProyectos();
    void guardarProyecto(Proyecto proyecto);
    Proyecto getProyectoById(long id);
    void borrarProyectoById(long id);
}
