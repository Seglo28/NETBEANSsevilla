/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usam.DAO;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import persistencia.Usuarios.Usuario;

/**
 *
 * @author Admin125
 */
@Repository
public class UsuariosDAOImpl implements UsuariosDAO{

    @Autowired
    SessionFactory sf;
    
    @Override
    public void AgregarUsuario(Usuario usu) {
        sf.getCurrentSession().save(usu);
    }

    @Override
    public void ActualizarUsuario(Usuario usu) {
        sf.getCurrentSession().update(usu);
    }

    @Override
    public List<Usuario> MostrarTodosUsuarios() {
        return sf.getCurrentSession().createQuery("FROM usuario").list();
    }

    @Override
    public Usuario MostrarUnoUsuarios(Integer idUsuario) {
        Session s = sf.getCurrentSession();
        List<Usuario> list= s.createQuery("FROM usuario usu WHERE usu.idUsuario=:idUsuario").setParameter("idUsuario", idUsuario).list();
        return list.size()>0?(Usuario)list.get(0):null;
    }

    @Override
    public void EliminarUsuario(Integer idUsuario) {
        Usuario usu = (Usuario)sf.getCurrentSession().load(Usuario.class, idUsuario);
        if(usu!=null){
            sf.getCurrentSession().delete(usu);
        }
    }
 
}