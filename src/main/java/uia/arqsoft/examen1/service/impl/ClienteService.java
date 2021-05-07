package uia.arqsoft.examen1.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uia.arqsoft.examen1.entity.Cliente;
import uia.arqsoft.examen1.repository.IClienteRepository;
import uia.arqsoft.examen1.service.IClienteService;
import java.util.List;
import java.util.Optional;

/**
 * Clase ClienteService, tiene la función de de implementar la interface IClienteService con
 * los métodos de la interface. Con la anotación @Service indica que es un componente de Spring
 * con la lógica de negocio.
 */
@Service
public class ClienteService implements IClienteService {

    @Autowired
    private IClienteRepository clienteRepository;


    /**
     *
     * @return Retorna toda la información encontrada en la base de datos.
     */
    @Override
    @Transactional(readOnly = true)
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    /**
     *
     * @param cliente Se le manda como parámetro el Objeto cliente y
     *                guarda los datos escritos en la vista.
     */
    @Override
    @Transactional
    public void guardarCliente(Cliente cliente) {
        this.clienteRepository.save(cliente);
    }

    /**
     *
     * @param id Se le manda como parámetro el id de Cliente.
     * @return Retorna toda la información del Cliente.
     */
    @Override
    @Transactional(readOnly = true)
    public Cliente getClienteById(long id) {
        Optional<Cliente> optional = clienteRepository.findById(id);
        Cliente cliente = null;
        if(optional.isPresent()){
            cliente = optional.get();
        } else {
            throw new RuntimeException("El cliente con el id: " + id + " no ha sido encotrado.");
        }
        return cliente;
    }

    /**
     *
     * @param id Se le manda como parámetro el id de Cliente,
     *           para así borrar toda su información relacionada.
     */
    @Override
    @Transactional
    public void borrarClienteById(long id) {
        this.clienteRepository.deleteById(id);
    }
}
