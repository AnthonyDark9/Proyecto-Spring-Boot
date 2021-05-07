package uia.arqsoft.examen1.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uia.arqsoft.examen1.entity.Alumno;
import uia.arqsoft.examen1.repository.IAlumnoRepository;
import uia.arqsoft.examen1.service.IAlumnoService;
import java.util.List;

/**
 * Clase AlumnoService, tiene la función de de implementar la interface IAlumnoService con
 * los métodos de la interface. Con la anotación @Service indica que es un componente de Spring
 * con la lógica de negocio.
 */
@Service
public class AlumnoService implements IAlumnoService {
    private final IAlumnoRepository alumnoRepository;

    /**
     * Inyeccion de dependencias por constructor
     * @param alumnoRepository Se inyecta la interfaz
     */
    @Autowired
    public AlumnoService(IAlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    /**
     *
     * @return Retorna la lista de alumnos
     */
    @Override
    public List<Alumno> getAllAlumnos() {
        return alumnoRepository.findAll();
    }
/*
    @Override
    public void guardarAlumno(Alumno alumno) {
        alumnoRepository.save(alumno);
    }

    @Override
    public Alumno getAlumnoById(long id) {
        Optional<Alumno> optional = alumnoRepository.findById(id);
        Alumno alumno;
        if(optional.isPresent()){
            alumno = optional.get();
        } else {
            throw new RuntimeException("El alumno con el id " + id + " no ha sido encontrado");
        }
        return alumno;
    }

 */

    /**
     *
     * @param id Se le manda como parametro el id
     */
    @Override
    public void borrarAlumnoById(long id) {
        alumnoRepository.deleteById(id);
    }
}
