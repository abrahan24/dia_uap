package dia.uap.Controllers.AdminController;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import dia.uap.Models.Service.IPostulanteService;
import dia.uap.Models.Service.ITransaccionService;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AdminController {

    @Autowired
    private IPostulanteService postulanteService;

    @Autowired
    private ITransaccionService transaccionService;

    @GetMapping(value = "/panel")
    public String Vista_Panel(Model model, HttpServletRequest request) {

        if (request.getSession().getAttribute("usuario") != null) {

            model.addAttribute("postulantesA", postulanteService.findAll().stream()
                    .filter(postulante -> "A".equals(postulante.getEstado_postulante())).collect(Collectors.toList()));
                    model.addAttribute("postulantesP", postulanteService.findAll().stream()
                    .filter(postulante -> "P".equals(postulante.getEstado_postulante())).collect(Collectors.toList()));
            model.addAttribute("transacciones", transaccionService.findAll().stream()
                    .filter(transccion -> "A".equals(transccion.getEstado_transaccion())).collect(Collectors.toList()));
            return "Panel/panel";
        } else {
            return "redirect:/login";
        }
    }
}
