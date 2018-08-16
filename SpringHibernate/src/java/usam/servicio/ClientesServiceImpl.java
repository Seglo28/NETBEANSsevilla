
package usam.servicio;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistencia.Usuarios.Clientes;
import usam.DAO.ClientesDAO;

/**
 *
 * @author Admin125
 */
@Service
public class ClientesServiceImpl implements ClientesService {
    @Autowired
    ClientesDAO clientesDAO;

    @Override
    @Transactional
    public void AgregarCliente(Clientes cli) {
        clientesDAO.AgregarCliente(cli);
    }

    @Override
    @Transactional
    public void ActualizarCliente(Clientes cli) {
        clientesDAO.ActualizarCliente(cli);
    }

    @Override
    @Transactional
    public List<Clientes> MostrarTodosClientes() {
        return clientesDAO.MostrarTodosClientes();
    }

    @Override
    @Transactional
    public Clientes MostrarUnoClientes(Integer idCliente) {
        return clientesDAO.MostrarUnoClientes(idCliente);
    }

    @Override
    @Transactional
    public void EliminarCliente(Integer idCliente) {
        clientesDAO.EliminarCliente(idCliente);
    } 
}