package usam.mantenimiento;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import persistencia.Usuarios.Facturas;
import persistencia.Usuarios.Sucursales;
import persistencia.Usuarios.Ventas;
import usam.spring.HibernateUtil;

public class FacturasMantenimiento {

    public static void main(String[] args) {
        int id_factura;
        Ventas ventas;
        String fechaVenta = "";
        Sucursales sucursales;

        FacturasMantenimiento mantenimiento = new FacturasMantenimiento();

        System.out.println();
    }

    public int guardarFacturas(Integer idFactura,
            Ventas ventas,
            String fechaVenta,
            Sucursales sucursales) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        Facturas fac = new Facturas();
        fac.setIdFactura(idFactura);
        fac.setVentas(ventas);
        fac.setFechaVenta(fechaVenta);
        fac.setSucursales(sucursales);

        try {
            session.beginTransaction();
            session.save(fac);
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

    public Facturas consultarFacturas(Integer idFactura) {
        Facturas fac = new Facturas();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            fac = (Facturas) session.get(Facturas.class, idFactura);
            session.delete(fac);
            session.getTransaction().commit();
        } catch (Exception ex) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
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

    public List consultarTodosFacturas() {
        List<Facturas> listaFacturas = null;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        try {
            session.beginTransaction(); //En el ejemplo esta fuera del try...
            Query q = session.createQuery("from Facturas");
            listaFacturas = (List<Facturas>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        return listaFacturas;
    }    
}
