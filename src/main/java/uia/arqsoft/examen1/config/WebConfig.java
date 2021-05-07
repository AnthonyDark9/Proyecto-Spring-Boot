package uia.arqsoft.examen1.config;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.context.annotation.Configuration;

//import lombok.var;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.context.annotation.Bean;
//import org.springframework.web.servlet.LocaleResolver;
//import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
//import org.springframework.web.servlet.i18n.SessionLocaleResolver;
//import java.util.Locale;

/**
 * Clase WebConfig, esta clase configura ciertos parámetros para internacionalización,
 * esta se implementará en una versión futura.
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {


    /**
     * Método con el cuál vamos a manejar ciertos idiomas.
     * @return Retorna la variable slr.
     * */
    /*
    @Bean
    public LocaleResolver localeResolver(){
        var slr = new SessionLocaleResolver();
        slr.setDefaultLocale(new Locale("es"));
        return slr;
    }
     */


     //Método que cambiará ciertos parámetros para algunos idiomas.
     //@return Retorna la variable lci.

    /*
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor(){
        var lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }
     */
    /*
    @Override
    public void addInterceptors(InterceptorRegistry registro){
        registro.addInterceptor(localeChangeInterceptor());
    }
 */

    /**
     * Método que tiene la función de añadir controladores sin crearlos en el paquete
     * controller.
     * @param registro Se le manda como parámetro el registro del controlador.
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registro){
        //registro.addViewController("/index/");
        registro.addViewController("/login/login-page");
        registro.addViewController("/errors/error403");
    }

}
