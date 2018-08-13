/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usam.mantenimiento;

import usam.DAO.ClientesDAO;

/**
 *
 * @author Admin125
 */
public class Prueba {
    
    public static void main(String[] args) {
        
        ClientesDAO cliente = new ClientesDAO();
        //cliente.guardarClientes(0, "Hola", "Handsome", "dsdsa", "45456");
        
        cliente.eliminarClientes(8);
        System.out.println(cliente);
    }
}
