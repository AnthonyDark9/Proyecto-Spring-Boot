package uia.arqsoft.examen1.service;
import uia.arqsoft.examen1.entity.Alumno;
import java.util.List;

/**
 * Interface IAlumnoService, tiene la función de tener los métodos
 * de un CRUD para implementarlos en el Controller.
 */
public interface IAlumnoService {
    List<Alumno> getAllAlumnos();
    //void guardarAlumno(Alumno alumno);
    //Alumno getAlumnoById(long id);
    void borrarAlumnoById(long id);
}
