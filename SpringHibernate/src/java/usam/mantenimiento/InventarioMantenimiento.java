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
        Integer idInventario;
        Productos productos;
        Proveedores proveedores;
        Sucursales sucursales;
        Integer cant;
        Integer stock;
        String estado="";

        InventarioMantenimiento mantenimiento = new InventarioMantenimiento();

        System.out.println();
    }

    public int guardarInventario(
            Integer idInventario,
            Productos productos,
            Proveedores proveedores,
            Sucursales sucursales,
            Integer cant,
            Integer stock,
            String estado
    ) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        Inventario inv = new Inventario();
        inv.setIdInventario(idInventario);
        inv.setProductos(productos);
        inv.setCant(flag);
        inv.setStock(stock);
        inv.setEstado(estado);
        inv.setProveedores(proveedores);
        inv.setSucursales(sucursales);
        try {
            session.beginTransaction();
            session.save(inv);
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

    public Inventario consultarInventario(Integer idInventario) {
        Inventario inv = new Inventario();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            inv = (Inventario) session.get(Inventario.class, idInventario);
            session.getTransaction().commit();
        } catch (Exception ex) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
        }
        return inv;
    }

    public int eliminarInventario(Integer idInventario) {
        Inventario inv = new Inventario();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        try {
            session.beginTransaction(); //EN EL EJEMPLO ESTO ESTA FUERA DEL TRY... EN LA PARTE SUPERIOR
            inv = (Inventario) session.get(Inventario.class, idInventario);
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

    public List consultarTodosInventario() {
        List<Inventario> listaInventario = null;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        try {
            session.beginTransaction(); //En el ejemplo esta fuera del try...
            Query q = session.createQuery("from Inventario");
            listaInventario = (List<Inventario>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        return listaInventario;
    }
}
