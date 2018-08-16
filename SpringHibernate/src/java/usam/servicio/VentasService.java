/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usam.servicio;

import java.util.List;
import persistencia.Usuarios.Ventas;

/**
 *
 * @author Admin125
 */
public interface VentasService {
    
    public void AgregarVentas(Ventas ven);
    
    public void ActualizarVentas(Ventas ven);
    
    public List<Ventas> MostrarTodosVentas();
    
    public Ventas MostrarUnoVentas(Integer idVenta);
    
    public void EliminarVentas (Integer idVenta);
}