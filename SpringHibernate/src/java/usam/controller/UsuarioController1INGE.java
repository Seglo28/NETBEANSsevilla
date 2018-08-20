
package usam.controller;

import usam.persistencia.Usuarios;
import usam.service.UsuariosService;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UsuarioController1INGE {
    @Autowired
    UsuariosService usuarioService;
    
    @RequestMapping("/")
    public String listUsuarios(Map<String, Object> map) {
        map.put("usuario", new Usuarios());
        map.put("listUsuarios", usuarioService.listUsuarios());
        return "index";
    }

        @RequestMapping(value = "/usuario/add", method = RequestMethod.POST)
    public String addUsuario(@ModelAttribute("usuario") Usuarios usuario, BindingResult result) {
        if (usuario.getUsuario() == null) {
            usuarioService.addUsuario(usuario);
        } else {
            usuarioService.updateUsuario(usuario);
        }
        return "redirect:/";
    }
@RequestMapping("/delete/{pid}")
    public String deleteUsuario(@PathVariable("usuario") String usuario) {
        usuarioService.removeUsuario(usuario);
        return "redirect:/";
    }
    
    @RequestMapping("/edit/{pid}")
    public String editUsuario(@PathVariable("pid") String usuario, Map<String, Object> map) {
        map.put("usuario", usuarioService.getUsuario(usuario));
        map.put("usuarioList", usuarioService.listUsuarios());
        return "index";
    }
}
