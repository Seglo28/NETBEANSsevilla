package usam.mantenimiento;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import persistencia.Usuarios.Inventario;
import persistencia.Usuarios.Productos;
import persistencia.Usuarios.Proveedores;
import persistencia.Usuarios.Sucursales;
import usam.spring.HibernateUtil;

public class InventarioMantenimiento {

    public static void main(String[] args) {
        
        InventarioMantenimiento mant = new InventarioMantenimiento();
        
        /*-- GUARDAR --*/
        
        int idInventario = 0;
        int idProducto = 1;
        int cant = 7;
        int stock = 3;
        String estado = "Bisexual";
        int idProveedor = 2;
        int idSucursal = 1;
        
        int r = mant.guardarInventario(idInventario, idProducto, cant, stock, estado, idProveedor, idSucursal);
        System.exit(0);
    }

    public int guardarInventario(
        Integer idInventario,
        int idProducto,
        Integer cant,
        Integer stock,
        String estado,
        int idProveedor,
        int idSucursal
    ) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        Inventario inv = new Inventario();
        inv.setIdInventario(idInventario);
        //A CONTINUACIÓN INSTANCIAMOS A LA CLASE PRODUCTOS, LA CUAL CONTRIBUYE CON LLAVE FORANEA
        //LE PUSIMOS "r" COMO OBJETO PORQUE YA HABIAMOS UTILIZADO "p"; ESTA EN LA INSTANCIA DE PROVEEDORES
        Productos r = new Productos();
        r.setIdProducto(idProducto);
        inv.setProductos(r);
        
        //LO DE AQUI ES PROPIO DE LA TABLA INVENTARIOS
        inv.setCant(cant);
        inv.setStock(stock);
        inv.setEstado(estado);
        
        //A CONTINUACIÓN INSTANCIAMOS A LA CLASE PROVEEDORES, LA CUAL CONTRIBUYE CON LLAVE FORANEA
        Proveedores prov = new Proveedores(); 
        prov.setIdProveedor(idProveedor);
        inv.setProveedores(prov);
        
        //A CONTINUACIÓN INSTANCIAMOS A LA CLASE SUCURSALES, LA CUAL CONTRIBUYE CON LLAVE FORANEA
        Sucursales s = new Sucursales();
        s.setIdSucursal(idSucursal);
        inv.setSucursales(s);
        
        try {
            session.beginTransaction();
            session.save(inv);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("Se ha guardado el inventario.");
            
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 1;
            System.out.println("Ha ocurrido un error al guardar el inventario "+e);
            }
        } finally {
            session.close();
        }
        return flag;
    }

    /*ACTUALIZAR*/
    
    public int ActualizarInventario(
            Integer idInventario,
        int idProducto,
        Integer cant,
        Integer stock,
        String estado,
        int idProveedor,
        int idSucursal
    ) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        Inventario inv = new Inventario();
        inv.setIdInventario(idInventario);
        //A CONTINUACIÓN INSTANCIAMOS A LA CLASE PRODUCTOS, LA CUAL CONTRIBUYE CON LLAVE FORANEA
        //LE PUSIMOS "r" COMO OBJETO PORQUE YA HABIAMOS UTILIZADO "p"; ESTA EN LA INSTANCIA DE PROVEEDORES
        Productos r = new Productos();
        r.setIdProducto(idProducto);
        inv.setProductos(r);
        
        //LO DE AQUI ES PROPIO DE LA TABLA INVENTARIOS
        inv.setCant(cant);
        inv.setStock(stock);
        inv.setEstado(estado);
        
        //A CONTINUACIÓN INSTANCIAMOS A LA CLASE PROVEEDORES, LA CUAL CONTRIBUYE CON LLAVE FORANEA
        Proveedores p = new Proveedores(); 
        p.getIdProveedor();
        inv.setProveedores(p);
        //A CONTINUACIÓN INSTANCIAMOS A LA CLASE SUCURSALES, LA CUAL CONTRIBUYE CON LLAVE FORANEA
        Sucursales s = new Sucursales();
        s.setIdSucursal(idSucursal);
        inv.setSucursales(s);
        try {
            session.beginTransaction();
            session.update(inv);
            session.getTransaction().commit();;
            flag = 1;
            System.out.println("Se ha actualizado el inventario.");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 1;
                System.out.println("Error al tratar de actualizar el inventario.");
            }
        } finally {
            session.close();
        }
        return flag;
    }
        
        /*-------------------------------------*/
    
    public Inventario consultarInventario(Integer idInventario) {
        Inventario inv = new Inventario();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            inv = (Inventario) session.get(Inventario.class, idInventario);
            session.getTransaction().commit();
            System.out.println("Consulta de inventario exitosa.");
            return inv;
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                System.out.println("Error al intentar consultar "+e.getMessage());
            }
            return null;
        } finally {
            session.close();
        }
    }

    public int eliminarInventario(Integer idInventario) {
        Inventario inv = new Inventario();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        try {
            session.beginTransaction();
            inv = (Inventario) session.get(Inventario.class, idInventario);
            //Error comun en todos los metodos eliminar
            session.delete(inv);
            session.getTransaction().commit();
            //-----------------------------------------
            flag = 1;
            System.out.println("Registro eliminado.");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 1;
                System.out.println("Algo a fallado por ello el registro no se elimino"+e.getMessage());
            }
        } finally {
            session.close();
        }
        return flag;
    }

    public List consultarTodosInventario() {
        List<Inventario> listaInventario = null;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        try {
            session.beginTransaction(); //En el ejemplo esta fuera del try...
            Query q = session.createQuery("from Inventario");
            listaInventario = (List<Inventario>) q.list();
            System.out.println("Consulta de inventario exitosa");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error interno al momento de consultar compras");
        } finally {
        }
        return listaInventario;
    }
}
