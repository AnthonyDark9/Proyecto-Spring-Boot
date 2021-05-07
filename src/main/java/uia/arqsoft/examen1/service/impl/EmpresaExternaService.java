package uia.arqsoft.examen1.service.impl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uia.arqsoft.examen1.entity.EmpresaExterna;
import uia.arqsoft.examen1.repository.IEmpresaExternaRepository;
import uia.arqsoft.examen1.service.IEmpresaExternaService;
import java.util.List;
import java.util.Optional;

/**
 * Clase EmpresaExternaService, tiene la función de de implementar la interface IEmpresaExternaService con
 * los métodos de la interface. Con la anotación @Service indica que es un componente de Spring
 * con la lógica de negocio.
 */
@Service
public class EmpresaExternaService implements IEmpresaExternaService {

    // Inyección de la interface repository.
    private final IEmpresaExternaRepository empresaExternaRepository;

    public EmpresaExternaService(IEmpresaExternaRepository empresaExternaRepository) {
        this.empresaExternaRepository = empresaExternaRepository;
    }

    /**
     *
     * @return Retorna la lista de las empresas externas guardadas.
     */
    @Override
    @Transactional(readOnly = true)
    public List<EmpresaExterna> getAllEmpresas() {
         return empresaExternaRepository.findAll();
    }

    @Override
    @Transactional
    public void guardarEmpresaExterna(EmpresaExterna empresaExterna) {
        empresaExternaRepository.save(empresaExterna);
    }

    @Override
    @Transactional(readOnly = true)
    public EmpresaExterna getEmpresaExternaById(long id) {
        Optional<EmpresaExterna> optional = empresaExternaRepository.findById(id);
        EmpresaExterna empresaExterna;
        if(optional.isPresent()){
            empresaExterna = optional.get();
        } else {
            throw new RuntimeException("La empresa con el id: " + id + " no ha sido encontarda");
        }
        return empresaExterna;
    }

    @Override
    @Transactional
    public void borrarEmpresaExternaById(long id) {
        empresaExternaRepository.deleteById(id);
    }
}
