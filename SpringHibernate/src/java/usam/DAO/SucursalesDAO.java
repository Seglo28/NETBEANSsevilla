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
import persistencia.Usuarios.Sucursales;
import usam.spring.HibernateUtil;

/**
 *
 * @author Admin125
 */
public class SucursalesDAO {

    public int guardarSucursales(Integer idSucursal,
            String sucursal,
            String direccion,
            String municipio,
            String departamento,
            String telefono) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        Sucursales sucur = new Sucursales();
        sucur.setIdSucursal(idSucursal);
        sucur.setSucursal(sucursal);
        sucur.setDireccion(direccion);
        sucur.setMunicipio(municipio);
        sucur.setDepartamento(departamento);
        sucur.setTelefono(telefono);
        try {
            session.beginTransaction();
            session.save(sucur);
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

    public Sucursales consultarSucursales(Integer idSucursal){
    Sucursales suc = new Sucursales();
    SessionFactory factory=HibernateUtil.getSessionFactory();
    Session session = factory.openSession();
    try{
    session.beginTransaction();
    suc = (Sucursales) session.get(Sucursales.class, idSucursal);
    session.getTransaction().commit();
    }catch (Exception ex) {
            if(session.getTransaction().isActive()){
                session.getTransaction().rollback();
            }
        }finally{
        session.close();
    }
    return suc;
    }
    
    public int eliminarSucursales(Integer idSucursal){
        Sucursales suc = new Sucursales();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;
        
        try{
        session.beginTransaction(); //EN EL EJEMPLO ESTO ESTA FUERA DEL TRY... EN LA PARTE SUPERIOR
        suc = (Sucursales) session.get(Sucursales.class, idSucursal);
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
    
    public List consultarTodosSucursales(){
        List<Sucursales> listaSucursales=null;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        
        try{
        session.beginTransaction(); //En el ejemplo esta fuera del try...
        Query q = session.createQuery("from Sucursales");
        listaSucursales = (List<Sucursales>)q.list();
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
        }
        return listaSucursales;
    }    
}
