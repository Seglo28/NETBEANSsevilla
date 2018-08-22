/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuario.action;

import com.myapp.struts.HibernateUtil;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Session;
import org.hibernate.Transaction;
import persistencia.Usuario;
import usuario.actionform.StrutsActionForm;

/**
 *
 * @author Admin125
 */
public class StrutsAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";

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
        Session s;
        s=HibernateUtil.getSessionFactory().openSession();
        Transaction trx = s.beginTransaction();
        StrutsActionForm laf = (StrutsActionForm)form;
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
}
