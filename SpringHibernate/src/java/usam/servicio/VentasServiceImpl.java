
package usam.servicio;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistencia.Usuarios.Ventas;
import usam.DAO.VentasDAO;

@Service
public class VentasServiceImpl implements VentasService{

    @Autowired
    VentasDAO v;
    
    @Override
    @Transactional
    public void AgregarVentas(Ventas ven) {
        v.AgregarVentas(ven);
    }

    @Override
    @Transactional
    public void ActualizarVentas(Ventas ven) {
        v.ActualizarVentas(ven);
    }

    @Override
    @Transactional
    public List<Ventas> MostrarTodosVentas() {
        return v.MostrarTodosVentas();
    }

    @Override
    @Transactional
    public Ventas MostrarUnoVentas(Integer idVenta) {
        return v.MostrarUnoVentas(idVenta);
    }

    @Override
    @Transactional
    public void EliminarVentas(Integer idVenta) {
        v.EliminarVentas(idVenta);
    }
}