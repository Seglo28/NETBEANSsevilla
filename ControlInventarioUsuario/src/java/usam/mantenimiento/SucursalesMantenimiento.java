package usam.mantenimiento;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import  usam.persistencia.Sucursales;
import usam.spring.HibernateUtil;

public class SucursalesMantenimiento {

    public static void main(String[] args) {
        
        SucursalesMantenimiento m = new SucursalesMantenimiento();
        
        /*--- AGREGAR ---*/
        /*
        Integer idSucursal=0;
        String sucursal="a";
        String direccion="a";
        String municipio="a";
        String departamento="a";
        String telefono="a";
        
        m.guardarSucursales(idSucursal, sucursal, direccion, municipio, departamento, telefono);
        */
        
        /*--- MOSTRAR UNO ---*/
        /*
        Sucursales mu = m.consultarSucursal(2);
        System.out.println(mu);
        */
        
        /*--- ELIMINAR ---*/
        /*
        m.eliminarSucursal(3);
*/
        
        /*--- MOSTRAR TODOS ---*/
        /*
        List mt = m.consultarTodosSucursales();
        System.out.println(mt);
        */
        
        /*--- ACTUALIZAR ---*/
        /*
        m.ActualizarSucursales(2, "sucursal", "direccion", "municipio", "departamento", "telefono");
*/
    }

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
            System.out.println("Sucursal agregada correctamente.");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 1;
                System.out.println("Error al agregar sucursal. "+e.getMessage());
            }
        } finally {
            session.close();
        }
        return flag;
    }
    
    public int ActualizarSucursales(Integer idSucursal,
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
            session.update(sucur);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("Sucursal actualizada correctamente.");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 1;
                System.out.println("Error al actualizar sucursal. "+e.getMessage());
            }
        } finally {
            session.close();
        }
        return flag;
    }

    public Sucursales consultarSucursal(Integer idSucursal){
    Sucursales suc = new Sucursales();
    SessionFactory factory=HibernateUtil.getSessionFactory();
    Session session = factory.openSession();
    try{
    session.beginTransaction();
    suc = (Sucursales) session.get(Sucursales.class, idSucursal);
    session.getTransaction().commit();
        if(suc==null){
            System.out.println("Los datos sobre la sucursal solicitada se han eliminado anteriormente.");
        }else{
            System.out.println("Mostrar datos de sucursal.");
        }
    }catch (Exception e) {
            if(session.getTransaction().isActive()){
                session.getTransaction().rollback();
                System.out.println("Error al mostrar sucursal. "+e.getMessage());
            }
        }finally{
        session.close();
    }
    return suc;
    }
    
    public int eliminarSucursal(Integer idSucursal){
        Sucursales suc = new Sucursales();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;
        
        try{
        session.beginTransaction(); //EN EL EJEMPLO ESTO ESTA FUERA DEL TRY... EN LA PARTE SUPERIOR
        suc = (Sucursales) session.get(Sucursales.class, idSucursal);
        session.delete(suc);
            session.getTransaction().commit();
        System.out.println("Datos de la sucursal eliminados correctamente.");
        }catch (Exception e) {
            if(session.getTransaction().isActive()){
                session.getTransaction().rollback();
                System.out.println("Los datos no se han eliminado. "+e);
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
            System.out.println("Datos totales de las sucursales.");
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al mostrar datos. "+e.getMessage());
        }finally{
        }
        return listaSucursales;
    }    
}
