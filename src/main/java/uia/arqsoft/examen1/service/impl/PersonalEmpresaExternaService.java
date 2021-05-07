package uia.arqsoft.examen1.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uia.arqsoft.examen1.entity.PersonalEmpresaExterna;
import uia.arqsoft.examen1.repository.IPersonalEmpresaExternaRepository;
import uia.arqsoft.examen1.service.IPersonalEmpresaExternaService;
import java.util.List;
import java.util.Optional;

/**
 * Clase PersonalEmpresaExternaService, tiene la función de de implementar la interface IPersonalEmpresaExternaService con
 * los métodos de la interface. Con la anotación @Service indica que es un componente de Spring
 * con la lógica de negocio.
 */
@Service
public class PersonalEmpresaExternaService implements IPersonalEmpresaExternaService {

    // Inyección de la interface repository.
    @Autowired
    IPersonalEmpresaExternaRepository proyectoRepository;

    /**
     * Información de solo lectura.
     * @return Retorna toda la información del personal.
     */
    @Override
    @Transactional(readOnly = true)
    public List<PersonalEmpresaExterna> getAllPersonal() {
        return proyectoRepository.findAll();
    }

    /**
     *
     * @param personalEmpresaExterna Se le manda como parámetro la empresaExterna y guarda
     *                               la información relacionada.
     */
    @Override
    @Transactional
    public void guardarPersonal(PersonalEmpresaExterna personalEmpresaExterna) {
        this.proyectoRepository.save(personalEmpresaExterna);
    }

    /**
     *
     * Información de solo lectura.- ReadyOnly
     * @param id Se le manda como parámetro el id del personal.
     * @return Retorna la información del personal.
     */
    @Override
    @Transactional(readOnly = true)
    public PersonalEmpresaExterna getPersonalById(long id) {
        Optional<PersonalEmpresaExterna> optional = proyectoRepository.findById(id);
        PersonalEmpresaExterna personalEmpresaExterna = null;
        if(optional.isPresent()){
            personalEmpresaExterna = optional.get();
        } else {
            throw new RuntimeException("PersonalEmpresaExterna no encontrado con el id: " + id);
        }
        return personalEmpresaExterna;
    }

    /**
     *
     * @param id Se le manda como parámetro el id del personal, y elimina toda
     *           la información relacionada.
     */
    @Override
    @Transactional
    public void borrarPersonalById(long id) {
        this.proyectoRepository.deleteById(id);
    }
}
