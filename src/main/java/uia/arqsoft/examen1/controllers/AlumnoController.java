package uia.arqsoft.examen1.controllers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uia.arqsoft.examen1.service.IAlumnoService;


/**
 * Controlador AlumnoController, tiene como función establecer el componente @Controller
 * para indicar que es una clase de Spring.
 */
@Controller
@Slf4j
@RequestMapping("/alumno")
public class AlumnoController {
    private final IAlumnoService alumnoService;

    /**
     * Inyección de dependecias por medio de constructor
     * @param alumnoService  Inyecta la interfaz por medio del constructor.
     */
    @Autowired
    public AlumnoController(IAlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    /**
     * @param model Se le manda como parametro el modelo
     * @param user Se le manda como parametro el usuario de spring security
     * @return retorna la vista indicada
     */
    @GetMapping( "/")
    public String homeView(Model model, @AuthenticationPrincipal User user){
        model.addAttribute("listaAlumnos", alumnoService.getAllAlumnos());
        System.out.println("El usuario que hizo login fue: " + user);
        return "alumno/index";
    }

    /**
     * @param id Se le manda como parámetro el id de Alumno.
     * @return Retorna el redirect de la página correspondiente.
     */
    @GetMapping("/borrarAlumno/{id}")
    public String borrarAlumno(@PathVariable(value = "id") long id){
        alumnoService.borrarAlumnoById(id);
        return "redirect:/alumno/";
    }
}
