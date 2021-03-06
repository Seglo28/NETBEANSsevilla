/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usam.DAO;

import java.util.List;
import persistencia.Usuarios.Proveedores;

/**
 *
 * @author Admin125
 */
public interface ProveedorDAO {
    
    public void AgregarProveedor(Proveedores pro);
    
    public void ActualizarProveedor(Proveedores pro);
    
    public List<Proveedores> MostrarTodosProveedores();
    
    public Proveedores MostrarUnoProveedores(Integer idProveedor);
    
    public void EliminarProveedor (Integer idProveedor);
}