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
import uia.arqsoft.examen1.entity.Tarea;
import uia.arqsoft.examen1.service.impl.ProyectoService;
import uia.arqsoft.examen1.service.impl.TareaService;
import javax.validation.Valid;
import java.util.List;


/**
 * Clase TareaController, necesaria para poder leer, guardar, actualizar y borrar
 * los datos de la clase Entity Tarea, con la anotación @Controller para poder trabajar
 * con Spring y anotación @RequesrMapping para relacionar los métodos con una petición HTTP.
 */
@Slf4j
@Controller
@RequestMapping("/tarea")
public class TareaController {

    /**
     * Inyeccion de dependencias por propiedad
     */
    @Autowired
    private TareaService tareaService;

    /**
     * Inyeccion de dependencias por propiedad
     */
    @Autowired
    private ProyectoService proyectoService;

    /**
     * @param model Se le manda como parametro el modelo
     * @param user  Se le manda como parametro el usuario de spring security
     * @return Retorna la vista indicada.
     */
    @RequestMapping("/")
    public String homeView(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("listarTareas", tareaService.getAllTareas());
        log.info("El usuario que hizo login fue: " + user);
        return "tarea/index";
    }

    /**
     * @param model Se le manda como parametro el modelo.
     * @return Retorna la vista indicada
     */
    @RequestMapping("/showNuevaTareaForm")
    public String showNuevoTareaForm(Model model) {
        Tarea tarea = new Tarea();
        List<Proyecto> proyectoList = proyectoService.getAllProyectos();
        model.addAttribute("tarea", tarea);
        model.addAttribute("proyectos", proyectoList);
        log.info("Se ha dirigido a crear una nueva tarea");
        return "tarea/nueva-tarea";
    }

    /**
     * @param tarea  Se le manda como parametro la clase Tarea
     * @param errors Se le manda como parametro la clase Errors
     * @return Retorna la vista indicada.
     */
    @PostMapping("/guardarTarea")
    public String guardarTarea(@ModelAttribute("tarea") @Valid Tarea tarea, Errors errors) {
        if (errors.hasErrors()) {
            return "redirect:/tarea/";
        }
        tareaService.guardarTarea(tarea);
        log.info("Se ha guardado una tarea");
        return "redirect:/tarea/";
    }

    /**
     * @param id    Se le manda como parametro el id
     * @param model Se le manda como parametro el modelo
     * @return Retorna la vista indicada
     */
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        Tarea tarea = tareaService.getTareaById(id);
        model.addAttribute("tarea", tarea);
        return "tarea/actualizar-tarea";
    }

    /**
     *
     * @param id Se le manda como parametro el id
     * @return Retorna la vista indicada.
     */
    @GetMapping("/borrarTarea/{id}")
    public String borrarTarea(@PathVariable(value = "id") long id){
        this.tareaService.borrarTareaBy(id);
        return "redirect:/tarea/";
    }
}
