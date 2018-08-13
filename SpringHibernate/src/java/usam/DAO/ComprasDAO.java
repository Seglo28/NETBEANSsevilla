/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usam.DAO;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import persistencia.Usuarios.Compras;
import persistencia.Usuarios.Productos;
import persistencia.Usuarios.Proveedores;
import usam.spring.HibernateUtil;

/**
 *
 * @author Admin125
 */
public class ComprasDAO {
   
    public int guardarCompras(Integer idCompra,
        Productos productos,
        Proveedores proveedores,
        Integer cantidad,
        Double monto) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        Compras com = new Compras();
        com.setIdCompra(idCompra);
        com.setProductos(productos);
        com.setProveedores(proveedores);
        com.setCantidad(cantidad);
        com.setMonto(monto);
       
        try {
            session.beginTransaction();
            session.save(com);
            session.getTransaction().commit();
            flag = 1;
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 1;
            }
        } finally {
            session.close();
        }
        return flag;
    }

    public Compras consultarCompras(Integer idCompra){
    Compras com = new Compras();
    SessionFactory factory=HibernateUtil.getSessionFactory();
    Session session = factory.openSession();
    try{
    session.beginTransaction();
    com = (Compras) session.get(Compras.class, idCompra);
    session.getTransaction().commit();
    }catch (Exception ex) {
            if(session.getTransaction().isActive()){
                session.getTransaction().rollback();
            }
        }finally{
        session.close();
    }
    return com;
    }
    
    public int eliminarCompras(Integer idCompra){
        Compras com = new Compras();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;
        
        try{
        session.beginTransaction(); //EN EL EJEMPLO ESTO ESTA FUERA DEL TRY... EN LA PARTE SUPERIOR
        com = (Compras) session.get(Compras.class, idCompra);
        }catch (Exception ex) {
            if(session.getTransaction().isActive()){
                session.getTransaction().rollback();
            }
            flag=0;
        } finally{
            session.close();
        }
        return flag;
    }
    
    public List consultarTodosCompras(){
        List<Compras> listaCompras=null;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        
        try{
        session.beginTransaction(); //En el ejemplo esta fuera del try...
        Query q = session.createQuery("from Compras");
        listaCompras = (List<Compras>)q.list();
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
        }
        return listaCompras;
    }
}
