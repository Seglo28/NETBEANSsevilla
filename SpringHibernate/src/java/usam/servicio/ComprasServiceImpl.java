/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usam.servicio;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistencia.Usuarios.Compras;
import usam.DAO.ComprasDAO;

/**
 *
 * @author Admin125
 */
@Service
public class ComprasServiceImpl implements ComprasService{

    @Autowired
    ComprasDAO c;
    
    @Override
    @Transactional
    public void AgregarCompra(Compras com) {
    c.AgregarCompra(com);
    }

    @Override
    @Transactional
    public void ActualizarCompra(Compras com) {
    c.ActualizarCompra(com);
    }

    @Override
    @Transactional
    public List<Compras> MostrarTodosCompras() {
    return c.MostrarTodosCompras();
    }

    @Override
    @Transactional
    public Compras MostrarUnoCompras(Integer idCompra) {
    return c.MostrarUnoCompras(idCompra);
    }

    @Override
    @Transactional
    public void EliminarCompra(Integer idCompra) {
    c.EliminarCompra(idCompra);
    }
   
}