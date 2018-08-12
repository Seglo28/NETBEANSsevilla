package usam.mantenimiento;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import persistencia.Usuarios.Fabricantes;
import usam.spring.HibernateUtil;

public class FabricantesMantenimiento {

    public static void main(String[] args) {
        Integer idFabricante;
        String fabricante = "";
        String direccion = "";
        String telefono = "";

        FabricantesMantenimiento mantenimiento = new FabricantesMantenimiento();

        System.out.println();
    }
     public int guardarFabricantes(Integer idFabricante,
        String fabricante,
        String direccion,
        String telefono ){
         SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;
     
        Fabricantes fabr= new Fabricantes();
        fabr.setIdFabricante(idFabricante);
        fabr.setFabricante(fabricante);
        fabr.setDireccion(direccion);
        fabr.setTelefono(telefono);
      try
        {
           session.beginTransaction();
           session.save(fabr);
           session.getTransaction().commit();
           flag=1;
        }
        catch(Exception e){
            if (session.getTransaction().isActive()){
                session.getTransaction().rollback();
                flag=1;
            }
        }finally
            {
                    session.close();
                    }
            return flag;
     
     }
}
