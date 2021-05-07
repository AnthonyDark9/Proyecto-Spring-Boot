package uia.arqsoft.examen1.controllers;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Clase IndexController, tiene como propósito establecer una página principal,
 * con sus métodos necesarios, con anotación @Controller necesaria para trabajar con Spring
 * y anotación @RequestMapping para relacionar los métodos con una petición HTTP.
 */
@Controller
@RequestMapping({"/index", ""})
public class IndexController {

    /**
     * @return Retorna la página HTML correspondiente.
     */
    @GetMapping({"/", "/index"})
    public String linkSalir(){
        return "index";
    }
}
