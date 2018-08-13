package usam.mantenimiento;

import java.util.List;
import org.hibernate.Query;
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

    public Usuario consultarUsuario(Integer idUsuario){
    Usuario usu = new Usuario();
    SessionFactory factory=HibernateUtil.getSessionFactory();
    Session session = factory.openSession();
    try{
    session.beginTransaction();
    usu = (Usuario) session.get(Usuario.class, idUsuario);
    session.getTransaction().commit();
    }catch (Exception ex) {
            if(session.getTransaction().isActive()){
                session.getTransaction().rollback();
            }
        }finally{
        session.close();
    }
    return usu;
    }
    
    public int eliminarUsuario(Integer idUsuario){
        Usuario usu = new Usuario();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;
        
        try{
        session.beginTransaction(); //EN EL EJEMPLO ESTO ESTA FUERA DEL TRY... EN LA PARTE SUPERIOR
        usu = (Usuario) session.get(Usuario.class, idUsuario);
        }catch (Exception ex) {
            if(session.getTransaction().isActive()){
                session.getTransaction().rollback();
            }
            flag=0;
        } finally{
            session.close();
        }
        return flag;
    }
    
    public List consultarTodosUsuario(){
        List<Usuario> listaUsuario=null;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        
        try{
        session.beginTransaction(); //En el ejemplo esta fuera del try...
        Query q = session.createQuery("from Usuario");
        listaUsuario = (List<Usuario>)q.list();
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
        }
        return listaUsuario;
    }
}