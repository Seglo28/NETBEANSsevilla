/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usam.servicio;

import java.util.List;
import persistencia.Usuarios.Sucursales;

/**
 *
 * @author Admin125
 */
public interface SucursalesService {
    
    public void AgregarSucursal(Sucursales suc);
    
    public void ActualizarSucursal(Sucursales suc);
    
    public List<Sucursales> MostrarTodosSucursales();
    
    public Sucursales MostrarUnoSucursales(Integer idSucursal);
    
    public void EliminarSucursal (Integer idSucursal);
}