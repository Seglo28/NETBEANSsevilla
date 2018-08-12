package usam.mantenimiento;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import persistencia.Usuarios.Fabricantes;
import persistencia.Usuarios.Productos;
import persistencia.Usuarios.Proveedores;
import usam.spring.HibernateUtil;

public class ProductosMantenimiento {

    public static void main(String[] args) {
        int id_producto;
        String producto = "";
        Fabricantes fabricantes;
        Proveedores proveedores;
        
        ProductosMantenimiento mantenimiento = new ProductosMantenimiento();

        System.out.println();
    }

    public int guardarProducto(int id_producto, String producto,  Proveedores proveedores ,Fabricantes fabricantes) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        Productos prod = new Productos();
        prod.setIdProducto(id_producto);
      prod.setProducto(producto);
        prod.setProveedores(proveedores);
        prod.setFabricantes(fabricantes);

        try {
            session.beginTransaction();
            session.save(prod);
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

}
