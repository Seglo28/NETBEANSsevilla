package usam.mantenimiento;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import persistencia.Usuarios.Fabricantes;
import usam.spring.HibernateUtil;

public class FabricantesMantenimiento {

    public static void main(String[] args) {

        FabricantesMantenimiento m = new FabricantesMantenimiento();

        /*--- AGREGAR ---*/
 /*
        Integer idFabricante = 0;
        String fabricante = "Gloria";
        String direccion = "Sierra Morena, Soyapango";
        String telefono = "7869-4826";
        
        int agregar = m.guardarFabricantes(idFabricante, fabricante, direccion, telefono);
        System.out.println(agregar);
         */
 /*--- MOSTRAR UNO ---*/
 /*
        Fabricantes mt = m.consultarFabricante(2);
        System.out.println(mt);
         */
 /*--- ELIMIMAR ---*/
 /*
        m.eliminarFabricante(2);
         */
 /*--- MOSTRAR TODOS ---*/
 /*
        List mt = m.consultarTodosFabricantes();
        System.out.println(mt);
         */
 /*--- MOSTRAR UNO ---*/
 /*
        Fabricantes mu = m.consultarFabricante(2);
        System.out.println(mu);
         */
 /*--- ACTUALIZAR ---*/
 /*
        m.ActualizarFabricantes(3, "fabricante", "direccion", "telefono");
         */
    }

    public int guardarFabricantes(Integer idFabricante,
            String fabricante,
            String direccion,
            String telefono) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        Fabricantes fabr = new Fabricantes();
        fabr.setIdFabricante(idFabricante);
        fabr.setFabricante(fabricante);
        fabr.setDireccion(direccion);
        fabr.setTelefono(telefono);
        try {
            session.beginTransaction();
            session.save(fabr);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("Registro de fabricante exitoso.");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 1;
                System.out.println("Error al intentar registrar fabricante.");
            }
        } finally {
            session.close();
        }
        return flag;
    }

    public int ActualizarFabricantes(Integer idFabricante,
            String fabricante,
            String direccion,
            String telefono) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        Fabricantes fabr = new Fabricantes();
        fabr.setIdFabricante(idFabricante);
        fabr.setFabricante(fabricante);
        fabr.setDireccion(direccion);
        fabr.setTelefono(telefono);
        try {
            session.beginTransaction();
            session.update(fabr);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("Actualización de fabricante exitoso.");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 1;
                System.out.println("Error al intentar actualizar fabricante.");
            }
        } finally {
            session.close();
        }
        return flag;
    }

    public Fabricantes consultarFabricante(Integer idFabricante) {
        Fabricantes fab = new Fabricantes();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            fab = (Fabricantes) session.get(Fabricantes.class, idFabricante);
            session.getTransaction().commit();
            if (fab == null) {
                System.out.println("Los datos sobre el Fabricante solicitado han sido eliminados previamente del sistema.");
            } else {
                System.out.println("Este es el fabricante solicitado.");
            }
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                System.out.println("Error al mostrar dato de fabricante." + e.getMessage());
            }
        } finally {
            session.close();
        }
        return fab;
    }

    public int eliminarFabricante(Integer idFabricante) {
        Fabricantes fab = new Fabricantes();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        try {
            session.beginTransaction(); //EN EL EJEMPLO ESTO ESTA FUERA DEL TRY... EN LA PARTE SUPERIOR
            fab = (Fabricantes) session.get(Fabricantes.class, idFabricante);
            session.delete(fab);
            session.getTransaction().commit();
            System.out.println("Se han eliminado los registros del fabricante seleccionado.");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                System.out.println("Error al eliminar el fabricante. " + e.getMessage());
            }
            flag = 0;
        } finally {
            session.close();
        }
        return flag;
    }

    public List consultarTodosFabricantes() {
        List<Fabricantes> listaFabricantes = null;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        try {
            session.beginTransaction(); //En el ejemplo esta fuera del try...
            Query q = session.createQuery("from Fabricantes");
            listaFabricantes = (List<Fabricantes>) q.list();
            System.out.println("Todos los fabricantes se estan mostrando.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al mostrar todos los fabricantes. " + e.getMessage());
        } finally {
        }
        return listaFabricantes;
    }
}
