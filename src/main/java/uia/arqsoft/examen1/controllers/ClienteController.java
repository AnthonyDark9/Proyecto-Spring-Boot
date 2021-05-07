package uia.arqsoft.examen1.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import uia.arqsoft.examen1.entity.Cliente;
import uia.arqsoft.examen1.entity.EmpresaExterna;
import uia.arqsoft.examen1.service.IClienteService;
import uia.arqsoft.examen1.service.IEmpresaExternaService;
import javax.validation.Valid;
import java.util.List;

/**
 * Clase ClienteController, tiene la función de establecer el componente @Controller para indicar
 * que la clase es un controlador de Spring, así con la anotación @RequestMapping que se encarga de relacionar
 * un método con una petición HTTP.
 */
@Controller
@RequestMapping("/cliente")
public class ClienteController {

    // Interface Service.
    @Autowired
    private IClienteService clienteService;

    @Autowired
    private IEmpresaExternaService empresaExternaService;

    /**
     * @param model Se le enviá como parámetro el modelo.
     * @param user Se le manda como parámetro el usuario.
     * @return Retorna la página HTML correspondiente.
     */
    @GetMapping( "/")
    public String homeView(Model model, @AuthenticationPrincipal User user){
        model.addAttribute("listaClientes", clienteService.getAllClientes());
        System.out.println("El usuario que hizo login fue: " + user);
        return "cliente/index";
    }

    /**
     * @param model Se le enviá como parámetro el modelo.
     * @return Retorna la página HTML correspondiente.
     */
    @GetMapping("/showNuevoClienteForm")
    public String showNuevoMiembroForm(Model model){
        Cliente cliente = new Cliente();
        List<EmpresaExterna> empresaExternaList = empresaExternaService.getAllEmpresas();
        model.addAttribute("cliente", cliente);
        model.addAttribute("empresas", empresaExternaList);
        return "cliente/nuevo-cliente";
    }

    /**
     * @param cliente Se le manda como parámetro la clase Cliente.
     * @param errors Se le manda como parámetro el error, en caso de que haya uno.
     * @return Retorna el redirect de la página correspondiente.
     */
    @PostMapping("/guardarCliente")
    public String guardarMiembro(@ModelAttribute("cliente") @Valid Cliente cliente, Errors errors){
        if(errors.hasErrors()){
            return "cliente/index";
        }
        clienteService.guardarCliente(cliente);
        return "redirect:/cliente/";
    }

    /**
     * @param id Se le manda como parámetro el id de Cliente.
     * @param model Se le manda como parámetro el modelo.
     * @return Retorna la página correspondiente.
     */
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model){
        Cliente cliente = clienteService.getClienteById(id);
        model.addAttribute("cliente", cliente);
        return "cliente/actualizar-cliente";
    }

    /**
     * @param id Se le manda como parámetro el id de Cliente.
     * @return Retorna el redirect de la página correspondiente.
     */
    @GetMapping("/borrarCliente/{id}")
    public String borrarMiembro(@PathVariable(value = "id") long id){
        this.clienteService.borrarClienteById(id);
        return "redirect:/cliente/";
    }

}
