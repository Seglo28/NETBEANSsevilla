package usam.mantenimiento;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import persistencia.Usuarios.Usuario;
import usam.spring.HibernateUtil;

public class UsuariosMantenimiento {

    public static void main(String[] args) {
        Integer idUsuario;
        String usuario="";
        String correo="";
        String contra="";
        String cargo="";

        UsuariosMantenimiento mantenimiento = new UsuariosMantenimiento();

        System.out.println();
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
