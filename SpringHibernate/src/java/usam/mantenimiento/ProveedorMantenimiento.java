package usam.mantenimiento;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import persistencia.Usuarios.Proveedores;
import usam.spring.HibernateUtil;

public class ProveedorMantenimiento {

    public static void main(String[] args) {

        ProveedorMantenimiento m = new ProveedorMantenimiento();

        /*--- AGREGAR ---*/
 /*
        Integer idProveedor = 0;
        String proveedor = "MEMYNSKY BERINSTAIN";
        String rubro = "GASTRONOMIA";
        String contacto = "CHRISTIAN MORALES";
        String telefono = "No tiene xD";

        m.guardarProveedor(idProveedor, proveedor, rubro, contacto, telefono);
         */
 /*--- CONSULTAR ---*/
 /*
        Proveedores mu = m.consultarProveedor(2);
        System.out.println(mu);
         */
 /*--- ELIMINAR ---*/
 /*
        m.eliminarProveedores(7);
         */
 /*--- MOSTRAR TODOS ---*/
 /*
        List mt = m.consultarTodosProveedores();
        System.out.println(mt);
         */
 /*--- MOSTRAR TODOS ---*/
 /*
        m.ActualizarProveedor(3, "proveedor", "rubro", "contacto", "telefono");
         */
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
            System.out.println("Proveedor guardado exitosamente.");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 1;
                System.out.println("Error al intentar guardar proveedor. " + e.getMessage());
            }
        } finally {
            session.close();
        }
        return flag;
    }

    public int ActualizarProveedor(Integer idProveedor, String proveedor, String rubro, String contacto, String telefono) {

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
            session.update(prov);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("Proveedor actualizado exitosamente.");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 1;
                System.out.println("Error al intentar actualizar proveedor. " + e.getMessage());
            }
        } finally {
            session.close();
        }
        return flag;
    }

    public Proveedores consultarProveedor(Integer idProveedor) {
        Proveedores pro = new Proveedores();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            pro = (Proveedores) session.get(Proveedores.class, idProveedor);
            session.getTransaction().commit();
            if (pro == null) {
                System.out.println("Los datos deseados han sido eliminados con aterioridad o no existe.");
            } else {
                System.out.println("Consulta exitosa.");
            }
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                System.out.println("Error al consultar. " + e.getMessage());
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
        System.out.println("Proveedor eliminado exitosamente.");
        try {
            session.beginTransaction(); //EN EL EJEMPLO ESTO ESTA FUERA DEL TRY... EN LA PARTE SUPERIOR
            pro = (Proveedores) session.get(Proveedores.class, idProveedor);
            session.delete(pro);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                System.out.println("Error al eliminar el registro deseado." + e.getMessage());
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
        System.out.println("Listado de proveedores vigente.");
        try {
            session.beginTransaction(); //En el ejemplo esta fuera del try...
            Query q = session.createQuery("from Proveedores");
            listaProveedores = (List<Proveedores>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al mostrar lista. " + e.getMessage());
        } finally {
        }
        return listaProveedores;
    }
}
