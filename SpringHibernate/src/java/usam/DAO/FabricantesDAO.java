/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usam.DAO;

import java.util.List;
import persistencia.Usuarios.Fabricantes;

/**
 *
 * @author Admin125
 */
public interface FabricantesDAO {
    
    public void AgregarFabricante(Fabricantes fab);
    
    public void ActualizarFabricante(Fabricantes fab);
    
    public List<Fabricantes> MostrarTodosFabricantes();
    
    public Fabricantes MostrarUnoFabricantes (Integer idFabricante);
    
    public void EliminarFabricante (Integer idFabricante);
}