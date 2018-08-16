
package usam.servicio;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistencia.Usuarios.Proveedores;
import usam.DAO.ProveedorDAO;

@Service
public class ProveedorServiceImpl implements ProveedorService{

    @Autowired
    ProveedorDAO p;
    
    @Override
    @Transactional
    public void AgregarProveedor(Proveedores pro) {
        p.AgregarProveedor(pro);
    }

    @Override
    @Transactional
    public void ActualizarProveedor(Proveedores pro) {
        p.ActualizarProveedor(pro);
    }

    @Override
    @Transactional
    public List<Proveedores> MostrarTodosProveedores() {
        return p.MostrarTodosProveedores();
    }

    @Override
    @Transactional
    public Proveedores MostrarUnoProveedores(Integer idProveedor) {
        return p.MostrarUnoProveedores(idProveedor);
    }

    @Override
    @Transactional
    public void EliminarProveedor(Integer idProveedor) {
        p.EliminarProveedor(idProveedor);
    }
}