
package usam.servicio;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistencia.Usuarios.Facturas;
import usam.DAO.FacturasDAO;

@Service
public class FacturasServiceImpl implements FacturasService {

    @Autowired
    FacturasDAO f;
    
    @Override
    @Transactional
    public void AgregarFactura(Facturas fac) {
        f.AgregarFactura(fac);
    }

    @Override
    @Transactional
    public void ActualizarFactura(Facturas fac) {
        f.ActualizarFactura(fac);
    }

    @Override
    @Transactional
    public List<Facturas> MostrarTodosFacturas() {
        return f.MostrarTodosFacturas();
    }

    @Override
    @Transactional
    public Facturas MostrarUnoFacturas(Integer idFactura) {
        return f.MostrarUnoFacturas(idFactura);
    }

    @Override
    @Transactional
    public void EliminarFactura(Integer idFactura) {
        f.EliminarFactura(idFactura);
    }
}