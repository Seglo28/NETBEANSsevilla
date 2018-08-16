package usam.servicio;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistencia.Usuarios.Usuario;
import usam.DAO.UsuariosDAO;

@Service
public class UsuariosServiceImpl implements UsuariosService {

    @Autowired
    UsuariosDAO u;

    @Override
    @Transactional
    public void AgregarUsuario(Usuario usu) {
        u.AgregarUsuario(usu);
    }

    @Override
    @Transactional
    public void ActualizarUsuario(Usuario usu) {
        u.ActualizarUsuario(usu);
    }

    @Override
    @Transactional
    public List<Usuario> MostrarTodosUsuarios() {
        return u.MostrarTodosUsuarios();
    }

    @Override
    @Transactional
    public Usuario MostrarUnoUsuarios(Integer idUsuario) {
        return u.MostrarUnoUsuarios(idUsuario);
    }

    @Override
    @Transactional
    public void EliminarUsuario(Integer idUsuario) {
        u.EliminarUsuario(idUsuario);
    }
}
