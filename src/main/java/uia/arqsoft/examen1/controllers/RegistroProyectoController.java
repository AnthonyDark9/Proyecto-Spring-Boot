package uia.arqsoft.examen1.controllers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import uia.arqsoft.examen1.entity.RegistroProyecto;
import uia.arqsoft.examen1.entity.Universidad;
import uia.arqsoft.examen1.service.impl.RegistroProyectoService;
import uia.arqsoft.examen1.service.impl.UniversidadService;
import javax.validation.Valid;
import java.util.List;


/**
 * Clase RegistroProyectoController, necesaria para poder leer, guardar, actualizar y borrar
 * los datos de la clase Entity registroProyecto, con la anotación @Controller para poder trabajar
 * con Spring y anotación @RequesrMapping para relacionar los métodos con una petición HTTP.
 */
@Slf4j
@Controller
@RequestMapping("registro-proyecto")
public class RegistroProyectoController {

    private final RegistroProyectoService registroProyectoService;
    private final UniversidadService universidadService;

    /**
     * Inyección de dependencias por constructor
     * @param registroProyectoService Se le manda como parametro el servicioService
     * @param universidadService Se le manda como parametro el servicio universidadService
     */
    public RegistroProyectoController(RegistroProyectoService registroProyectoService, UniversidadService universidadService) {
        this.registroProyectoService = registroProyectoService;
        this.universidadService = universidadService;
    }

    /**
     *
     * @param model Se le manda como parametro el modelo
     * @param user Se le manda como parametro el usuario
     * @return Retorna la vista indicada.
     */
    @RequestMapping("/")
    public String homeView(Model model, @AuthenticationPrincipal User user){
        model.addAttribute("listarRegistros", registroProyectoService.getAllRegistros());
        log.info("El usuario que hizo login fue: " + user);
        return "registro-proyecto/index";
    }

    /**
     *
     * @param model Se le manda como parametro el modelo
     * @return Retorna la vista indicada
     */
    @RequestMapping("/showNuevoRegistroForm")
    public String showNuevoRegistroForm(Model model){
        RegistroProyecto registroProyecto = new RegistroProyecto();
        List<Universidad> universidadList = universidadService.getAllUniversidades();;
        model.addAttribute("registroProyectos", registroProyecto);
        model.addAttribute("universidades", universidadList);
        log.info("Se ha dirigido a registrar un proyecto");
        return "registro-proyecto/nuevo-registro";
    }

    /**
     *
     * @param registroProyecto Se le manda como parametro la clase RegistroProyecto
     * @param errors Se le manda como parametro la clase Erros
     * @return Retorna la vista indicada.
     */
    @PostMapping("/guardarRegistroProyecto")
    public String guardarRegistroProyecto(@ModelAttribute("registro") @Valid RegistroProyecto registroProyecto, Errors errors){
        if(errors.hasErrors()){
            log.warn("Ha habido un error en guardar el registro");
            return "redirect:/registro-proyecto/";
        }
        registroProyectoService.guardarRegistroProyecto(registroProyecto);
        log.info("Se ha guardado un registro de un proyecto");
        return "redirect:/registro-proyecto/";
    }

    /**
     *
     * @param id Se le manda como parametro el id
     * @param model Se le manda como parametro el modelo
     * @return Retorna la vista indicada.
     */
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model){
        RegistroProyecto registroProyecto = registroProyectoService.getRegistroProyectoById(id);
        model.addAttribute("registroProyecto", registroProyecto);
        return "registro-proyecto/actualizar-registro";
    }

    /**
     *
     * @param id Se le manda como parametro el id
     * @return Retorna la vista indicada.
     */
    @GetMapping("/borrarRegistroProyecto/{id}")
    public String borrarRegistroProyecto(@PathVariable(value = "id") long id){
        this.registroProyectoService.borrarRegistroProyectoById(id);
        return "redirect:/registroProyecto/";
    }
}
