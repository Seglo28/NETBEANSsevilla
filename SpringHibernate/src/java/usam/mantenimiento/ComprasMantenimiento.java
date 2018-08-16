package usam.mantenimiento;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import persistencia.Usuarios.Compras;
import persistencia.Usuarios.Productos;
import persistencia.Usuarios.Proveedores;
import usam.spring.HibernateUtil;

public class ComprasMantenimiento {

public static void main(String[] args) {
        ComprasMantenimiento mant = new ComprasMantenimiento();
        
        /* ------ Guardar -------- */
        
        /*int idCompra = 0;
        int productos = 1;
        int proveedores = 2;
        int cantidad = 20;
        double monto = 6.50;

        int r = mant.guardarCompras(idCompra, productos, proveedores, cantidad, monto); 
        System.exit(0);
        */
        
                /* ----- Actualizar ----- */
        /*
        int actua = mant.ActualizarCompras(3, 1, 2, 444, 222);
       */
        
        /* ----- Consultar ----- */
        /*/
        List<Compras> list;
        list = mant.consultarTodosCompras();
        System.out.println(list);
        System.exit(0);
        */

        /* ----- Eliminar ----- */
        /*
        int borrar = mant.eliminarCompra(2);
*/
        
    }

    public int guardarCompras(int idCompra,
            int idProductos,
            int idProveedores,
            int cantidad,
            double monto
    ) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        Compras com = new Compras();
        com.setIdCompra(idCompra);
        
        Productos producto = new Productos();
        producto.setIdProducto(idProductos);
        com.setProductos(producto);
        
        Proveedores proveedor = new Proveedores();
        proveedor.setIdProveedor(idProveedores);
        com.setProveedores(proveedor);
        
        com.setCantidad(cantidad);
        com.setMonto(monto);

        try {
            session.beginTransaction();
            session.save(com);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("Éxito al guardar Compra");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 1;
                System.out.println("Error al guardar Compra "+e);
            }
        } finally {
            session.close();
        }
        return flag;

    }
    public int ActualizarCompras(int idCompra,
            int idProductos,
            int idProveedores,
            int cantidad,
            double monto
    ) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        Compras com = new Compras();
        com.setIdCompra(idCompra);
        
        Productos producto = new Productos();
        producto.setIdProducto(idProductos);
        com.setProductos(producto);
        
        Proveedores proveedor = new Proveedores();
        proveedor.setIdProveedor(idProveedores);
        com.setProveedores(proveedor);
        
        com.setCantidad(cantidad);
        com.setMonto(monto);

        try {
            session.beginTransaction();
            session.saveOrUpdate(com);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("Si modificó la Compra");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 1;
                System.out.println("No se actualizó la Compra "+e);
            }
        } finally {
            session.close();
        }
        return flag;

    }

    public Compras consultarCompra(int idCompra) {
        Compras com = new Compras();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            com = (Compras) session.get(Compras.class, idCompra);
            session.getTransaction().commit();
            System.out.println("Exito ConsultaPorId Compra");
            return com;
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                System.out.println("Error consultaPorId Compra "+e);
            }
            return null;
        } finally {
            session.close();
        }

    }

    public int eliminarCompra(int idCompra) {
        Compras com = new Compras();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;
       
        try {
            session.beginTransaction();
            com = (Compras) session.get(Compras.class, idCompra);
            session.delete(com);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("Elimina Correctamente Compras");

        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 1;
                System.out.println("Error Eliminar Compra "+e);
            }
        } finally {
            session.close();
        }

        return flag;

    }

    public List consultarTodosCompras() {
        List<Compras> listaCompras = null;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        session.beginTransaction();
        try {
            Query q = session.createQuery("from Compras");
            listaCompras = (List<Compras>) q.list();
            System.out.println("Consulta Exitosa Compras");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Falló consultar Compras");
        } finally {

        }
        return listaCompras;
    }


}