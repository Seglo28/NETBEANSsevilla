package persistencia.Usuarios;
// Generated 08-10-2018 09:42:32 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Clientes generated by hbm2java
 */
public class Clientes  implements java.io.Serializable {


     private Integer idCliente;
     private String cliente;
     private String tipoPersona;
     private String direccion;
     private String telefono;
     private Set ventases = new HashSet(0);

    public Clientes() {
    }

    public Clientes(String cliente, String tipoPersona, String direccion, String telefono, Set ventases) {
       this.cliente = cliente;
       this.tipoPersona = tipoPersona;
       this.direccion = direccion;
       this.telefono = telefono;
       this.ventases = ventases;
    }
   
    public Integer getIdCliente() {
        return this.idCliente;
    }
    
    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }
    public String getCliente() {
        return this.cliente;
    }
    
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    public String getTipoPersona() {
        return this.tipoPersona;
    }
    
    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public Set getVentases() {
        return this.ventases;
    }
    
    public void setVentases(Set ventases) {
        this.ventases = ventases;
    }




}


