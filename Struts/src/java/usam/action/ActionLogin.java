package usam.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import usam.actionforms.ActionFormLogin;

public class ActionLogin extends org.apache.struts.action.Action {

    //Regla de navegación en caso de éxito
    private static final String SUCCESS = "mantenimientoDepartamentos";
    private static final String ERROR = "login";

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
       
        //Casteo el formulaio recibido
        ActionFormLogin usuario = (ActionFormLogin) form;
        
        if(usuario.getUsername().equals("memy") && usuario.getPassword().equals("memy")){
            return mapping.findForward(SUCCESS);
        } else {
            String error = ""
                    + "<div class='alert alert-danger alert-dismissible' role='alert'>"
                    + "<h4 class='alert-head'>"
                    + "Santo guacamole!</h4>" 
                    + "El usuario o la contraseña son incorrectos"
                    + "<button type='button' class='close' data-dismiss='alert' aria-label='Close'>"
                    + "<span aria-hidden='true'>&times;</span>" 
                    + "</button>" 
                    + "</div>";
            usuario.setError(error);
            return mapping.findForward(ERROR);
           
        }
    }
}
