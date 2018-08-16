
package usam.servicio;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistencia.Usuarios.Productos;
import usam.DAO.ProductosDAO;

@Service
public class ProductosServiceImpl implements ProductosService{

    @Autowired
    ProductosDAO p;
    
    @Override
    @Transactional
    public void AgregarProducto(Productos pro) {
        p.AgregarProducto(pro);
    }

    @Override
    @Transactional
    public void ActualizarProducto(Productos pro) {
        p.ActualizarProducto(pro);
    }

    @Override
    @Transactional
    public List<Productos> MostrarTodosProductos() {
        return p.MostrarTodosProductos();
    }

    @Override
    @Transactional
    public Productos MostrarUnoProductos(Integer idProducto) {
        return p.MostrarUnoProductos(idProducto);
    }

    @Override
    @Transactional
    public void EliminarProducto(Integer idProducto) {
        p.EliminarProducto(idProducto);
    }
}