/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usam.mantenimiento;
/**
 *
 * @author Admin125
 */
public class Prueba {
    
    public static void main(String[] args) {
        
        ClienteMantenimiento cliente = new ClienteMantenimiento();
        //cliente.guardarClientes(0, "Hola", "Handsome", "dsdsa", "45456");
        //cliente.eliminarClientes(3);
        //cliente.actualizarClientes(11, "cliente", "tipoPersona", "direccion", "telefono");
        cliente.consultarTodosClientes();
        cliente.consultarClientes(4);
        System.out.println(cliente);
        
        FabricantesMantenimiento fabricante = new FabricantesMantenimiento();
        //fabricante.guardarFabricantes (0, "kkkds", "kkaveniu", "45158856");
        //fabricante.eliminarFabricantes(2);
        System.out.println(fabricante);
        
        ProveedorMantenimiento proveedor = new ProveedorMantenimiento();
        //proveedor.guardarProveedor(0, "salud", "aaa", "Gloria", "121212121");
        //proveedor.eliminarProveedores(1);
        System.out.println(proveedor);
        
        SucursalesMantenimiento sucursales = new SucursalesMantenimiento();
        //sucursales.guardarSucursales(0, "centro", "La linea", "Soyapango", "San Salvador", "25647");
        //sucursales.eliminarSucursales(1);
        System.out.println(sucursales);
        
        UsuariosMantenimiento usuarios = new UsuariosMantenimiento();
        //usuarios.guardarUsuario(0, "Yanira", "yanira@mysql.com", "root", "cargo");
        //usuarios.eliminarUsuario(1);
        System.out.println(usuarios);
    }
}
