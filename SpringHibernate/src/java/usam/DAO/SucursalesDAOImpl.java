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
import persistencia.Usuarios.Sucursales;

/**
 *
 * @author Admin125
 */
@Repository
public class SucursalesDAOImpl implements SucursalesDAO{

    @Autowired
    SessionFactory sf;
    
    @Override
    public void AgregarSucursal(Sucursales suc) {
        sf.getCurrentSession().save(suc);
    }

    @Override
    public void ActualizarSucursal(Sucursales suc) {
        sf.getCurrentSession().update(suc);
    }

    @Override
    public List<Sucursales> MostrarTodosSucursales() {
        return sf.getCurrentSession().createQuery("FROM sucursales").list();
    }

    @Override
    public Sucursales MostrarUnoSucursales(Integer idSucursal) {
        Session s = sf.getCurrentSession();
        List<Sucursales> list = s.createQuery("FROM sucursales suc WHERE suc.idSucursal=:idSucursal").setParameter("idSucursal", idSucursal).list();
        return list.size()>0?(Sucursales)list.get(0):null;
    }

    @Override
    public void EliminarSucursal(Integer idSucursal) {
        Sucursales suc = (Sucursales)sf.getCurrentSession().load(Sucursales.class, idSucursal);
        if(suc!=null){
            sf.getCurrentSession().delete(suc);
        }
    }

}