/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usam.DAO;

import java.util.List;
import persistencia.Usuarios.Compras;

/**
 *
 * @author Admin125
 */
public interface ComprasDAO {
   
    public void AgregarCompra(Compras com);
    
    public void ActualizarCompra(Compras com);
    
    public List<Compras> MostrarTodosCompras();
    
    public Compras MostrarUnoCompras (Integer idCompra);
}