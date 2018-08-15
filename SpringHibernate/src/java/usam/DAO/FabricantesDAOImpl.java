/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usam.DAO;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import persistencia.Usuarios.Fabricantes;

/**
 *
 * @author Admin125
 */
public class FabricantesDAOImpl implements FabricantesDAO{

    @Autowired
    private SessionFactory sf;
    
    @Override
    public void AgregarFabricante(Fabricantes fab) {
        sf.getCurrentSession().save(fab);
    }

    @Override
    public void ActualizarFabricante(Fabricantes fab) {
        sf.getCurrentSession().update(fab);
    }

    @Override
    public List<Fabricantes> MostrarTodosFabricantes() {
        return sf.getCurrentSession().createQuery("FROM fabricantes").list();
    }

    @Override
    public Fabricantes MostrarUnoFabricantes(Integer idFabricante) {
        Session s = sf.getCurrentSession();
        List<Fabricantes> list = s.createQuery("FROM fabricantes fab WHERE fab.idFabricante=:idFabricante").setParameter("idFabricante", idFabricante).list();
        return list.size()>0?(Fabricantes)list.get(0):null;
    }

    @Override
    public void EliminarFabricante(Integer idFabricante) {
        Fabricantes fab = (Fabricantes)sf.getCurrentSession().load(Fabricantes.class, idFabricante);
        if(fab!=null){
            sf.getCurrentSession().delete(fab);
        }
    }

}