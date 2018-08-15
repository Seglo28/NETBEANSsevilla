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
import persistencia.Usuarios.Compras;

/**
 *
 * @author Admin125
 */
@Repository
public class ComprasDAOImpl implements ComprasDAO{

    @Autowired
    private SessionFactory sf;
    
    @Override
    public void AgregarCompra(Compras com) {
    sf.getCurrentSession().save(com);
    }

    @Override
    public void ActualizarCompra(Compras com) {
    sf.getCurrentSession().update(com);
    }

    @Override
    public List<Compras> MostrarTodosCompras() {
    return sf.getCurrentSession().createQuery("FROM compras").list();
    }

    @Override
    public Compras MostrarUnoCompras(Integer idCompra) {
    Session s = sf.getCurrentSession();
    List<Compras> list = s.createQuery("FROM compras com WHERE com.idCompra=:idCompra").setParameter("idCompra", idCompra).list();
    return list.size()>0?(Compras)list.get(0):null;
    }

    @Override
    public void EliminarCompra(Integer idCompra) {
    Compras com = (Compras)sf.getCurrentSession().load(Compras.class, idCompra);
    if(com!=null){
        sf.getCurrentSession().delete(com);
    }
    }
   
}