package uia.arqsoft.examen1.service;
import uia.arqsoft.examen1.entity.EmpresaExterna;
import java.util.List;

/**
 * Interface IEmpresaService, tiene la función de tener los métodos
 * de un CRUD para implementarlos en el Controller.
 *
 * Método para la tabla relacional.
 */
public interface IEmpresaExternaService {
    List<EmpresaExterna> getAllEmpresas();
    void guardarEmpresaExterna(EmpresaExterna empresaExterna);
    EmpresaExterna getEmpresaExternaById(long id);
    void borrarEmpresaExternaById(long id);
}
