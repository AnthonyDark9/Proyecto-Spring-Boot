package uia.arqsoft.examen1.controllers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import uia.arqsoft.examen1.entity.Usuario;
import uia.arqsoft.examen1.service.impl.UsuarioService;
import javax.validation.Valid;


/**
 * Clase UsuarioController, necesaria para poder leer, guardar, actualizar y borrar
 * los datos de la clase Entity Usuario, con la anotación @Controller para poder trabajar
 * con Spring y anotación @RequesrMapping para relacionar los métodos con una petición HTTP.
 */
@Controller
@Slf4j
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioService usuarioService;

    /**
     * Inyeccion de dependencias por Setter.
     * @param usuarioService Se le manda como parametro el servicio usuarioService
     */
    @Autowired
    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    /**
     *
     * @param model Se le manda como parametro el modelo
     * @param user Se le manda como parametro el usuario
     * @return Retorna la vista indicaada.
     */
    @RequestMapping("/")
    public String homeView(Model model, @AuthenticationPrincipal User user){
        model.addAttribute("listarUsuarios", usuarioService.getAllUsuarios());
        log.info("El usuario que hizo login fue: " + user);
        return "usuario/index";
    }

    /**
     *
     * @param model Se le manda como parametro el modelo
     * @return Retorna la vista indicada
     */
    @RequestMapping("/showNuevoUsuarioForm")
    public String showNuevoUsuarioForm(Model model){
        Usuario usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        log.info("Se ha dirigido a crear una nuevo usuario");
        return "usuario/nuevo-usuario";
    }

    /**
     *
     * @param usuario Se le manda como parametro la clase Usuario
     * @param errors Se le manda como parametro la clase Errors
     * @return Retorna la vista indicada.
     */
    @PostMapping("/guardarUsuario")
    public String guardarUsuario(@ModelAttribute("usuario") @Valid Usuario usuario, Errors errors){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(4);
        if(errors.hasErrors()){
            log.warn("Ha habido un error en el guardado del usuario");
            return "redirect:/usuario/";
        }
        log.info("La contraseña del usuario es: " + passwordEncoder.encode(usuario.getPassword()));
        usuarioService.guardarUsuario(usuario);
        log.info("Se ha guardado un usuario");
        return "redirect:/usuario/";
    }

    /**
     *
     * @param id Se le manda como parametro el id
     * @param model Se le manda como parametro el modelo
     * @return Retorna la vista
     */
    /*
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model){
        Usuario usuario = usuarioService.getUsuarioById(id);
        model.addAttribute("usuario", usuario);
        return "usuario/actualizar-usuario";
    }
     */

    /**
     *
     * @param id Se le manda como parametro el id
     * @return Retorna la vista indicada
     */
    @GetMapping("/borrarUsuario/{id}")
    public String borrarUsuario(@PathVariable(value = "id") long id){
        usuarioService.borrarUsuarioById(id);
        return "redirect:/usuario/";
    }
}
