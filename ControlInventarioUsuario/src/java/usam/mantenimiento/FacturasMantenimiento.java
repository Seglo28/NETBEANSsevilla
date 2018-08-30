package usam.mantenimiento;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import usam.persistencia.Facturas;
import usam.persistencia.Sucursales;
import  usam.persistencia.Ventas;
import usam.spring.HibernateUtil;

public class FacturasMantenimiento {

    public static void main(String[] args) {
        FacturasMantenimiento m = new FacturasMantenimiento();
        /*
        int idFactura=0;
        int idVentas=1;
        String fechaVenta = "12/6/93";
        int idSucursales=2;

        FacturasMantenimiento m = new FacturasMantenimiento();
int r=m.guardarFacturas(idFactura, idVentas, fechaVenta, idSucursales);
        
         */
 /*
         int idFactura=3;
        int idVentas=1;
        String fechaVenta = "12/6/93";
        int idSucursales=2;

        FacturasMantenimiento m = new FacturasMantenimiento();
int r=m.ActualizarFacturas(idFactura, idVentas, fechaVenta, idSucursales);
         */
        //// eliminar///////////
        /*
         int idFactura=4;
        int r=m.eliminarFactura(0);
        System.exit(0);
         */

 /*--- MOSTRAR TODOS ---*/
 /* List<Facturas>listfac=m.consultarTodosFacturas();
     for(Facturas fac:listfac){
          System.out.println(fac.getIdFactura());
        System.out.println(fac.getVentas().getIdVenta());
        System.out.println(fac.getFechaVenta());
        System.out.println(fac.getSucursales().getIdSucursal());
         System.exit(0);
        
     }
         */
 /*--- MOSTRAR UNO ---*/
        /*
        int idFactura = 2;
        Facturas fac = m.consultarFactura(idFactura);
        System.out.println(fac.getIdFactura());
        System.out.println(fac.getVentas().getIdVenta());
        System.out.println(fac.getFechaVenta());
        System.out.println(fac.getSucursales().getIdSucursal());

        System.exit(0);
        */
    }

    public int guardarFacturas(
            int idFactura,
            int idVentas,
            String fechaVenta,
            int idSucursales
    ) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        Facturas fac = new Facturas();
        fac.setIdFactura(idFactura);

        Ventas ven = new Ventas();
        ven.setIdVenta(idVentas);
        fac.setVentas(ven);

        fac.setFechaVenta(fechaVenta);

        Sucursales sucur = new Sucursales();
        sucur.setIdSucursal(idSucursales);
        fac.setSucursales(sucur);

        try {
            session.beginTransaction();
            session.save(fac);
            session.getTransaction().commit();
            flag = 1;
            System.out.println(" exito al guaradar al factura");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 1;
                System.out.println("Error al guaradr la factura");
            }
        } finally {
            session.close();
        }
        return flag;

    }

    public int ActualizarFacturas(
            int idFactura,
            int idVentas,
            String fechaVenta,
            int idSucursales
    ) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        Facturas fac = new Facturas();
        fac.setIdFactura(idFactura);

        Ventas ven = new Ventas();
        ven.setIdVenta(idVentas);
        fac.setVentas(ven);

        fac.setFechaVenta(fechaVenta);

        Sucursales sucur = new Sucursales();
        sucur.setIdSucursal(idSucursales);
        fac.setSucursales(sucur);
        try {
            session.beginTransaction();
            session.saveOrUpdate(fac);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("exito al actualizar los datos de la factura");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 1;
                System.out.println(" la factura no se pudo actualizar");
            }
        } finally {
            session.close();
        }
        return flag;

    }

    public Facturas consultarFactura(int idFactura) {
        Facturas fac = new Facturas();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            fac = (Facturas) session.get(Facturas.class, idFactura);
            session.getTransaction().commit();
            System.out.println(" exito al  consultar la factura");
            return fac;
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                System.out.println("error al consultar la factura");
            }

        } finally {
            session.close();
        }
        return fac;

    }

    public int eliminarFactura(int idFactura) {
        Facturas fac = new Facturas();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        try {
            session.beginTransaction();
            fac = (Facturas) session.get(Facturas.class, idFactura);
            session.delete(fac);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("exito al eliminar la factura");

        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 1;
                System.out.println("no se pudo eliminar la factura");
            }

        } finally {
            session.close();
        }

        return flag;

    }

    public List consultarTodosFacturas() {
        List<Facturas> listaFacturas = null;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        session.beginTransaction();
        try {
            Query q = session.createQuery("from Facturas");
            listaFacturas = (List<Facturas>) q.list();
            System.out.println("exito al consultar las facturas");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al consultar las facturas");
        } finally {

        }
        return listaFacturas;
    }

}
