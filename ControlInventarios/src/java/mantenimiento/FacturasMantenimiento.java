package mantenimiento;

import com.myapp.struts.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import persistencia.Facturas;
import persistencia.Sucursales;
import persistencia.Ventas;


public class FacturasMantenimiento {

    public static void main(String[] args) {

        FacturasMantenimiento m = new FacturasMantenimiento();

        /*--- GUARDAR ---*/
 /*
        int id_factura = 0;
        int idVenta = 2;
        String fechaVenta = "aaa";
        int idSucursal = 1;

        int guardar = m.guardarFacturas(id_factura, idVenta, fechaVenta, idSucursal);
        System.out.println(guardar);
         */
 /*--- Actualizar ---*/
 /*
        m.ActualizarFacturas(1, 2, "fechaVenta", 1);
         */
 /*--- CONSULTAR ---*/
 /*
        m.consultarFactura(1);
         */
 /*--- ELIMINAR ---*/
 /*
        m.eliminarFacturas(2);
         */
 /*--- MOSTRAR TODOS ---*/
 /*
        List all = m.consultarTodosFacturas();
        System.out.println(all);
         */
    }

    public int guardarFacturas(Integer idFactura,
            int idVenta,
            String fechaVenta,
            int idSucursal) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        Facturas fac = new Facturas();
        fac.setIdFactura(idFactura);

        Ventas v = new Ventas();
        v.setIdVenta(idVenta);
        fac.setVentas(v);

        fac.setFechaVenta(fechaVenta);

        Sucursales s = new Sucursales();
        s.setIdSucursal(idSucursal);
        fac.setSucursales(s);

        try {
            session.beginTransaction();
            session.save(fac);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("Factura registrada correctamente.");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 1;
                System.out.println("Error de registro. " + e.getMessage());
            }
        } finally {
            session.close();
        }
        return flag;
    }

    public int ActualizarFacturas(Integer idFactura,
            int idVenta,
            String fechaVenta,
            int idSucursal) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        Facturas fac = new Facturas();
        fac.setIdFactura(idFactura);

        Ventas v = new Ventas();
        v.setIdVenta(idVenta);
        fac.setVentas(v);

        fac.setFechaVenta(fechaVenta);

        Sucursales s = new Sucursales();
        s.setIdSucursal(idSucursal);
        fac.setSucursales(s);

        try {
            session.beginTransaction();
            session.update(fac);
            session.getTransaction().commit();
            flag = 1;
            if (fac != null) {
                System.out.println("Factura actualizada correctamente.");
            } else {
                System.out.println("La factura y sus datos han sido eliminados o no se ha creado aún.");
            }
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 1;
                System.out.println("Error de actualización. " + e.getMessage());
            }
        } finally {
            session.close();
        }
        return flag;
    }

    public Facturas consultarFactura(Integer idFactura) {
        Facturas fac = new Facturas();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            fac = (Facturas) session.get(Facturas.class, idFactura);
            session.getTransaction().commit();
            if (fac != null) {
                System.out.println("Factura consultada correctamente.");
            } else {
                System.out.println("La factura y sus datos han sido eliminados o no se ha creado aún.");
            }
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                System.out.println("Error de consulta. " + e.getMessage());
            }
        } finally {
            session.close();
        }
        return fac;
    }

    public int eliminarFacturas(Integer idFactura) {
        Facturas fac = new Facturas();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        try {
            session.beginTransaction(); //EN EL EJEMPLO ESTO ESTA FUERA DEL TRY... EN LA PARTE SUPERIOR
            fac = (Facturas) session.get(Facturas.class, idFactura);
            session.delete(fac);
            session.getTransaction().commit();
            System.out.println("El item seleccionado se ha eliminado.");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                System.out.println("Error al eliminar item. " + e.getMessage());
            }
            flag = 0;
        } finally {
            session.close();
        }
        return flag;
    }

    public List consultarTodosFacturas() {
        List<Facturas> listaFacturas = null;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        System.out.println("Se muestran todas las facturas existentes.");
        try {
            session.beginTransaction(); //En el ejemplo esta fuera del try...
            Query q = session.createQuery("from Facturas");
            listaFacturas = (List<Facturas>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al mostrar. " + e.getMessage());
        } finally {
        }
        return listaFacturas;
    }
}
