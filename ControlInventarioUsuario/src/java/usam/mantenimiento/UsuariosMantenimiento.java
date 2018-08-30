package usam.mantenimiento;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import  usam.persistencia.Usuario;
import usam.spring.HibernateUtil;

public class UsuariosMantenimiento {

    public static void main(String[] args) {
          UsuariosMantenimiento um = new UsuariosMantenimiento(); 
        /////------ guardar-/////////
      /*  int idUsuario=0;
        String usuario="ghdu";
        String correo="@hgusdjh.com";
        String contra="si";
        String cargo="no";

     
     int r= um.guardarUsuarios(0, usuario, correo, contra, cargo);
        System.exit(0);
*/
      ////////////////actualizar/////////////////
      /*
      int idUsuario=1;
        String usuario="Vos";
        String correo="@Vali_todavia";
        String contra="vergussi";
        String cargo="com";
        
        int r= um.ActualizarUsuarios(idUsuario, usuario, correo, contra, cargo);
        */
      ///----------- borrar-----------/////
      
      /*int r=um.eliminarUsuario(6);
        System.exit(0);
*/
        //// mostrar///////////
       /* List<Usuario>listu=um.consultarTodosUsuarios();
         for( Usuario u:listu){
         System.out.println(u.getIdUsuario());
         System.out.println(u.getUsuario());
         System.out.println(u.getCorreo());
         System.out.println(u.getContra());
         System.out.println(u.getCargo());
         System.exit(0);
     }
       /*  List<Usuario> list;
        list = um.consultarTodosUsuarios();
        System.out.println(list);
        System.exit(0);
      */
       ////////////////////// mostrar por id///////////////////////
        /*  int  idusuarios=3;
      Usuario usu =um.consultarUsuario(idusuarios);
        System.out.println(usu.getIdUsuario());
        System.out.println(usu.getUsuario());
        System.out.println(usu.getCorreo());
        System.out.println(usu.getContra());
        System.out.println(usu.getCargo());
*/
    }

    public int guardarUsuarios(
            int idUsuario, String usuario, String correo, String contra, String cargo) {

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
            System.out.println("Exito al guardar el usuario");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 1;
                System.out.println(" error al guadar el usuario");
            }
        } finally {
            session.close();
        }
        return flag;
    }

    public int ActualizarUsuarios(
            int idUsuario, String usuario, String correo, String contra, String cargo) {

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
            session.saveOrUpdate(usu);

            session.getTransaction().commit();
            flag = 1;
            System.out.println("exito al actualizar  los datos  del usuario");
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 1;
                System.out.println(" error al actualizar adtos del usuario");
            }
        } finally {
            session.close();
        }
        return flag;
    }

    public Usuario consultarUsuario(int idUsuario) {
        Usuario usu = new Usuario();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        try {
            session.beginTransaction();
            usu = (Usuario) session.get(Usuario.class, idUsuario);
            session.getTransaction().commit();
            System.out.println(" exito al mostrar usuario");
            return usu;
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                System.out.println("ocurrio un erro al consultar el usuario"+e);
            }

        } finally {
            session.close();
        }
        return usu;

    }

    public int eliminarUsuario(int idUsuario) {
        Usuario usu = new Usuario();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        int flag = 0;
     
        try {
            
            session.beginTransaction();
            usu = (Usuario) session.get(Usuario.class, idUsuario);
            session.delete(usu);
            session.getTransaction().commit();
            flag = 1;
            System.out.println("exito al eliminar el usuario seleccionado");
            

        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 1;
                System.out.println(" error al eliminar  ususario"+e);
            }
          
        } finally {
            session.close();
        }

        return flag;

    }

    public List consultarTodosUsuarios() {
        List<Usuario> listaUsuario = null;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        session.beginTransaction();
        try {
            Query q = session.createQuery("from Usuario");
            listaUsuario = (List<Usuario>) q.list();
            System.out.println(" exito al consultar los datos de usuarios");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(" error al consultar los usuarios");
        } finally {

        }
        return listaUsuario;
    }

}
