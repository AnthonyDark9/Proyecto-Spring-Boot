package uia.arqsoft.examen1.service;
import uia.arqsoft.examen1.entity.Universidad;
import java.util.List;

/**
 * Interface IUniversidadService, tiene la función de tener los métodos
 * de un CRUD para implementarlos en el Controller.
 *
 * Método usado para las tablas relacionales.
 */
public interface IUniversidadService {
    List<Universidad> getAllUniversidades();
}
