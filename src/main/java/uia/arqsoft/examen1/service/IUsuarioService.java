package uia.arqsoft.examen1.service;
import uia.arqsoft.examen1.entity.Usuario;
import java.util.List;

/**
 * Interface IUsuarioService, tiene la función de tener los métodos
 * de un CRUD para implementarlos en el Controller.
 */
public interface IUsuarioService {
    List<Usuario> getAllUsuarios();
    void guardarUsuario(Usuario usuario);
    //Usuario getUsuarioById(long id);
    void borrarUsuarioById(long id);
}
