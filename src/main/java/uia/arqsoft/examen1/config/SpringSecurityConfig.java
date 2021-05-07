package uia.arqsoft.examen1.config;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Clase SpringSecurityConfig, tiene la función de establecer la configuración de seguridad
 * de Spring Boot, extiende de la clase de WebSecurityConfigurerAdapter para poder establecer
 * ciertos parámetros.
 */
@Slf4j
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    // Interface userDetailsService.
    @Autowired
    private UserDetailsService userDetailsService;

    /**
     *
     * @return Retorna la encriptación de la contraseña de los nuevos usuarios.
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(4);
        String pass = "1515";
        System.out.println(encoder.encode(pass));
        log.info("La contraseña es: " + pass);
        return new BCryptPasswordEncoder();
    }

    /**
     * @param builder Se le manda como parámetro el builder.
     * @throws Exception Nos manda una excepcioón en caso de que haya alguna.
     */
    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    /** Método de prueba.
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("{noop}123")
                .roles("ADMIN", "USER")
                .and()
                .withUser("user")
                .password("{noop}123")
                .roles("USER");
    }
     */

    /**
     * Método en el que se indica la página del login, y los roles de usuario.
     * @param http Se le manda como parámetro un http request.
     * @throws Exception Nos tira una excepción den caso de que hay algún error.
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/index/**", "/cliente/**", "/miembro/**", "/departamento/**", "/personal/**")
                .hasRole("ADMIN")
                .antMatchers("/index/", "/", "/cliente/", "/miembro/", "/departamento/", "/personal/")
                .hasAnyRole("USER", "ADMIN")
                .and()
                .formLogin()
                .loginPage("/login/login-page")
                .and()
                .exceptionHandling().accessDeniedPage("/errors/error403");
    }
}




