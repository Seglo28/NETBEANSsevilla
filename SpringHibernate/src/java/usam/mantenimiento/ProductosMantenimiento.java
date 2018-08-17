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
        ProductosMantenimiento m = new ProductosMantenimiento();

        /*--- GUARDAR ---*/
 /*
        Integer idProducto=0;
        String producto = "Quesos de oriente";
        int idProveedor = 2;
        int idFabricante = 1;

        int guardar = m.guardarProducto(idProducto, producto, idProveedor, idFabricante);
         */
 /*--- MOSTRAR UNO ---*/
 /*
        Productos mu = m.consultarProducto(1);
        System.out.println(mu);
         */
 /*--- ELIMINAR ---*/
 /*
        m.eliminarProducto(2);
         */
 /*--- MOSTRAR TODOS ---*/
 /*
        List mt = m.consultarTodosProductos();
        System.out.println(mt);
         */
 /*--- ACTUALIZAR ---*/
 /*
        m.ActualizarProducto(3, "producto", 2, 1);
         */
    }

    public int guardarProducto(Integer idProducto,
            String producto,
            int idProveedor,
            int idFabricante) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        Productos prod = new Productos();
        prod.setIdProducto(idProducto);
        prod.setProducto(producto);

        Proveedores p = new Proveedores();
        p.setIdProveedor(idProveedor);
        prod.setProveedores(p);

        Fabricantes f = new Fabricantes();
        f.setIdFabricante(idFabricante);
        prod.setFabricantes(f);

        try {
            session.beginTransaction();
            session.save(prod);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("Producto registrado exitosamente.");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 1;
                System.out.println("Error en registro de productos.");
            }
        } finally {
            session.close();
        }
        return flag;
    }

    public int ActualizarProducto(Integer idProducto,
            String producto,
            int idProveedor,
            int idFabricante) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        Productos prod = new Productos();
        prod.setIdProducto(idProducto);
        prod.setProducto(producto);

        Proveedores p = new Proveedores();
        p.setIdProveedor(idProveedor);
        prod.setProveedores(p);

        Fabricantes f = new Fabricantes();
        f.setIdFabricante(idFabricante);
        prod.setFabricantes(f);

        try {
            session.beginTransaction();
            session.update(prod);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("Producto actualizado exitosamente.");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 1;
                System.out.println("Error en actualizacion de productos.");
            }
        } finally {
            session.close();
        }
        return flag;
    }

    public Productos consultarProducto(Integer idProducto) {
        Productos pro = new Productos();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            pro = (Productos) session.get(Productos.class, idProducto);
            session.getTransaction().commit();
            System.out.println("Consulta exitosa.");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                System.out.println("Error en consulta. " + e.getMessage());
            }
        } finally {
            session.close();
        }
        return pro;
    }

    public int eliminarProducto(Integer idProducto) {
        Productos pro = new Productos();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        try {
            session.beginTransaction(); //EN EL EJEMPLO ESTO ESTA FUERA DEL TRY... EN LA PARTE SUPERIOR
            pro = (Productos) session.get(Productos.class, idProducto);
            session.delete(pro);
            session.getTransaction().commit();
            System.out.println("Se elimino el registro seleccionado exitosamente");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                System.out.println("Error al eliminar registro. " + e.getMessage());
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
            System.out.println("Se esta mostrando la lista de productos");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al mostrar lista de productos");
        } finally {
        }
        return listaProductos;
    }
}
