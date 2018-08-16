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
import persistencia.Usuarios.Fabricantes;
import usam.DAO.FabricantesDAO;

@Service
public class FabricantesServiceImpl implements FabricantesService{

    @Autowired
    FabricantesDAO f;
    
    @Override
    @Transactional
    public void AgregarFabricante(Fabricantes fab) {
        f.AgregarFabricante(fab);
    }

    @Override
    @Transactional
    public void ActualizarFabricante(Fabricantes fab) {
        f.ActualizarFabricante(fab);
    }

    @Override
    @Transactional
    public List<Fabricantes> MostrarTodosFabricantes() {
        return f.MostrarTodosFabricantes();
    }

    @Override
    @Transactional
    public Fabricantes MostrarUnoFabricantes(Integer idFabricante) {
        return f.MostrarUnoFabricantes(idFabricante);
    }

    @Override
    @Transactional
    public void EliminarFabricante(Integer idFabricante) {
        f.EliminarFabricante(idFabricante);
    }
}