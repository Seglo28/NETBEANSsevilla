package usam.mantenimiento;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import persistencia.Usuarios.Compras;
import persistencia.Usuarios.Productos;
import persistencia.Usuarios.Proveedores;
import usam.spring.HibernateUtil;

public class ComprasMantenimiento {

    public static void main(String[] args) {
        Integer idCompra;
        Productos productos;
        Proveedores proveedores;
        Integer cantidad;
        Double monto;

        ComprasMantenimiento mantenimiento = new ComprasMantenimiento();

        System.out.println();
    }

    public int guardarCompras(Integer idCompra,
        Productos productos,
        Proveedores proveedores,
        Integer cantidad,
        Double monto) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        Compras com = new Compras();
        com.setIdCompra(idCompra);
        com.setProductos(productos);
        com.setProveedores(proveedores);
        com.setCantidad(cantidad);
        com.setMonto(monto);
       
        try {
            session.beginTransaction();
            session.save(com);
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
