package uia.arqsoft.examen1.controllers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import uia.arqsoft.examen1.entity.EmpresaExterna;
import uia.arqsoft.examen1.service.impl.EmpresaExternaService;
import javax.validation.Valid;


/**
 * Clase EmpresaExternaController, tiene la función de establecer el componente @Controller para indicar
 * que la clase es un controlador de Spring, así con la anotación @RequestMapping que se encarga de relacionar
 * un método con una petición HTTP.
 */
@Controller
@Slf4j
@RequestMapping("/socios")
public class EmpresaExternaController {

    private EmpresaExternaService empresaExternaService;

    /**
     * Inyección de dependencias por medio de setter.
     * @param empresaExternaService Se inyecta la interfaz empresaExternaService,
     */
    @Autowired
    public void setEmpresaExternaService(EmpresaExternaService empresaExternaService) {
        this.empresaExternaService = empresaExternaService;
    }

    /**
     *
     * @param model Se le manda como parámetro el modelo
     * @param user Se le manda como parametro el usuario
     * @return Retorna la vista indicada
     */
    @RequestMapping("/")
    public String homeView(Model model, @AuthenticationPrincipal User user){
        model.addAttribute("listarEmpresas", empresaExternaService.getAllEmpresas());
        log.info("El usuario que hizo login fue: " + user);
        return "socios/index";
    }

    /**
     *
     * @param model Se le manda como parametro el modelo
     * @return Retorna el la vista indicada
     */
    @RequestMapping("/showNuevoSocioForm")
    public String showNuevoSocioForm(Model model){
        EmpresaExterna empresaExterna = new EmpresaExterna();
        model.addAttribute("empresa", empresaExterna);
        log.info("Se ha dirigido a registrar un nuevo socio");
        return "socios/nuevo-socio";
    }

    /**
     *
     * @param empresaExterna Se le manda como parametro la clase EmpresaExterna.
     * @param errors Se le manda como parámetro la clase Errors
     * @return Retorna la vista indicada
     */
    @PostMapping("/guardarSocio")
    public String guardarSocio(@ModelAttribute("socio") @Valid EmpresaExterna empresaExterna, Errors errors){
        if(errors.hasErrors()){
            log.warn("Hay un error en guardar el nuevo socio");
            return "redirect:/socios/";
        }
        empresaExternaService.guardarEmpresaExterna(empresaExterna);
        log.info("Se ha guardado un socio");
        return "redirect:/socios/";
    }

    /**
     *
     * @param id Se le manda como parametro el id
     * @param model Se le manda como parametro el modelo
     * @return Retorna la vista indicada.
     */
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model){
        EmpresaExterna empresaExterna = empresaExternaService.getEmpresaExternaById(id);
        model.addAttribute("empresa", empresaExterna);
        return "socios/actualizar-socio";
    }

    /**
     *
     * @param id Se le manda como parametro el id
     * @return Retorna la vista indicada
     */
    @GetMapping("/borrarSocio/{id}")
    public String borrarSocio(@PathVariable(value = "id") long id){
        empresaExternaService.borrarEmpresaExternaById(id);
        return "redirect:/socios/";
    }
}
