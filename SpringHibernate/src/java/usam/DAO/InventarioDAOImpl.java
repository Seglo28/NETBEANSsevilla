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
import persistencia.Usuarios.Inventario;

/**
 *
 * @author Admin125
 */
@Repository
public class InventarioDAOImpl implements InventarioDAO{

    @Autowired
    SessionFactory sf;
    
    @Override
    public void AgregarInventario(Inventario inv) {
        sf.getCurrentSession().save(inv);
    }

    @Override
    public void ActualizarInventario(Inventario inv) {
        sf.getCurrentSession().update(inv);
    }

    @Override
    public List<Inventario> MostrarTodosInventario() {
        return sf.getCurrentSession().createQuery("FROM inventario").list();
    }

    @Override
    public Inventario MostrarUnoInventario(Inventario idInventario) {
        Session s = sf.getCurrentSession();
        List<Inventario> list = s.createQuery("FROM inventario inv WHERE inv.idInventario=:idInventario").setParameter("idInventario", idInventario).list();
        return list.size()>0?(Inventario)list.get(0):null;
    }

    @Override
    public void EliminarInventario(Integer idInventario) {
        Inventario inv = (Inventario)sf.getCurrentSession().load(Inventario.class, idInventario);
        if(inv!=null){
            sf.getCurrentSession().delete(inv);
        }
    }
}