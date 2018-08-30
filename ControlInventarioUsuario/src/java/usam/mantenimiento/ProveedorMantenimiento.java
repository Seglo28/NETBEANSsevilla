package usam.mantenimiento;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import  usam.persistencia.Proveedores;
import usam.spring.HibernateUtil;

public class ProveedorMantenimiento {

    public static void main(String[] args) {
        ProveedorMantenimiento man = new ProveedorMantenimiento();
        int idProveedor=0;
        String proveedor = " CANVAS";
        String rubro = "Anonima de capital variable ";
        String contacto = " Estiven espinosa Ramos, gerente  de ventas ";
        String telefono = "2206 - 7000";

        int r= man.guardarProveedores(idProveedor, proveedor, rubro, contacto, telefono);
        System.out.println();
    }

    public int guardarProveedores(
            int idProveedor,
            String proveedor, String rubro, String contacto, String telefono) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;
        Proveedores prov = new Proveedores();
        prov.setIdProveedor(idProveedor);
        prov.setProveedor(proveedor);
        prov.setRubro(rubro);
        prov.setContacto(contacto);
        prov.setTelefono(telefono);
        try {
            session.beginTransaction();
            session.save(prov);
            session.getTransaction().commit();
            flag = 1;
            System.out.println(" exito al guardar  el proveedor");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 1;
                System.out.println(" error al guaradar el peoveedor"+e);
            }
        } finally {
            session.close();
        }
        return flag;
    }

    public int ActualizarProveedores(
            int idProveedor,
            String proveedor, String rubro, String contacto, String telefono) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;
        Proveedores prov = new Proveedores();
        prov.setIdProveedor(idProveedor);
        prov.setProveedor(proveedor);
        prov.setRubro(rubro);
        prov.setContacto(contacto);
        prov.setTelefono(telefono);
        try {
            session.beginTransaction();
            session.saveOrUpdate(prov);
            session.getTransaction().commit();
            flag = 1;
            System.out.println(" exito al actualizar el proveedor");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 1;
                System.out.println(" Esta pasando unerror en actualizar el proveedor"+e);
            }
        } finally {
            session.close();
        }
        return flag;
    }

    public Proveedores consultarProveedor(int idProveedor) {
        Proveedores prov = new Proveedores();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        try {
            session.beginTransaction();
            prov = (Proveedores) session.get(Proveedores.class, idProveedor);
            session.getTransaction().commit();
            System.out.println(" exito al consulatr el proveedor");
            return prov;
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                System.out.println("error al consulatr el proveedor"+e);
            }

        } finally {
            session.close();
        }
        return prov;

    }

    public int eliminarProveedor(int idProveedor) {
        Proveedores prov = new Proveedores();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        int flag = 0;

        try {
            session.beginTransaction();
            prov = (Proveedores) session.get(Proveedores.class, idProveedor);
            session.delete(prov);

            session.getTransaction().commit();
            flag = 1;
            System.out.println(" exito al eliminar al proveedor");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 1;
                System.out.println(" error al eliminar el proveedor"+e);
            }

        } finally {
            session.close();
        }

        return flag;

    }

    public List consultarTodosProveedores() {
        List<Proveedores> listaProveedores = null;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        session.beginTransaction();
        try {
            Query q = session.createQuery("from Proveedores");
            listaProveedores = (List<Proveedores>) q.list();
            System.out.println(" exito al consulatar proveedores");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(" error al consular proveedores"+e);
        } finally {

        }
        return listaProveedores;
    }

}
