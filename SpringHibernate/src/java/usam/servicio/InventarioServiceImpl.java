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
import persistencia.Usuarios.Inventario;
import usam.DAO.InventarioDAO;

@Service
public class InventarioServiceImpl implements InventarioService{

    @Autowired
    InventarioDAO i;
    
    @Override
    @Transactional
    public void AgregarInventario(Inventario inv) {
        i.AgregarInventario(inv);
    }

    @Override
    @Transactional
    public void ActualizarInventario(Inventario inv) {
        i.ActualizarInventario(inv);
    }

    @Override
    @Transactional
    public List<Inventario> MostrarTodosInventario() {
        return i.MostrarTodosInventario();
    }

    @Override
    @Transactional
    public Inventario MostrarUnoInventario(Inventario idInventario) {
        return i.MostrarUnoInventario(idInventario);
    }

    @Override
    @Transactional
    public void EliminarInventario(Integer idInventario) {
        i.EliminarInventario(idInventario);
    }
}