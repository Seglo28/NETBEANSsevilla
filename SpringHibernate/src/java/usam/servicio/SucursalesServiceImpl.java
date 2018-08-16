
package usam.servicio;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistencia.Usuarios.Sucursales;
import usam.DAO.SucursalesDAO;

@Service
public class SucursalesServiceImpl implements SucursalesService{

    @Autowired
    SucursalesDAO s;
    
    @Override
    @Transactional
    public void AgregarSucursal(Sucursales suc) {
        s.AgregarSucursal(suc);
    }

    @Override
    @Transactional
    public void ActualizarSucursal(Sucursales suc) {
        s.ActualizarSucursal(suc);
    }

    @Override
    @Transactional
    public List<Sucursales> MostrarTodosSucursales() {
        return s.MostrarTodosSucursales();
    }

    @Override
    @Transactional
    public Sucursales MostrarUnoSucursales(Integer idSucursal) {
        return s.MostrarUnoSucursales(idSucursal);
    }

    @Override
    @Transactional
    public void EliminarSucursal(Integer idSucursal) {
        s.EliminarSucursal(idSucursal);
    }
}