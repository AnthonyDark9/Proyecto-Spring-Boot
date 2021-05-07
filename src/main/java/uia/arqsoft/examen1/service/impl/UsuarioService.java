package uia.arqsoft.examen1.service.impl;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uia.arqsoft.examen1.entity.Miembro;
import uia.arqsoft.examen1.entity.Rol;
import uia.arqsoft.examen1.entity.Tarea;
import uia.arqsoft.examen1.entity.Usuario;
import uia.arqsoft.examen1.repository.IMiembroRepository;
import uia.arqsoft.examen1.repository.IUsuarioRepository;
import uia.arqsoft.examen1.service.IUsuarioService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/**
 * Clase UsuarioService, tiene la función de de implementar la interface UserDetailsService y IUsuarioServicecon
 * los métodos de la interface. Con la anotación @Service indica que es un componente de Spring
 * con la lógica de negocio.
 */
@Service("userDetailsService")
public class UsuarioService implements UserDetailsService, IUsuarioService {

    // Inyección de la interface repository.
    private final IUsuarioRepository usuarioRepository;

    /**
     * Inyeccion de dependencias por constructos
     * @param usuarioRepository Se le manda la interface usuarioRepository
     */
    @Autowired
    public UsuarioService(IUsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    /**
     * @param username Se le manda como parámetro el username.
     * @return Retorna la información del usuario, con sus roles e información.
     * @throws UsernameNotFoundException Nos tira una excepción en caso de que no se encuentre el usuario.
     */
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsername(username);
        var roles = new ArrayList<GrantedAuthority>();
        for (Rol rol : usuario.getRoles()){
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        }
        return new User(usuario.getUsername(), usuario.getPassword(), roles);
    }

    /**
     *
     * @return Retorna la lista de usuarios.
     */
    @Override
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    /**
     *
     * @param usuario Se le manda como parametro el usuario
     */
    @Override
    public void guardarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    /*
    @Override
    public Usuario getUsuarioById(long id) {
        Optional<Usuario> optional = usuarioRepository.findById(id);
        Usuario usuario;
        if (optional.isPresent()){
            usuario = optional.get();
        } else {
            throw new RuntimeException("El usuario con el id: " + id + " no ha siso encontrado");
        }
        return usuario;
    }

     */

    /**
     *
     * @param id Se le manda como parametro el id de usuario.
     */
    @Override
    public void borrarUsuarioById(long id) {
        usuarioRepository.deleteById(id);
    }
}
