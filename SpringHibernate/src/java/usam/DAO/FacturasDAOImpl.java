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
import persistencia.Usuarios.Facturas;

/**
 *
 * @author Admin125
 */
public class FacturasDAOImpl implements FacturasDAO {

    @Autowired
    private SessionFactory sf;
    
    @Override
    public void AgregarFactura(Facturas fac) {
        sf.getCurrentSession().save(fac);
    }

    @Override
    public void ActualizarFactura(Facturas fac) {
        sf.getCurrentSession().update(fac);
    }

    @Override
    public List<Facturas> MostrarTodosFacturas() {
        return sf.getCurrentSession().createQuery("FROM facturas").list();
    }

    @Override
    public Facturas MostrarUnoFacturas(Integer idFactura) {
        Session s = sf.getCurrentSession();
        List<Facturas> list = s.createQuery("FROM facturas fac WHERE fac.idFactura =: idFactura").setParameter("idFactura", idFactura).list();
        return list.size()>0?(Facturas)list.get(0): null;
    }

    @Override
    public void EliminarFactura(Integer idFactura) {
        Facturas fac = (Facturas)sf.getCurrentSession();
        if(fac!=null){
            sf.getCurrentSession().delete(fac);
        }
    }

}