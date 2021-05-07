package uia.arqsoft.examen1.service;
import uia.arqsoft.examen1.entity.Departamento;
import java.util.List;

/**
 * Interface IDepartamentoService, tiene la función de tener los métodos
 * de un CRUD para implementarlos en el Controller.
 */
public interface IDepartamentoService {
    List<Departamento> getAllDepartamentos();
    void guardarDepartamento(Departamento departamento);
    Departamento getDepartamentoById(long id);
    void borrarDepartamentoById(long id);
}
