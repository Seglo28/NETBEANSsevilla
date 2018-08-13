package usam.mantenimiento;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import persistencia.Usuarios.Clientes;
import usam.spring.HibernateUtil;

public class ClienteMantenimiento {

    public static void main(String[] args) {

        Integer idCliente;
        String cliente;
        String tipoPersona;
        String direccion;
        String telefono;

        ClienteMantenimiento mantenimiento = new ClienteMantenimiento();

        System.out.println();
    }

    public int guardarUsuario(Integer idCliente,
            String cliente,
            String tipoPersona,
            String direccion,
            String telefono) {
        
        SessionFactory factory= HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag=0;
        
        Clientes cli = new Clientes();
        cli.setIdCliente(idCliente);
        cli.setTipoPersona(tipoPersona);
        cli.setDireccion(direccion);
        cli.setTelefono(telefono);
        try{
        session.beginTransaction();
        session.save(cli);
        session.getTransaction().commit();;
        flag=1;
        }catch (Exception e) {
            if(session.getTransaction().isActive()){
                session.getTransaction().rollback();
                flag=1;
            }
        }finally{
                    session.close();
                    }
        return flag;
    }
    
    public Clientes consultarClientes(Integer idCliente){
    Clientes cli = new Clientes();
    SessionFactory factory=HibernateUtil.getSessionFactory();
    Session session = factory.openSession();
    try{
    session.beginTransaction();
    cli = (Clientes) session.get(Clientes.class, idCliente);
    session.getTransaction().commit();
    }catch (Exception ex) {
            if(session.getTransaction().isActive()){
                session.getTransaction().rollback();
            }
        }finally{
        session.close();
    }
    return cli;
    }
    
    public int eliminarClientes(Integer idCliente){
        Clientes cli = new Clientes();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;
        
        try{
        session.beginTransaction(); //EN EL EJEMPLO ESTO ESTA FUERA DEL TRY... EN LA PARTE SUPERIOR
        cli = (Clientes) session.get(Clientes.class, idCliente);
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
    
    public List consultarTodosClientes(){
        List<Clientes> listaClientes=null;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        
        try{
        session.beginTransaction(); //En el ejemplo esta fuera del try...
        Query q = session.createQuery("from Clientes");
        listaClientes = (List<Clientes>)q.list();
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
        }
        return listaClientes;
    }
}