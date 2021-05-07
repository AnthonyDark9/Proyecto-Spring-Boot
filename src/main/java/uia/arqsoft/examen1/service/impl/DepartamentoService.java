package uia.arqsoft.examen1.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uia.arqsoft.examen1.entity.Departamento;
import uia.arqsoft.examen1.repository.IDepartamentoRepository;
import uia.arqsoft.examen1.service.IDepartamentoService;
import java.util.List;
import java.util.Optional;

/**
 * Clase DepartamentoService, tiene la función de de implementar la interface IDepartamentoService con
 * los métodos de la interface. Con la anotación @Service indica que es un componente de Spring
 * con la lógica de negocio.
 */
@Service
public class DepartamentoService implements IDepartamentoService {

    @Autowired
    IDepartamentoRepository departamentoRepository;

    /**
     * @return Retorna todos los departamentos guardados en la base de datos.
     * La notación Transactional se utiliza para que la información sea de solo lectura
     * y no se pueda modificar.
     */
    @Override
    @Transactional(readOnly = true)
    public List<Departamento> getAllDepartamentos() {
        return this.departamentoRepository.findAll();
    }

    /**
     *
     * @param departamento Se le manda como parámetro el departamento para así guardar
     *                     toda su información relacionada.
     */
    @Override
    @Transactional
    public void guardarDepartamento(Departamento departamento) {
        this.departamentoRepository.save(departamento);
    }

    /**
     *
     * @param id Se le manda como parámetro el id del departamento.
     * @return Retorna el departamento con la información relacionada.
     * Este es de solo lectura con la anotación Transactional.
     */
    @Override
    @Transactional(readOnly = true)
    public Departamento getDepartamentoById(long id) {
        Optional<Departamento> optional = departamentoRepository.findById(id);
        Departamento departamento = null;
        if (optional.isPresent()){
            departamento = optional.get();
        } else {
            throw new RuntimeException("El departamento con el id: " + id + " no ha sido encontrado.");
        }
        return departamento;
    }

    /**
     *
     * @param id Se le manda como parámetro el id del departamento, para borrar
     *           todos los elementos relacionados.
     */
    @Override
    @Transactional
    public void borrarDepartamentoById(long id) {
        this.departamentoRepository.deleteById(id);
    }
}
