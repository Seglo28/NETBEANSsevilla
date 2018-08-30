package usam.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mantenimiento.MantenimientoUsuario;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import usam.actionform.UsurioActionForm;
import usam.persistencia.Usuario;

public class UsuarioAction extends org.apache.struts.action.Action {

    private static final String entrar = "entrar";
    private static final String salir = "salir";
    private static final String error = "error";

    @Override
    public ActionForward execute(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        UsurioActionForm formBean = (UsurioActionForm) form;
        String correo = formBean.getCorreo().trim();
        String contra = formBean.getContra();
        String accion = formBean.getAccion();

        if (formBean == null || accion == null) {
            formBean.setError("no se logro realizar");
            return map.findForward(error);
        }

        if (accion.equals("Ingresar")) {
            System.out.println("Action Entrar: ...");
            String adver = "";
            String adver1 = "";
            String adver2 = "";

            if (correo == null || correo.equals("")) {
                adver1 = "* Correo es Obligatorio <br>";
            }
            if (contra == null || contra.equals("")) {
                adver1 = "* La Contraseña es Obligatorio <br>";
            }
            if (!adver.equals("")) {
                formBean.setError("<div class='alert alert-danger'>" + adver1+adver2+ "<div>");
                return map.findForward(error);
            } else {
                MantenimientoUsuario mantUser = new MantenimientoUsuario();
                Usuario user = mantUser.entrar(correo, contra);
                if (user == null) {
                    formBean.setError("<div class='alert alert-danger'>Usurio y/o contraseña son incorrectas</div>");
                    return map.findForward(error);
                } else {
                    return map.findForward(entrar);

                }

            }
        }
        
        if(accion.equals("Salir")){
            Usuario user = null;
            System.out.println("Usuario: "+user);
            formBean.setError("<div class='alert alert-sucess'>Ha Cerrado Sesión con Éxito<div>");
            return map.findForward(salir);
        }
        return map.findForward(entrar);
    }

}
