/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usam.servicio;

import java.util.List;
import persistencia.Usuarios.Productos;

/**
 *
 * @author Admin125
 */
public interface ProductosService {
    
    public void AgregarProducto(Productos pro);
    
    public void ActualizarProducto(Productos pro);
    
    public List<Productos> MostrarTodosProductos();
    
    public Productos MostrarUnoProductos(Integer idProducto);
    
    public void EliminarProducto (Integer idProducto);
}