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
import persistencia.Usuarios.Ventas;

/**
 *
 * @author Admin125
 */
@Repository
public class VentasDAOImpl implements VentasDAO{

    @Autowired
    SessionFactory sf;
    
    @Override
    public void AgregarVentas(Ventas ven) {
        sf.getCurrentSession().save(ven);
    }

    @Override
    public void ActualizarVentas(Ventas ven) {
        sf.getCurrentSession().update(ven);
    }

    @Override
    public List<Ventas> MostrarTodosVentas() {
        return sf.getCurrentSession().createQuery("FROM ventas").list();
    }

    @Override
    public Ventas MostrarUnoVentas(Integer idVenta) {
        Session s = sf.getCurrentSession();
        List<Ventas> list= s.createQuery("FROM ventas ven WHERE ven.idVenta=:idVenta").setParameter("idVenta", idVenta).list();
        return list.size()>0?(Ventas)list.get(0):null;
    }

    @Override
    public void EliminarVentas(Integer idVenta) {
        Ventas ven = (Ventas)sf.getCurrentSession().load(Ventas.class, idVenta);
        if(ven!=null){
            sf.getCurrentSession().delete(ven);
        }
    }

}