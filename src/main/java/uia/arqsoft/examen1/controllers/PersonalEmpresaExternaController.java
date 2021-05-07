package uia.arqsoft.examen1.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import uia.arqsoft.examen1.entity.EmpresaExterna;
import uia.arqsoft.examen1.entity.PersonalEmpresaExterna;
import uia.arqsoft.examen1.service.IEmpresaExternaService;
import uia.arqsoft.examen1.service.IPersonalEmpresaExternaService;
import javax.validation.Valid;
import java.util.List;

/**
 * Clase PersonalEmpresaExternaController, necesaria para poder leer, guardar, actualizar y borrar
 * los datos de la clase Entity Miembro, con la anotación @Controller para poder trabajar
 * con Spring y anotación @RequesrMapping para relacionar los métodos con una petición HTTP.
 */
@Controller
@RequestMapping("/personal")
public class PersonalEmpresaExternaController {

    // Interface Service.
    /**
     * Inyección de dependencias por propiedad
     */
    @Autowired
    private IPersonalEmpresaExternaService personalEmpresaExternaService;

    // Interface necesaría para poder enlistar la información de las tablas relacionales.
    /**
     * Inyección de dependencias por propiead.
     */
    @Autowired
    private IEmpresaExternaService empresaExternaService;

    /**
     * @param model Se le enviá como parámetro el modelo.
     * @param user Se le manda como parámetro el usuario.
     * @return Retorna la página HTML correspondiente.
     */
    @GetMapping( "/")
    public String homeView(Model model, @AuthenticationPrincipal User user){
        model.addAttribute("listaPersonal", personalEmpresaExternaService.getAllPersonal());
        System.out.println("El usuario que hizo login fue: " + user);
        return "personal/index";
    }

    /**
     * @param model Se le enviá como parámetro el modelo.
     * @return Retorna la página HTML correspondiente.
     */
    @GetMapping("/showNuevoPersonalForm")
    public String showNuevoPersonalForm(Model model){
        PersonalEmpresaExterna personal = new PersonalEmpresaExterna();
        List<EmpresaExterna> empresaExternaList = empresaExternaService.getAllEmpresas();
        model.addAttribute("personal", personal);
        model.addAttribute("empresas", empresaExternaList);
        return "personal/nuevo-personal";
    }

    /**
     * @param personal Se le manda como parámetro la Clase PersonalEmpresaExterna.
     * @param errors Se le manda como parámetro un error en caso de que haya alguno.
     * @return Retorna el redireccionamiento de la página principal.
     */
    @PostMapping("/guardarPersonal")
    public String guardarPersonal(@ModelAttribute("personal") @Valid PersonalEmpresaExterna personal, Errors errors){
        if(errors.hasErrors()){
            return "redirect:/personal/";
        }
        personalEmpresaExternaService.guardarPersonal(personal);
        return "redirect:/personal/";
    }

    /**
     * @param id Se le manda como parámetro el id de PersonalEmpresaExterna.
     * @param model Se le manda como parámetro el modelo.
     * @return Retorna la página correspondiente.
     */
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model){
        PersonalEmpresaExterna personal = personalEmpresaExternaService.getPersonalById(id);
        model.addAttribute("personal", personal);
        return "personal/actualizar-personal";
    }

    /**
     * @param id Se le manda como parámetro el id de PersonalEmpresaExterna.
     * @return Retorna el redirect de la página correspondiente.
     */
    @GetMapping("/borrarPersonal/{id}")
    public String borrarPersonal(@PathVariable(value = "id") long id){
        this.personalEmpresaExternaService.borrarPersonalById(id);
        return "redirect:/personal/";
    }
}
