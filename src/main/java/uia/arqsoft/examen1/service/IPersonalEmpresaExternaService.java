package uia.arqsoft.examen1.service;
import uia.arqsoft.examen1.entity.PersonalEmpresaExterna;
import java.util.List;

/**
 * Interface IPersonalEmpresaExternaService, tiene la función de tener los métodos
 * de un CRUD para implementarlos en el Controller.
 */
public interface IPersonalEmpresaExternaService {
    List<PersonalEmpresaExterna> getAllPersonal();
    void guardarPersonal(PersonalEmpresaExterna personalEmpresaExterna);
    PersonalEmpresaExterna getPersonalById(long id);
    void borrarPersonalById(long id);
}
