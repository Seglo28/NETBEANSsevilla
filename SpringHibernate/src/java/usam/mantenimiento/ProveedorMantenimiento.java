package usam.mantenimiento;

import java.util.List;
import org.hibernate.Query;
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

    public Proveedores consultarProveedores(Integer idProveedor) {
        Proveedores pro = new Proveedores();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            pro = (Proveedores) session.get(Proveedores.class, idProveedor);
            session.getTransaction().commit();
        } catch (Exception ex) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
        }
        return pro;
    }

    public int eliminarProveedores(Integer idProveedor) {
        Proveedores pro = new Proveedores();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        try {
            session.beginTransaction(); //EN EL EJEMPLO ESTO ESTA FUERA DEL TRY... EN LA PARTE SUPERIOR
            pro = (Proveedores) session.get(Proveedores.class, idProveedor);
        } catch (Exception ex) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            flag = 0;
        } finally {
            session.close();
        }
        return flag;
    }

    public List consultarTodosProveedores() {
        List<Proveedores> listaProveedores = null;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        try {
            session.beginTransaction(); //En el ejemplo esta fuera del try...
            Query q = session.createQuery("from Proveedores");
            listaProveedores = (List<Proveedores>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        return listaProveedores;
    }
}
