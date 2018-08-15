
package usam.DAO;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import persistencia.Usuarios.Clientes;

/**
 *
 * @author Admin125
 */
@Repository
public class ClientesDAOImpl implements ClientesDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void AgregarCliente(Clientes cli) {
        sessionFactory.getCurrentSession().save(cli);
    }

    @Override
    public void ActualizarCliente(Clientes cli) {
        sessionFactory.getCurrentSession().update(cli);
    }

    @Override
    public List<Clientes> MostrarTodosClientes() {
        return sessionFactory.getCurrentSession().createQuery("FROM clientes").list();
    }

    @Override
    public Clientes MostrarUnoClientes(Integer idCliente) {
        Session session = sessionFactory.getCurrentSession();
        List<Clientes> list = session.createQuery("FROM clientes cli WHERE cli.idCliente=:idCliente").setParameter("idCliente", idCliente).list();
        return list.size()>0?(Clientes)list.get(0):null;
    }

    @Override
    public void EliminarCliente(Integer idCliente) {
        Clientes cli = (Clientes)sessionFactory.getCurrentSession().load(Clientes.class, idCliente);
        if(cli!=null){
            sessionFactory.getCurrentSession().delete(cli);
        }
    } 
}