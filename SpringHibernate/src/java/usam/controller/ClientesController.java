package usam.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import persistencia.Usuarios.Clientes;
import usam.servicio.ClientesService;

@Controller
public class ClientesController {
    @Autowired
    ClientesService cs;
    
    @RequestMapping("/")
    public String MostrarTodosClientes(Map<String, Object>map){
        map.put("idCliente", new Clientes());
        map.put("MostrarTodosClientes", cs.MostrarTodosClientes());
        return "index";
    }
    
    @RequestMapping(value = "/clientes/add", method = RequestMethod.POST)
//
    public String AgregarCliente(@ModelAttribute("clientes")Clientes cli, BindingResult result){
        if(cli.getCliente()==null){
            cs.AgregarCliente(cli);
        }else{
            cs.ActualizarCliente(cli);
        }
        return "redirect:/";
    }
    
    @RequestMapping("/delete/{idCliente}")
// Cambie {pid} por {idCliente} porque en la vista lo llamare de esta manera
    public String eliminarCliente(@PathVariable("idClientes")Integer idCliente){ 
//ESTE ME CONFUNDE UN POCO PORQUE AL PONERLO IGUAL QUE EL ING. ME PIDIO UN CONVERSOR java.lang.Integer
//Mejor lo deje como integer
        cs.EliminarCliente(idCliente);
        return "redirect:/";
    }
    
    @RequestMapping("/edit/{idCliente}")
    public String ActualizarCliente(@PathVariable("idCliente")Integer idCliente, Map<String, Object>map){
//("pid") LO CAMBIE POR ("idCliente")
//@RequestParam 
        map.put("idCliente", cs.MostrarUnoClientes(idCliente)); //edicion
        map.put("MostrarTodosClientes", cs.MostrarTodosClientes());  //lista mostrar
        return "index";
    }
}