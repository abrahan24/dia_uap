package dia.uap.Controllers.PostulanteController;

import java.util.Date;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dia.uap.Models.Entity.Persona;
import dia.uap.Models.Entity.Postulante;
import dia.uap.Models.Service.IColegioService;
import dia.uap.Models.Service.INacionalidadService;
import dia.uap.Models.Service.IPersonaService;
import dia.uap.Models.Service.IPostulanteService;
import dia.uap.Models.Service.ITipoPostulanteService;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class PostulanteController {

    @Autowired
    private IPersonaService personaService;
    
    @Autowired
    private IPostulanteService postulanteService;

    @Autowired
    private ITipoPostulanteService tipoPostulanteService;

    @Autowired
    private IColegioService colegioService;

    @Autowired
    private INacionalidadService nacionalidadService;
    
    @GetMapping(value = "/postulante")
    public String Vista_Postulante(Model model, HttpServletRequest request,
            @RequestParam(name = "success", required = false) String success,
            @RequestParam(name = "success2",required = false) String success2) {

        if (request.getSession().getAttribute("usuario") != null) {

            if (success != null) {
                model.addAttribute("success", success);
            }
            if (success2 != null) {
                model.addAttribute("success2", success2);
            }

            model.addAttribute("persona", new Persona());
            model.addAttribute("postulante", new Postulante());
            model.addAttribute("nacionalidades", nacionalidadService.findAll());
            model.addAttribute("colegios", colegioService.findAll());
            model.addAttribute("tipoPostulantes", tipoPostulanteService.findAll());

            return "Postulante/postulante";
        } else {
            return "redirect:/login";
        }
    }
 
    @PostMapping(value = "/form_postulante")
    public String Form_Postulante(Model model, @Validated Persona persona, @Validated Postulante postulante,
            @RequestParam(name = "id_nacionalidad") Long id_nacionalidad,
            @RequestParam(name = "id_colegio") Long id_colegio,
            @RequestParam(name = "id_tipo_postulante") Long id_tipo_postulante,RedirectAttributes flash, HttpServletRequest request) {
        if (request.getSession().getAttribute("usuario") != null) {

            if (personaService.getPersona_Por_CI(persona.getCi()) == null) {
                persona.setEstado_persona("A");
                persona.setFecha_registro(new Date());
                persona.setNacionalidad(nacionalidadService.findOne(id_nacionalidad));
                personaService.save(persona);

                postulante.setPersona(persona);
                postulante.setFecha_registro(new Date());
                postulante.setEstado_postulante("A");
                postulante.setColegio(colegioService.findOne(id_colegio));
                postulante.setTipoPostulante(tipoPostulanteService.findOne(id_tipo_postulante));
                postulanteService.save(postulante);

                flash.addAttribute("success", "Se ah Registrado el Postulante Con Exito!"+" Con el Siguiente R.U:"+postulante.getId_postulante());
            } else {
                flash.addAttribute("success2", "Ya Existe el Postulante Registrado!");

            }
            
            return "redirect:/postulante";
        } else {
            return "redirect:/login";
        }
    }
}
