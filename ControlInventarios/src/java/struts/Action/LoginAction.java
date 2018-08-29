/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package struts.Action;

import com.myapp.struts.HibernateUtil;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Session;
import org.hibernate.Transaction;
import persistencia.Usuario;
import struts.ActionForm.LoginActionForm;

/**
 *
 * @author glori
 */
public class LoginAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private static final String ERROR = "error";

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //Esta parte es importante para juntar hibernate con struts
        LoginActionForm laf = (LoginActionForm) form;
        String action = laf.getAction();
        //System.out.println("ACCION: "+action);

        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction trx = s.beginTransaction();

        if (action.equals("Actualizar")) {
            Usuario u = new Usuario();
            u.setIdUsuario(laf.getIdUsuario());
            u.setUsuario(laf.getUsuario());
            u.setCorreo(laf.getCorreo());
            u.setContra(laf.getContra());
            u.setCargo(laf.getCargo());
            s.update(u);
            trx.commit();
            s.close();
            return mapping.findForward(SUCCESS);
        }
        if (action.equals("Guardar")) {
            Usuario u = new Usuario();
            u.setIdUsuario(0);
            u.setUsuario(laf.getUsuario());
            u.setCorreo(laf.getCorreo());
            u.setContra(laf.getContra());
            u.setCargo(laf.getCargo());
            s.save(u);
            trx.commit();
            s.close();
            return mapping.findForward(SUCCESS);
        }
        if (action.equals("Eliminar")) {
            Usuario u = new Usuario();
            u.setIdUsuario(laf.getIdUsuario());
            s.delete(u);
            trx.commit();
            s.close();
            return mapping.findForward(SUCCESS);
        }
        if(action.equals("Login")){
            System.out.println("111");
            Usuario u = new Usuario();
            System.out.println("222");
            if(u.getCorreo().equals(laf.getCorreo()) && 
                    u.getContra().equals(laf.getContra())){
                System.out.println("333");
                return mapping.findForward(SUCCESS);
            }else{
                return mapping.findForward(ERROR);
            }
        }
        if(action.equals("Login2")){
            System.out.println("111");
            Usuario u = new Usuario();
            System.out.println("222");
            if(laf.getCorreo().equals(u.getCorreo())
                    && laf.getContra().equals(u.getContra())){
                System.out.println("333");
                return mapping.findForward(SUCCESS);
            }else{
                return mapping.findForward(ERROR);
            }
        }
        return null;
    }
}
