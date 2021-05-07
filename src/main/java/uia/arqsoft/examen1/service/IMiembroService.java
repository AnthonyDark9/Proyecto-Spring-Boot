package uia.arqsoft.examen1.service;
import uia.arqsoft.examen1.entity.Miembro;
import java.util.List;

/**
 * Interface IMiembroService, tiene la función de tener los métodos
 * de un CRUD para implementarlos en el Controller.
 */
public interface IMiembroService {
    List<Miembro> getAllMiembros();
    void guardarMiembro(Miembro miembro);
    Miembro getMiembroById(long id);
    void borrarMiembroById(long id);
}
