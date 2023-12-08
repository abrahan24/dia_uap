package dia.uap.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dia.uap.Models.Entity.Usuario;
import dia.uap.Models.Service.IUsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private IUsuarioService usuarioService;
    
    @GetMapping(value = "/login")
    public String Vista_Login() {

        return "Login/login";
    }

    @PostMapping(value = "/login_form")
    public String Form_Login(@RequestParam(name = "nom_usuario", required = false) String nom_usuario,
            @RequestParam(name = "contrasena", required = false) String contrasena, HttpServletRequest request) {

        Usuario usuario = usuarioService.getUsuario(nom_usuario, contrasena);

        if (usuario != null) {
            HttpSession session = request.getSession(true);

            session.setAttribute("usuario", usuario);
            session.setAttribute("administrativo", usuario.getAdministrativo());
            session.setAttribute("persona", usuario.getAdministrativo().getPersona());
            session.setAttribute("nom_persona", usuario.getAdministrativo().getPersona().getNom_persona());
            return "redirect:/panel";
        } else {
            return "redirect:/login";
        }

    }

    @RequestMapping("/cerrar_sesion")
	public String cerrarSesion2(HttpServletRequest request, RedirectAttributes flash) {
		HttpSession session = request.getSession();
		if (session != null) {
			session.invalidate();
			flash.addAttribute("validado", "Se cerro sesion con exito!");
		}
		return "redirect:/login";
	}

}
