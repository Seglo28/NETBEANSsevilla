package usam.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import usam.actionform.SucursalesActionForm;
import usam.mantenimiento.SucursalesMantenimiento;
import usam.persistencia.Sucursales;

public class SucursalesAction extends org.apache.struts.action.Action {

    private static final String entrarSUC = "entrar";
    private static final String salirSUC = "salir";
    private static final String errorSUC = "error";

    @Override
    public ActionForward execute(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        SucursalesActionForm af = (SucursalesActionForm) form;
        Integer idSucursal = af.getIdSucursal();
        String sucursal = af.getSucursal();
        String direccion = af.getDireccion();
        String municipio = af.getMunicipio();
        String departamento = af.getDepartamento();
        String telefono = af.getTelefono();
        String error = af.getError();
        String accion = af.getAccion();

        if (af == null || accion == null) {
            return map.findForward(errorSUC);
        }

        if (accion.equals("Limpiar")) {
            af.setIdSucursal(0);
            af.setSucursal("");
            af.setDireccion("");
            af.setMunicipio("");
            af.setTelefono("");
            af.setError("");
            return map.findForward(errorSUC);
        }

        if (accion.equals("Agregar")) {
            String advertencia = "";

            if (sucursal == null || sucursal.equals("")) {
                advertencia = "<b>*El nombre de la sucursal es requerido.</b><br>";
            }

            if (direccion == null || direccion.equals("")) {
                advertencia = "<b>La dirección de la sucursal es requerida.</b><br>";
            }

            if (municipio == null || municipio.equals("")) {
                advertencia = "<b>El municipio de la sucursal es requerido.</b><br>";
            }

            if (telefono == null || telefono.equals("")) {
                advertencia = "<b>El telefono de la sucursal es requerido.</b><br>";
            }

            if (!advertencia.equals("")) {
                af.setError("<span style='color:red'>Por favor complete los espacios vacios" + "<br>" + advertencia + "</span>");
                return map.findForward(errorSUC);
            }

            SucursalesMantenimiento sucMan = new SucursalesMantenimiento();
            Sucursales  suc = sucMan.consultarSucursal(idSucursal); //Ojito en esta linea
            if (suc == null) {
                af.setError("<span style='color:red'>La sucursal ya esta registrada" + "<br><s/pan>");
                return map.findForward(errorSUC);
            } else {
                sucMan.guardarSucursales(idSucursal, sucursal, direccion, municipio, departamento, telefono);
                /*
                OCUPALO EN EL DE CONSULTAS
                
                af.setSucursal(suc.getSucursal());
                af.setDireccion(suc.getDireccion());
                af.setMunicipio(suc.getMunicipio());
                af.setDepartamento(suc.getDepartamento());
                af.setTelefono(suc.getTelefono());*/
                return map.findForward(entrarSUC);
            }
        }
        return null;
    }
}
