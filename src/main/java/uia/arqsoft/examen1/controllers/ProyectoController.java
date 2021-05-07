package uia.arqsoft.examen1.controllers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import uia.arqsoft.examen1.entity.Proyecto;
import uia.arqsoft.examen1.entity.RegistroProyecto;
import uia.arqsoft.examen1.service.impl.ProyectoService;
import uia.arqsoft.examen1.service.impl.RegistroProyectoService;
import javax.validation.Valid;
import java.util.List;

/**
 * Clase ProyectoController, necesaria para poder leer, guardar, actualizar y borrar
 * los datos de la clase Entity Proyecto, con la anotación @Controller para poder trabajar
 * con Spring y anotación @RequesrMapping para relacionar los métodos con una petición HTTP.
 */
@Slf4j
@Controller
@RequestMapping("/proyecto")
public class ProyectoController {

    /**
     * Inyeccion de dependencias por propiedad
     */
    @Autowired
    private ProyectoService proyectoService;

    /**
     * Inyeccion de dependencias  por propiedad.
     */
    @Autowired
    private RegistroProyectoService registroProyectoService;


    /**
     *
     * @param model Se le manda como parametro el modelo
     * @param user Se le manda como parametro el user de spring security
     * @return Retorna la vista indicada.
     */
    @RequestMapping("/")
    public String homeView(Model model, @AuthenticationPrincipal User user){
        model.addAttribute("listarProyectos", proyectoService.getAllProyectos());
        log.info("El usuario que hizo login fue: " + user);
        return "proyecto/index";
    }

    /**
     *
     * @param model Se le manda como parametro el modelo
     * @return Retorna la vista indicada
     */
    @RequestMapping("/showNuevoProyectoForm")
    public String showNuevoProyectoForm(Model model){
        Proyecto proyecto = new Proyecto();
        List<RegistroProyecto> registroProyectoList = registroProyectoService.getAllRegistros();
        model.addAttribute("proyecto", proyecto);
        model.addAttribute("registros", registroProyectoList);
        log.info("Se ha dirigido a crear un nuevo proyecto");
        return "proyecto/nuevo-proyecto";
    }

    /**
     *
     * @param proyecto Se le manda como parametro el proyecto
     * @param errors Se le manda como parametro la clase Errors
     * @return Retorna la vista indicada
     */
    @PostMapping("/guardarProyecto")
    public String guardarProyecto(@ModelAttribute("proyecto") @Valid Proyecto proyecto, Errors errors){
        if(errors.hasErrors()){
            return "redirect:/proyecto/";
        }
        proyectoService.guardarProyecto(proyecto);
        log.info("Se ha guardado un proyecto");
        return "redirect:/proyecto/";
    }

    /**
     *
     * @param id Se le manda como parametro el id
     * @param model Se le manda como parametro el modelo
     * @return Retorna la vista indicada
     */
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model){
        Proyecto proyecto = proyectoService.getProyectoById(id);
        model.addAttribute("proyecto", proyecto);
        return "proyecto/actualizar-proyecto";
    }

    /**
     *
     * @param id Se le manda como parametro el id
     * @return Retorna la vista indicada
     */
    @GetMapping("/borrarProyecto/{id}")
    public String borrarProyecto(@PathVariable(value = "id") long id){
        this.proyectoService.borrarProyectoById(id);
        return "redirect:/proyecto/";
    }
}
