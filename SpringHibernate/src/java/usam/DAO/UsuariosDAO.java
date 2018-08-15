/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usam.DAO;

import java.util.List;
import persistencia.Usuarios.Usuario;

/**
 *
 * @author Admin125
 */
public interface UsuariosDAO {
    
    public void AgregarUsuario(Usuario usu);
    
    public void ActualizarUsuario(Usuario usu);
    
    public List<Usuario> MostrarTodosUsuarios();
    
    public Usuario MostrarUnoUsuarios(Integer idUsuario);
    
    public void EliminarUsuario (Integer idUsuario);
}