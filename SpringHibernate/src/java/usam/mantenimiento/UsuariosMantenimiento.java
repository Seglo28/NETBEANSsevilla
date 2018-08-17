package usam.mantenimiento;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import persistencia.Usuarios.Usuario;
import usam.spring.HibernateUtil;

public class UsuariosMantenimiento {

    public static void main(String[] args) {

        UsuariosMantenimiento m = new UsuariosMantenimiento();

        /*--- GUARDAR USUARIO ---*/
 /*
        Integer idUsuario = 0;
        String usuario = "Gloria Sevilla";
        String correo="gloria@mysql.com";
        String contra = "root";
        String cargo= "Gerente General";

        m.guardarUsuario(idUsuario, usuario, correo, contra, cargo);
         */
 /*--- CONSULTAR USUARIO ---*/
 /*
        Usuario u = m.consultarUsuario(2);
        System.out.println(u);
         */
 /*--- ELIMINAR USUARIO ---*/
 /*
        m.eliminarUsuario(2);
         */
 /*--- MOSTRAR TODOS ---*/
 /*
        m.consultarTodosUsuario();
         */
 /*--- ACTUALIZAR ---*/
 /*
        m.ActualizarUsuario(3, "Carmen Perez", "carmen@mysql.com", "contra", "Gerente de RRHH");
         */
    }

    public int guardarUsuario(Integer idUsuario, String usuario, String correo, String contra, String cargo) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;
        Usuario usu = new Usuario();
        usu.setIdUsuario(idUsuario);
        usu.setUsuario(usuario);
        usu.setCorreo(correo);
        usu.setContra(contra);
        usu.setCargo(cargo);

        try {
            session.beginTransaction();
            session.save(usu);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("Registro de usuario exitoso.");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 1;
                System.out.println("Error en registro de usuario. " + e.getMessage());
            }
        } finally {
            session.close();
        }
        return flag;
    }

    public int ActualizarUsuario(Integer idUsuario, String usuario, String correo, String contra, String cargo) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;
        Usuario usu = new Usuario();
        usu.setIdUsuario(idUsuario);
        usu.setUsuario(usuario);
        usu.setCorreo(correo);
        usu.setContra(contra);
        usu.setCargo(cargo);

        try {
            session.beginTransaction();
            session.update(usu);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("Actualización de usuario exitosa.");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 1;
                System.out.println("Error en actualización de usuario. " + e.getMessage());
            }
        } finally {
            session.close();
        }
        return flag;
    }

    public Usuario consultarUsuario(Integer idUsuario) {
        Usuario usu = new Usuario();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            usu = (Usuario) session.get(Usuario.class, idUsuario);
            session.getTransaction().commit();
            if (usu != null) {
                System.out.println("Consulta de datos de usuario exitosa.");
            } else {
                System.out.println("Los datos del usuario seleccionado han sido eliminados o nunca se han creado.");
            }
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                System.out.println("Error en consulta de usuario. " + e.getMessage());
            }
        } finally {
            session.close();
        }
        return usu;
    }

    public int eliminarUsuario(Integer idUsuario) {
        Usuario usu = new Usuario();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        try {
            session.beginTransaction(); //EN EL EJEMPLO ESTO ESTA FUERA DEL TRY... EN LA PARTE SUPERIOR
            usu = (Usuario) session.get(Usuario.class, idUsuario);
            session.delete(usu);
            session.getTransaction().commit();
            System.out.println("El usuario se ha eliminado.");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                System.out.println("Error al eliminar usuarios. " + e.getMessage());
            }
            flag = 0;
        } finally {
            session.close();
        }
        return flag;
    }

    public List consultarTodosUsuario() {
        List<Usuario> listaUsuario = null;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        try {
            session.beginTransaction(); //En el ejemplo esta fuera del try...
            Query q = session.createQuery("from Usuario");
            listaUsuario = (List<Usuario>) q.list();
            System.out.println("Lista completa:");
            System.out.println(listaUsuario);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al mostrar lista de usuarios. " + e.getMessage());
        } finally {
        }
        return listaUsuario;
    }
}
