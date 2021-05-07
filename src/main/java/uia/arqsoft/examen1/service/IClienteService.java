package uia.arqsoft.examen1.service;
import uia.arqsoft.examen1.entity.Cliente;
import java.util.List;

/**
 * Interface IClienteService, tiene la función de tener los métodos
 * de un CRUD para implementarlos en el Controller.
 */
public interface IClienteService {
    List<Cliente> getAllClientes();
    void guardarCliente(Cliente cliente);
    Cliente getClienteById(long id);
    void borrarClienteById(long id);
}
