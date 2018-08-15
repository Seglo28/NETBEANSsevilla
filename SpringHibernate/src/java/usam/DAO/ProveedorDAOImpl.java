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
import persistencia.Usuarios.Proveedores;

/**
 *
 * @author Admin125
 */
@Repository
public class ProveedorDAOImpl implements ProveedorDAO{

    @Autowired
    SessionFactory sf;
    
    @Override
    public void AgregarProveedor(Proveedores pro) {
        sf.getCurrentSession().save(pro);
    }

    @Override
    public void ActualizarProveedor(Proveedores pro) {
        sf.getCurrentSession().update(pro);
    }

    @Override
    public List<Proveedores> MostrarTodosProveedores() {
        return sf.getCurrentSession().createQuery("FROM proveedores").list();
    }

    @Override
    public Proveedores MostrarUnoProveedores(Integer idProveedor) {
        Session s = sf.getCurrentSession();
        List<Proveedores> list = s.createQuery("FROM proveedores pro WHERE pro.idProveedor=:idProveedor").setParameter("idProveedor", idProveedor).list();
        return list.size()>0?(Proveedores)list.get(0):null;
    }

    @Override
    public void EliminarProveedor(Integer idProveedor) {
        Proveedores pro = (Proveedores)sf.getCurrentSession().load(Proveedores.class, idProveedor);
        if(pro!=null){
            sf.getCurrentSession().delete(pro);
        }
    }
}