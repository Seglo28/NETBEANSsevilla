package usam.mantenimiento;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import persistencia.Usuarios.Fabricantes;
import persistencia.Usuarios.Productos;
import persistencia.Usuarios.Proveedores;
import usam.spring.HibernateUtil;

public class ProductosMantenimiento {

    public static void main(String[] args) {
        Integer idProducto;
        String producto = "";
        Fabricantes fabricantes;
        Proveedores proveedores;

        ProductosMantenimiento mantenimiento = new ProductosMantenimiento();

        System.out.println();
    }

    public int guardarProducto(Integer idProducto,
            String producto,
            Proveedores proveedores,
            Fabricantes fabricantes) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        Productos prod = new Productos();
        prod.setIdProducto(idProducto);
        prod.setProducto(producto);
        prod.setProveedores(proveedores);
        prod.setFabricantes(fabricantes);

        try {
            session.beginTransaction();
            session.save(prod);
            session.delete(prod);
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

    public Productos consultarProductos(Integer idProducto) {
        Productos pro = new Productos();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            pro = (Productos) session.get(Productos.class, idProducto);
            session.getTransaction().commit();
        } catch (Exception ex) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
        }
        return pro;
    }

    public int eliminarProductos(Integer idProducto) {
        Productos pro = new Productos();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        try {
            session.beginTransaction(); //EN EL EJEMPLO ESTO ESTA FUERA DEL TRY... EN LA PARTE SUPERIOR
            pro = (Productos) session.get(Productos.class, idProducto);
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

    public List consultarTodosProductos() {
        List<Productos> listaProductos = null;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        try {
            session.beginTransaction(); //En el ejemplo esta fuera del try...
            Query q = session.createQuery("from Productos");
            listaProductos = (List<Productos>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        return listaProductos;
    }
}
