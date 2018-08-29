package persistencia;
// Generated 22/08/2018 10:04:12 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Usuario generated by hbm2java
 */
public class Usuario  implements java.io.Serializable {


     private Integer idUsuario;
     private String usuario;
     private String correo;
     private String contra;
     private String cargo;
     private Set ventases = new HashSet(0);

    public Usuario() {
    }

    public Usuario(String usuario, String correo, String contra, String cargo, Set ventases) {
       this.usuario = usuario;
       this.correo = correo;
       this.contra = contra;
       this.cargo = cargo;
       this.ventases = ventases;
    }
   
    public Integer getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
    public String getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getCorreo() {
        return this.correo;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getContra() {
        return this.contra;
    }
    
    public void setContra(String contra) {
        this.contra = contra;
    }
    public String getCargo() {
        return this.cargo;
    }
    
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public Set getVentases() {
        return this.ventases;
    }
    
    public void setVentases(Set ventases) {
        this.ventases = ventases;
    }




}


