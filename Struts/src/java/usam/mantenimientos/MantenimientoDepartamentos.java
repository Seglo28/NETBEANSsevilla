
package usam.mantenimientos;

import java.util.Iterator;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import java.util.List;
import com.myapp.struts.HibernateUtil;

import usam.persistencia.Departamentos;
        

public class MantenimientoDepartamentos {
    
    public static void main(String [] args){
        MantenimientoDepartamentos man=new MantenimientoDepartamentos();
        System.out.println(man.guardarDepartamento("05", "Chalatenango"));
        Departamentos dep=man.consultarDepartamento("05");
        System.out.println("Codigo Departamento: "+ dep.getCodigoDepartamento());
        System.out.println("Nombre Departamento: "+ dep.getDepartamento());
        
    }
    public int guardarDepartamento(String codigoDepartamento,String nombreDepartamento){
        SessionFactory factory= HibernateUtil.getSessionFactory();
        Session session=factory.openSession();
        int flag=0;
        
        Departamentos dep= new Departamentos();
        dep.setCodigoDepartamento(codigoDepartamento);
        dep.setDepartamento(nombreDepartamento);
        java.util.Date hoy=new java.util.Date();
        dep.setFechaCreacion(hoy);
        
        session.beginTransaction();
        try{
            session.save(dep);
            session.getTransaction().commit();
            flag=1;
        }catch(Exception e){
             if(session.getTransaction().isActive()){
                session.getTransaction().rollback();
                flag=1;
            }
        }finally{
            session.close();
       
    }
    return flag;
}
    
    public Departamentos consultarDepartamento(String codigoDepartamento){
        Departamentos dep=new Departamentos();
        
        SessionFactory factory=HibernateUtil.getSessionFactory();
        Session session =factory.openSession();
        session.beginTransaction();
        try{
            dep =(Departamentos) session.get(Departamentos.class, codigoDepartamento);
            session.getTransaction().commit();
            
        }catch(Exception exc)
        {
            if(session.getTransaction().isActive()){
                session.getTransaction().rollback();
            }
        }finally{
            session.close();
        }
        return dep;
    }
    
    public int eliminarDepartamento(String codigoDepartamento){
      Departamentos dep=new Departamentos();
        
        SessionFactory factory=HibernateUtil.getSessionFactory();
        Session session =factory.openSession();
        int flag=0;
        try{
        session.beginTransaction();
            dep =(Departamentos) session.get(Departamentos.class, codigoDepartamento);
            session.delete(dep);
            session.getTransaction().commit();
            flag=1;
        }catch(Exception e){
             if(session.getTransaction().isActive()){
                session.getTransaction().rollback();
                flag=1;
            }
        }finally{
            session.close();
       
    }
    return flag;
       
}
    
    public List consultarTodosDepartamentos(){
        List<Departamentos> listaDepartamentos=null;
        
        SessionFactory factory=HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        try{
            Query q =session.createQuery("from Departamentos");
            listaDepartamentos=(List<Departamentos>) q.list();
        }catch(Exception exc){
            exc.printStackTrace();;
        }finally{
            
        }
        return listaDepartamentos;
    }
}
