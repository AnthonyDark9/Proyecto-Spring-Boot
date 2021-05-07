package uia.arqsoft.examen1.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uia.arqsoft.examen1.entity.Miembro;
import uia.arqsoft.examen1.repository.IMiembroRepository;
import uia.arqsoft.examen1.service.IMiembroService;
import java.util.List;
import java.util.Optional;

/**
 * Clase MiembroService, tiene la función de de implementar la interface IMiembroService con
 * los métodos de la interface. Con la anotación @Service indica que es un componente de Spring
 * con la lógica de negocio.
 */
@Service
public class MiembroService implements IMiembroService {

    @Autowired
    private IMiembroRepository miembroRepository;

    /**
     *
     * @return Retorna toda la información almacenada en la tabla miembro de la
     * base de datos.
     */
    @Override
    @Transactional(readOnly = true)
    public List<Miembro> getAllMiembros() {
        return miembroRepository.findAll();
    }

    /**
     *
     * @param miembro Se le manda como parámetro el objeto miembro, para así
     *                guardar los datos escritos en la vista.
     */
    @Override
    @Transactional
    public void guardarMiembro(Miembro miembro) {
        this.miembroRepository.save(miembro);
    }

    /**
     *
     * @param id Se le manda como parámetro el id de Miembro.
     * @return Retorna toda la información relacionada al id.
     */
    @Override
    @Transactional(readOnly = true)
    public Miembro getMiembroById(long id) {
        Optional<Miembro> optional = miembroRepository.findById(id);
        Miembro miembro = null;
        if(optional.isPresent()){
            miembro = optional.get();
        } else {
            throw new RuntimeException("Miembro no encontrado por id: " + id);
        }
        return miembro;
    }

    /**
     *
     * @param id Se le manda como parámetro el id de Miembro,
     *           si lo encuentra borra toda la información relacionada
     *           a este id.
     */
    @Override
    @Transactional
    public void borrarMiembroById(long id) {
        this.miembroRepository.deleteById(id);
    }
}
