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
        Integer idVenta;
        Clientes clientes;
        Productos productos;
        Usuario usuario;
        Integer cantidad;
        Double monto;

        VentasMantenimiento mantenimiento = new VentasMantenimiento();

        System.out.println();
    }

    public int guardarVenta(Integer idVenta,
            Clientes clientes,
            Productos productos,
            Usuario usuario,
            Integer cantidad,
            Double monto) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        Ventas ven = new Ventas();

        ven.setIdVenta(idVenta);
        ven.setClientes(clientes);
        ven.setProductos(productos);
        ven.setUsuario(usuario);
        ven.setCantidad(cantidad);
        ven.setMonto(monto);

        try {
            session.beginTransaction();
            session.save(ven);
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

    public Ventas consultarVentas(Integer idVenta) {
        Ventas ven = new Ventas();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            ven = (Ventas) session.get(Ventas.class, idVenta);
            session.getTransaction().commit();
        } catch (Exception ex) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
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

    public List consultarTodosVentas() {
        List<Ventas> listaVentas = null;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        try {
            session.beginTransaction(); //En el ejemplo esta fuera del try...
            Query q = session.createQuery("from Ventas");
            listaVentas = (List<Ventas>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        return listaVentas;
    }
}
