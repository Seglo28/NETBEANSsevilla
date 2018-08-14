package usam.mantenimiento;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import persistencia.Usuarios.Fabricantes;
import usam.spring.HibernateUtil;

public class FabricantesMantenimiento {

    public static void main(String[] args) {
        Integer idFabricante;
        String fabricante = "";
        String direccion = "";
        String telefono = "";

        FabricantesMantenimiento mantenimiento = new FabricantesMantenimiento();

        System.out.println();
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

    public Fabricantes consultarFabricantes(Integer idFabricante) {
        Fabricantes fab = new Fabricantes();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            fab = (Fabricantes) session.get(Fabricantes.class, idFabricante);
            session.delete(fab);
            session.getTransaction().commit();
        } catch (Exception ex) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
        }
        return fab;
    }

    public int eliminarFabricantes(Integer idFabricante) {
        Fabricantes fab = new Fabricantes();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        try {
            session.beginTransaction(); //EN EL EJEMPLO ESTO ESTA FUERA DEL TRY... EN LA PARTE SUPERIOR
            fab = (Fabricantes) session.get(Fabricantes.class, idFabricante);
            session.delete(fab);
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

    public List consultarTodosFabricantes() {
        List<Fabricantes> listaFabricantes = null;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        try {
            session.beginTransaction(); //En el ejemplo esta fuera del try...
            Query q = session.createQuery("from Fabricantes");
            listaFabricantes = (List<Fabricantes>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        return listaFabricantes;
    }
}
