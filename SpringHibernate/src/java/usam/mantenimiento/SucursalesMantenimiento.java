package usam.mantenimiento;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import persistencia.Usuarios.Sucursales;
import usam.spring.HibernateUtil;

public class SucursalesMantenimiento {

    public static void main(String[] args) {
        Integer idSucursal;
        String sucursal="";
        String direccion="";
        String municipio="";
        String departamento="";
        String telefono="";

        SucursalesMantenimiento mantenimiento = new SucursalesMantenimiento();

        System.out.println();
    }

    public int guardarSucursales(Integer idSucursal, String sucursal, String direccion, String municipio, String departamento,
            String telefono) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        int flag = 0;

        Sucursales sucur = new Sucursales();
        sucur.setIdSucursal(idSucursal);
        sucur.setSucursal(sucursal);
        sucur.setDireccion(direccion);
        sucur.setMunicipio(municipio);
        sucur.setDepartamento(departamento);
        sucur.setTelefono(telefono);
        try {
            session.beginTransaction();
            session.save(sucur);
            session.getTransaction().commit();
            flag = 1;
        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                flag = 1;
            }
        } finally {
            session.close();
        }
        return flag;
    }

}
