package persistencia;
// Generated 08-21-2018 11:35:38 AM by Hibernate Tools 4.3.1



/**
 * Usuario generated by hbm2java
 */
public class Usuario  implements java.io.Serializable {


     private Integer idUsuario;
     private String usuario;
     private String correo;
     private String contra;
     private String cargo;

    public Usuario() {
    }

    public Usuario(String usuario, String correo, String contra, String cargo) {
       this.usuario = usuario;
       this.correo = correo;
       this.contra = contra;
       this.cargo = cargo;
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




}


