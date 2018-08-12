package persistencia.Usuarios;
// Generated 08-10-2018 09:42:32 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Ventas generated by hbm2java
 */
public class Ventas  implements java.io.Serializable {


     private Integer idVenta;
     private Clientes clientes;
     private Productos productos;
     private Usuario usuario;
     private Integer cantidad;
     private Double monto;
     private Set facturases = new HashSet(0);

    public Ventas() {
    }

	
    public Ventas(Clientes clientes, Productos productos, Usuario usuario) {
        this.clientes = clientes;
        this.productos = productos;
        this.usuario = usuario;
    }
    public Ventas(Clientes clientes, Productos productos, Usuario usuario, Integer cantidad, Double monto, Set facturases) {
       this.clientes = clientes;
       this.productos = productos;
       this.usuario = usuario;
       this.cantidad = cantidad;
       this.monto = monto;
       this.facturases = facturases;
    }
   
    public Integer getIdVenta() {
        return this.idVenta;
    }
    
    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }
    public Clientes getClientes() {
        return this.clientes;
    }
    
    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }
    public Productos getProductos() {
        return this.productos;
    }
    
    public void setProductos(Productos productos) {
        this.productos = productos;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Integer getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    public Double getMonto() {
        return this.monto;
    }
    
    public void setMonto(Double monto) {
        this.monto = monto;
    }
    public Set getFacturases() {
        return this.facturases;
    }
    
    public void setFacturases(Set facturases) {
        this.facturases = facturases;
    }




}

