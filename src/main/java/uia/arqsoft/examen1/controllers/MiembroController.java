package uia.arqsoft.examen1.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uia.arqsoft.examen1.entity.Miembro;
import uia.arqsoft.examen1.service.IMiembroService;
import javax.validation.Valid;

/**
 * Clase MiembroController, necesaria para poder leer, guardar, actualizar y borrar
 * los datos de la clase Entity Miembro, con la anotación @Controller para poder trabajar
 * con Spring y anotación @RequesrMapping para relacionar los métodos con una petición HTTP.
 */
@Controller
@RequestMapping("/miembro")
public class MiembroController {

    //Interface IMiembroService
    /**
     * Inyección de dependencias por propiedad.
     */
    @Autowired
    private IMiembroService miembroService;

    /**
     * @param model Se le manda como parámetro el modelo.
     * @param user Se le manda como parámetro el user.
     * @return Retorna la página HTML correspondiente.
     */
    @GetMapping( "/")
    public String homeView(Model model, @AuthenticationPrincipal User user){
        model.addAttribute("listaMiembros", miembroService.getAllMiembros());
        System.out.println("El usuario que hizo login fue: "+ user);
        return "miembro/index";
    }

    /**
     * @param model Se le manda como parámetro el modelo.
     * @return Retorna la página HTML correspondiente.
     */
    @GetMapping("/showNuevoMiembroForm")
    public String showNuevoMiembroForm(Model model){
        Miembro miembro = new Miembro();
        model.addAttribute("miembro", miembro);
        return "miembro/nuevo-miembro";
    }

    /**
     * @param miembro Se le manda como parámetro la clase Miembro.
     * @return Retorna el redirect de la página correspondiente.
     */
    @PostMapping("/guardarMiembro")
    public String guardarMiembro(@ModelAttribute("miembro") @Valid Miembro miembro){
        miembroService.guardarMiembro(miembro);
        return "redirect:/miembro/";
    }

    /**
     * @param id Se le manda como parámetro el id de Miembro.
     * @param model Se le manda como parámetro el modelo.
     * @return Retorna la página HTML correspondiente.
     */
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model){
        Miembro miembro = miembroService.getMiembroById(id);
        model.addAttribute("miembro", miembro);
        return "miembro/actualizar-miembro";
    }

    /**
     *
     * @param id Se le manda como parámetro el id de Miembro.
     * @return Retorna el redirect de la página correspondiente.
     */
    @GetMapping("/borrarMiembro/{id}")
    public String borrarMiembro(@PathVariable(value = "id") long id){
        this.miembroService.borrarMiembroById(id);
        return "redirect:/miembro/";
    }
}
