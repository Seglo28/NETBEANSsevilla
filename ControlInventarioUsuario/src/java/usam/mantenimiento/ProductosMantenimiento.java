package usam.mantenimiento;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import  usam.persistencia.Fabricantes;
import  usam.persistencia.Productos;
import  usam.persistencia.Proveedores;
import usam.spring.HibernateUtil;

public class ProductosMantenimiento {

    public static void main(String[] args) {
        int idProducto=1;
        int idFabricantes=1;
        int idProveedores=1;
        String producto=" coasa";

        ProductosMantenimiento man = new ProductosMantenimiento();
 int r=man.guardarProductos(idProducto, idFabricantes, idProveedores, producto);
        System.out.println();
    }

   public int guardarProductos(
            int idProducto,
            int idFabricantes,
            int idProveedores,
            String producto) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;
        Productos prod = new Productos();
        prod.setProducto(producto);
        
        Fabricantes fabr=new Fabricantes();
        fabr.setIdFabricante(idFabricantes);
        prod.setFabricantes(fabr);
        
        Proveedores prov= new Proveedores();
        prov.setIdProveedor(idProveedores);
        prod.setProveedores(prov);
        
        prod.setProducto(producto);
        try {
            session.beginTransaction();
            session.save(prod);
            session.getTransaction().commit();
            flag = 1;
            System.out.println(" exito al  guardar  el producto");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 1;
                 System.out.println(" error el ingresar los datos del porducto");
            }
        } finally {
            session.close();
        }
        return flag;
    }
     public int ActualizarProductos(
            int idProducto,
            int idFabricantes,
            int idProveedores,
            String producto) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;
      Productos prod = new Productos();
        prod.setProducto(producto);
        
        Fabricantes fabr=new Fabricantes();
        fabr.setIdFabricante(idFabricantes);
        prod.setFabricantes(fabr);
        
        Proveedores prov= new Proveedores();
        prov.setIdProveedor(idProveedores);
        prod.setProveedores(prov);
        
        prod.setProducto(producto);
        try {
            session.beginTransaction();
            session.saveOrUpdate(prod);
            session.getTransaction().commit();
            flag = 1;
             System.out.println(" exito al actualizar el producto");
             
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 1;
                 System.out.println(" error al  actualizar el producto");
            }
        } finally {
            session.close();
        }
        return flag;
    }

    public Productos consultarProducto(int idProducto) {
        Productos prod = new Productos();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        try {
            session.beginTransaction();
            prod = (Productos) session.get(Productos.class, idProducto);
            session.getTransaction().commit();
             System.out.println(" exito al consulatar los datos de producto");
             return prod;
            
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                 System.out.println(" error al consultar el productos");
            }

        } finally {
            session.close();
        }
        return prod;

    }

    public int eliminarProducto(int idProducto) {
        Productos prod = new Productos();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        int flag = 0;
       
        try {
            session.beginTransaction();
            prod = (Productos) session.get(Productos.class, idProducto);
            session.delete(prod);

            session.getTransaction().commit();
              flag = 1;
             System.out.println(" exito al eliminar el producto");
         

        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag=1;
                 System.out.println(" error al eliminar  el producto");
            }
          
        } finally {
            session.close();
        }

        return flag;

    }

    public List consultarTodosProductos() {
        List<Productos> listaProductos = null;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        session.beginTransaction();
        try {
            Query q = session.createQuery("from Productos");
            listaProductos = (List<Productos>) q.list();
             System.out.println(" exitpo al al consulatr los productos");

        } catch (Exception e) {
            e.printStackTrace();
             System.out.println(" error al consulatr los productos");
        } finally {

        }
        return listaProductos;
    }

}
