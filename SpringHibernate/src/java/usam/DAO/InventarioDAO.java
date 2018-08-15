/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usam.DAO;

import java.util.List;
import persistencia.Usuarios.Inventario;

/**
 *
 * @author Admin125
 */
public interface InventarioDAO {
    
    public void AgregarInventario(Inventario inv);
    
    public void ActualizarInventario(Inventario inv);
    
    public List<Inventario> MostrarTodosInventario();
    
    public Inventario MostrarUnoInventario(Inventario idInventario);
    
    public void EliminarInventario (Integer idInventario);
}