package usam.mantenimiento;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import persistencia.Usuarios.Proveedores;
import usam.spring.HibernateUtil;

public class ProveedorMantenimiento {

    public static void main(String[] args) {
        Integer idProveedor;
        String proveedor = "";
        String rubro = "";
        String contacto = "";
        String telefono = "";

        ProveedorMantenimiento mantenimiento = new ProveedorMantenimiento();

        System.out.println();
    }

    public int guardarProveedor(Integer idProveedor, String proveedor, String rubro, String contacto, String telefono) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;
        
        Proveedores  prov = new Proveedores();
        prov.setIdProveedor(idProveedor);
        prov.setProveedor(proveedor);
        prov.setRubro(rubro);
        prov.setContacto(contacto);
        prov.setTelefono(telefono);
        
         try
        {
           session.beginTransaction();
           session.save(prov);
           session.getTransaction().commit();
           flag=1;
        }
        catch(Exception e){
            if (session.getTransaction().isActive()){
                session.getTransaction().rollback();
                flag=1;
            }
        }finally
            {
                    session.close();
                    }
            return flag;
    }

}
