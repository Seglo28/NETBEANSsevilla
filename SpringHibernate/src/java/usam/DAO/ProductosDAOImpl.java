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
import persistencia.Usuarios.Productos;

/**
 *
 * @author Admin125
 */
@Repository
public class ProductosDAOImpl implements ProductosDAO{

    @Autowired
    SessionFactory sf;
    
    @Override
    public void AgregarProducto(Productos pro) {
        sf.getCurrentSession().save(pro);
    }

    @Override
    public void ActualizarProducto(Productos pro) {
        sf.getCurrentSession().update(pro);
    }

    @Override
    public List<Productos> MostrarTodosProductos() {
        return sf.getCurrentSession().createQuery("FROM productos").list();
    }

    @Override
    public Productos MostrarUnoProductos(Integer idProducto) {
        Session s = sf.getCurrentSession();
        List<Productos> list = s.createQuery("FROM productos pro WHERE pro.idProducto=:idProducto").setParameter("idProducto", idProducto).list();
        return list.size()>0?(Productos)list.get(0):null;
    }

    @Override
    public void EliminarProducto(Integer idProducto) {
        Productos pro = (Productos)sf.getCurrentSession().load(Productos.class, idProducto);
        if(pro!=null){
            sf.getCurrentSession().delete(pro);
        }
    }
}