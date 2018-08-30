package usam.mantenimiento;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import usam.persistencia.Clientes;
import usam.persistencia.Productos;
import usam.persistencia.Usuario;
import usam.persistencia.Ventas;
import usam.spring.HibernateUtil;

public class VentasMantenimiento {

    public static void main(String[] args) {
        VentasMantenimiento vm = new VentasMantenimiento();
        //// ---------------- insertar--------------------//////////
        /*  int idVenta=0;
        int idCliente=1;
        int idProducto=1;
        int idUsuario=1;
        Integer cantidad=1455;
        Double monto=1.0;
        
        
        int r= vm.guardarVenta(idVenta, idCliente,idProducto,idUsuario, cantidad, monto);
        System.out.println();
         */
        //  /---- actualizar---------------////

        /*
        int idVenta=6;
        int idCliente=1;
        int idProducto=3;
        int idUsuario=1;
        Integer cantidad=1455;
        Double monto=1.0;
         int r= vm.ActualizarVenta(idVenta, idCliente, idProducto, idUsuario, cantidad, monto);
         */
        ////----- eliminar-------///////////
        /*
         int idVenta=3;
      int r=vm.eliminarVentas(idVenta);
      System.out.println(r);
        System.exit(0);
         */
     
        //////*********** consultar id*/////////////////////
      /*  int idVenta=5;
        Ventas ven= vm.consultarVentas(idVenta);
        System.out.println(ven.getIdVenta());
        System.out.println(ven.getClientes().getIdCliente());
        System.out.println(ven.getProductos().getIdProducto());
        System.out.println(ven.getUsuario().getIdUsuario());
        System.out.println(ven.getCantidad());
        System.out.println(ven.getMonto());
       
       ////------------- consultar Todos--------------/////
        
*/
      /*
      
      
      List<Ventas>listven=vm.consultarTodosVentas();
     for( Ventas  ven:listven){
         System.out.println(ven.getIdCVentas());
         System.out.println(ven.getIdCliente());
         System.out.println(ven.getIdProducto());
         System.out.println(ven.getIdUsuario());
         System.out.println(ven.getCantidad());
         System.out.println(ven.getMonto());
         System.exit(0);
*/
    }

   
     public int guardarVenta( 
            int idVenta,
            int idClientes,
            int idProductos,
            int idUsuario,
            Integer cantidad,
            Double monto) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        Ventas ven = new Ventas();

        ven.setIdVenta(idVenta);
        Clientes cli=new Clientes();
        cli.setIdCliente(idClientes);
        ven.setClientes(cli);
        
        Productos prod=new Productos();
        prod.setIdProducto(idProductos);
        ven.setProductos(prod);
        
        Usuario usu= new Usuario();
        usu.setIdUsuario(idUsuario);
        ven.setUsuario(usu);
        
        
        ven.setCantidad(cantidad);
        ven.setMonto(monto);

        try {
            session.beginTransaction();
            session.save(ven);
            session.getTransaction().commit();
            flag = 1;
            System.out.println(" exito al guardar la venta");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 1;
                System.out.println(" error al guardar la venta");
            }
        } finally {
            session.close();
        }
        return flag;

    }
    

public int ActualizarVenta(
            int idVenta,
            int idClientes,
            int idProductos,
            int idUsuario,
            Integer cantidad,
            Double monto) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;
       Ventas ven = new Ventas();

        ven.setIdVenta(idVenta);
        Clientes cli=new Clientes();
        cli.setIdCliente(idClientes);
        ven.setClientes(cli);
        
        Productos prod=new Productos();
        prod.setIdProducto(idProductos);
        ven.setProductos(prod);
        
        Usuario usu= new Usuario();
        usu.setIdUsuario(idUsuario);
        ven.setUsuario(usu);
        
        ven.setCantidad(cantidad);
        ven.setMonto(monto);
        try {
            session.beginTransaction();
            session.saveOrUpdate(ven);
            session.getTransaction().commit();
            flag = 1;
            System.out.println(" exito al actualizar la venta");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 1;
                System.out.println(" error al actualizar la venta");
            }
        } finally {
            session.close();
        }
        return flag;

    }


    public Ventas consultarVentas(Integer idVenta) {
        List<Ventas> listaVentas = null;
        Ventas ven = new Ventas();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            ven = (Ventas) session.get(Ventas.class, idVenta);
            
            Query q = session.createQuery("from Ventas where idVenta= " + idVenta);
            listaVentas = (List<Ventas>) q.list();
            System.out.println("exito al consultar la venta");
             
            session.getTransaction().commit();
           return ven;
        } catch (Exception ex) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                System.out.println(" error al  consultar");
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
            flag = 1;
            System.out.println(" exito al eliminar");

        } catch (Exception ex) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 1;
                System.out.println("error al eliminar");
            }

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
            System.out.println("exito al consultar todo");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        return listaVentas;
    }
         }
