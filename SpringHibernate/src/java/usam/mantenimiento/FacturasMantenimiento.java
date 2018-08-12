
package usam.mantenimiento;
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
  public int guardarFacturas(int id_factura,
        Ventas venta,
        String fechaVenta,
        Sucursales sucursal){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        Facturas fac= new Facturas();
        fac.setIdFactura(id_factura);
        fac.setVentas(venta);
        fac.setFechaVenta(fechaVenta);
        fac.setSucursales(sucursal);
        
         try
        {
           session.beginTransaction();
           session.save(fac);
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
