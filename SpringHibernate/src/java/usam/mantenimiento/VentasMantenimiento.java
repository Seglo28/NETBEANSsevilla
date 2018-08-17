package usam.mantenimiento;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import persistencia.Usuarios.Clientes;
import persistencia.Usuarios.Productos;
import persistencia.Usuarios.Usuario;
import persistencia.Usuarios.Ventas;
import usam.spring.HibernateUtil;

public class VentasMantenimiento {

    public static void main(String[] args) {

        VentasMantenimiento m = new VentasMantenimiento();

        /*--- GUARDAR ---*/
 /*
        Integer idVenta = 0;
        int idProducto = 1;
        Integer cantidad = 28;
        Double monto = 502.50;
        int idCliente = 4;        
        int idUsuario = 3;
        
        m.guardarVenta(idVenta, idProducto, cantidad, monto, idCliente, idUsuario);
        
         */

 /*---   MOSTRAR UNO ---*/
 /*
            m.consultarVenta(2);
         */
 /*--- ELIMINAR ---*/
 /*
        m.eliminarVentas(1);
         */
 /*--- MOSTRAR TODOS ---*/
 /*
        m.consultarTodosVentas();
         */
 /*--- MOSTRAR TODOS ---*/
 /*
        m.ActualizarVenta(2, 1, 4562, 12.47, 4, 3);
         */
    }

    public int guardarVenta(Integer idVenta,
            int idProducto,
            Integer cantidad,
            Double monto,
            int idCliente,
            int idUsuario) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        Ventas ven = new Ventas();

        ven.setIdVenta(idVenta);

        Productos p = new Productos();
        p.setIdProducto(idProducto);
        ven.setProductos(p);

        ven.setCantidad(cantidad);
        ven.setMonto(monto);

        Clientes c = new Clientes();
        c.setIdCliente(idCliente);
        ven.setClientes(c);

        Usuario u = new Usuario();
        u.setIdUsuario(idUsuario);
        ven.setUsuario(u);

        try {
            session.beginTransaction();
            session.save(ven);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("Registro guardado.");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 1;
                System.out.println("Error al ingresar datos. " + e.getMessage());
            }
        } finally {
            session.close();
        }
        return flag;

    }

    public int ActualizarVenta(Integer idVenta,
            int idProducto,
            Integer cantidad,
            Double monto,
            int idCliente,
            int idUsuario) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        Ventas ven = new Ventas();

        ven.setIdVenta(idVenta);

        Productos p = new Productos();
        p.setIdProducto(idProducto);
        ven.setProductos(p);

        ven.setCantidad(cantidad);
        ven.setMonto(monto);

        Clientes c = new Clientes();
        c.setIdCliente(idCliente);
        ven.setClientes(c);

        Usuario u = new Usuario();
        u.setIdUsuario(idUsuario);
        ven.setUsuario(u);

        try {
            session.beginTransaction();
            session.update(ven);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("Actualización guardada.");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 1;
                System.out.println("Error al actualizar datos. " + e.getMessage());
            }
        } finally {
            session.close();
        }
        return flag;

    }

    public Ventas consultarVenta(Integer idVenta) {
        Ventas ven = new Ventas();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            ven = (Ventas) session.get(Ventas.class, idVenta);
            session.getTransaction().commit();
            if (ven != null) {
                System.out.println("Mostrar informacion exitosa.");
            } else {
                System.out.println("La información solicitada ha sido eliminada de la base o no esta creada.");
            }
        } catch (Exception ex) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                System.out.println("Error al mostrar información de venta");
            }
        } finally {
            session.close();
        }
        return ven;
    }

    public int eliminarVentas(Integer idVenta) {
        Ventas ven = new Ventas();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        try {
            session.beginTransaction(); //EN EL EJEMPLO ESTO ESTA FUERA DEL TRY... EN LA PARTE SUPERIOR
            ven = (Ventas) session.get(Ventas.class, idVenta);
            session.delete(ven);
            session.getTransaction().commit();
            System.out.println("La información se ha eliminado.");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                System.out.println("Error al eliminar información. " + e.getMessage());
            }
            flag = 0;
        } finally {
            session.close();
        }
        return flag;
    }

    public List consultarTodosVentas() {
        List<Ventas> listaVentas = null;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        try {
            session.beginTransaction(); //En el ejemplo esta fuera del try...
            Query q = session.createQuery("from Ventas");
            listaVentas = (List<Ventas>) q.list();
            System.out.println("Estas son todas las ventas realizadas.");
            System.out.println(listaVentas);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al mostrar ventas realizadas. ");
        } finally {
        }
        return listaVentas;
    }
}
