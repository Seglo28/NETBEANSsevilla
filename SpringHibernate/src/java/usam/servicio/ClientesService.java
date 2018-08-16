
package usam.servicio;

import java.util.List;
import persistencia.Usuarios.Clientes;

/**
 *
 * @author Admin125
 */
public interface ClientesService {
    
    public void AgregarCliente(Clientes cli);
    
    public void ActualizarCliente(Clientes cli);
    
    public List<Clientes> MostrarTodosClientes();
    
    public Clientes MostrarUnoClientes(Integer idCliente);
    
    public void EliminarCliente (Integer idCliente);
}