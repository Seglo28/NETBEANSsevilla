package usam.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import usam.actionforms.ActionFormDepartamentos;
import usam.mantenimientos.MantenimientoDepartamentos;
import usam.persistencia.Departamentos;

public class ActionDepartamentos extends org.apache.struts.action.Action {

    private static final String CONFIRMACION = "confirmacionNuevoDepartamento";
    private static final String ELIMINAR = "confirmacionEliminarDepartamento";
    private static final String ERROR = "errorMantenimientoDepartamento";

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ActionFormDepartamentos formBean=(ActionFormDepartamentos) form;
        String codigoDepartamento =formBean.getCodigoDepartamento();
        String nombreDepartamento=formBean.getNombreDepartamento();
        String action=formBean.getAction();
        
        if(formBean==null || action==null){
            return mapping.findForward(ERROR);
        }
        
        if(action.equals("Nuevo")){
            formBean.setCodigoDepartamento("");
            formBean.setNombreDepartamento("");
            formBean.setError("");
            return mapping.findForward(ERROR);
                    
        }
        if(action.equals("Agregar")){
            String advertencia="";
           
            if(codigoDepartamento==null || codigoDepartamento.equals("")){
                advertencia="*Codigo de departamento es requerido<br>";
            }
            if(nombreDepartamento==null || nombreDepartamento.equals("")){
                advertencia+="*Nombre de departamento es requerido<br>";
            }
            if(!advertencia.equals("")){
                formBean.setError("<span style='color:red'>Por favor complete los espacios vacios" + "<br>" + advertencia+ "</span>");
                return mapping.findForward(ERROR);
            }
            MantenimientoDepartamentos mantoDepartamentos=new MantenimientoDepartamentos();
            Departamentos depto=mantoDepartamentos.consultarDepartamento(codigoDepartamento);
            if (depto != null){
                formBean.setError("<span style='color:red'>Codigo departamento ya esta registrado..."+"<br></span>");
                return mapping.findForward(ERROR);
            }
            mantoDepartamentos.guardarDepartamento(codigoDepartamento, nombreDepartamento);
            return mapping.findForward(CONFIRMACION);
            
        }
        if(action.equals("Consultar")){
            MantenimientoDepartamentos mantoDepartamentos=new MantenimientoDepartamentos();
            Departamentos depto=mantoDepartamentos.consultarDepartamento(codigoDepartamento);
            if(depto==null){
                formBean.setError("<span style='color:red'>Departamento no ya esta registrado..."+"<br></span>");
                return mapping.findForward(ERROR);
            }else{
                formBean.setCodigoDepartamento(depto.getCodigoDepartamento());
                formBean.setNombreDepartamento(depto.getDepartamento());
                return mapping.findForward(ERROR);
            }
        }
        
        if(action.equals("Eliminar")){
             MantenimientoDepartamentos mantoDepartamentos=new MantenimientoDepartamentos();
            mantoDepartamentos.eliminarDepartamento(codigoDepartamento);
            return mapping.findForward(ELIMINAR);
        }
        return mapping.findForward(CONFIRMACION);
    }
}
