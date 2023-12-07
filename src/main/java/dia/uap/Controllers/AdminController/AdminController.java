package dia.uap.Controllers.AdminController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AdminController {
    
    @GetMapping(value = "/panel")
    public String Vista_Panel(Model model, HttpServletRequest request){

        if (request.getSession().getAttribute("usuario") != null) {
            
            return "Panel/panel";
        }else{
            return "Login/login";
        }
    }
}
