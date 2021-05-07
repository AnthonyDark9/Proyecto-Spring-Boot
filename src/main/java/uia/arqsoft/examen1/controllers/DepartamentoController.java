package uia.arqsoft.examen1.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import uia.arqsoft.examen1.entity.Departamento;
import uia.arqsoft.examen1.entity.Universidad;
import uia.arqsoft.examen1.service.IDepartamentoService;
import uia.arqsoft.examen1.service.IUniversidadService;
import javax.validation.Valid;
import java.util.List;

/**
 * Clase DepartamentoController, tiene la función de establecer el componente @Controller para indicar
 * que la clase es un controlador de Spring, así con la anotación @RequestMapping que se encarga de relacionar
 * un método con una petición HTTP.
 */
@Controller
@RequestMapping("/departamento")
public class DepartamentoController {

    // Interface departamentoService,
    @Autowired
    private IDepartamentoService departamentoService;

    // Interface universidad service, necesario para enlistar la información de las tablas relacionales.
    @Autowired
    private IUniversidadService universidadService;

    /**
     * @param model Se le enviá como parámetro el modelo.
     * @param user Se le manda como parámetro el usuario.
     * @return Retorna la página HTML correspondiente.
     */
    @GetMapping( "/")
    public String homeView(Model model, @AuthenticationPrincipal User user){
        model.addAttribute("listaDepartamentos", departamentoService.getAllDepartamentos());
        System.out.println("El usuario que hizo login fue: " + user);
        return "departamento/index";
    }

    /**
     * @param model Se le enviá como parámetro el modelo.
     * @return Retorna la página HTML correspondiente.
     */
    @GetMapping("/showNuevoDepartamentoForm")
    public String showNuevoDepartamentoForm(Model model){
        Departamento departamento = new Departamento();
        List<Universidad> universidades = universidadService.getAllUniversidades();
        model.addAttribute("departamento", departamento);
        model.addAttribute("universidades", universidades);
        return "departamento/nuevo-departamento";
    }

    /**
     * @param departamento Se le manda como parámetro la Entity Departamento.
     * @param errors Se le manda como parámetro un Error, en caso de que haya algúno.
     * @return Retorna el redireccionamiento de la página principal
     */
    @PostMapping("/guardarDepartamento")
    public String guardarDepartamento(@ModelAttribute("departamento") @Valid Departamento departamento, Errors errors){
        if(errors.hasErrors()){
            return "departamento/actualizar-departamento";
        }
        departamentoService.guardarDepartamento(departamento);
        return "redirect:/departamento/";
    }

    /**
     * @param id Se le manda como parámetro el id.
     * @param model Se le manda como parámetro el modelo.
     * @return Retorna la página para actualizar la información de departamento.
     */
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model){
        Departamento departamento = departamentoService.getDepartamentoById(id);
        model.addAttribute("departamento", departamento);
        return "departamento/actualizar-departamento";
    }

    /**
     * @param id Se le manda como parámetro el id de Departamento.
     * @return Retorna el redirect de la página correspondiente.
     */
    @GetMapping("/borrarDepartamento/{id}")
    public String borrarDepartamento(@PathVariable(value = "id") long id){
        this.departamentoService.borrarDepartamentoById(id);
        return "redirect:/departamento/";
    }
}
