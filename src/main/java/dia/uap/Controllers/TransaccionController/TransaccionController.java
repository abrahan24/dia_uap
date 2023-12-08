package dia.uap.Controllers.TransaccionController;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dia.uap.Models.Entity.Detalle_Requisito;
import dia.uap.Models.Entity.Transaccion;
import dia.uap.Models.Entity.Usuario;
import dia.uap.Models.Service.ICarreraService;
import dia.uap.Models.Service.IColegioService;
import dia.uap.Models.Service.IDetalleRequisitoService;
import dia.uap.Models.Service.IFacultadService;
import dia.uap.Models.Service.INacionalidadService;
import dia.uap.Models.Service.IPostulanteService;
import dia.uap.Models.Service.IProcesoService;
import dia.uap.Models.Service.IRequisitoService;
import dia.uap.Models.Service.ITipoPostulanteService;
import dia.uap.Models.Service.ITransaccionService;
import dia.uap.Models.Service.IVentanillaService;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class TransaccionController {

    @Autowired
    private IPostulanteService postulanteService;

    @Autowired
    private IColegioService colegioService;

    @Autowired
    private INacionalidadService nacionalidadService;

    @Autowired
    private ITipoPostulanteService tipoPostulanteService;

    @Autowired
    private IRequisitoService requisitoService;

    @Autowired
    private IDetalleRequisitoService detalleRequisitoService;

    @Autowired
    private ICarreraService carreraService;

    @Autowired
    private IFacultadService facultadService;

    @Autowired
    private IProcesoService procesoService;

    @Autowired
    private IVentanillaService ventanillaService;

    @Autowired
    private ITransaccionService transaccionService;
    
     @GetMapping(value = "/transaccion")
    public String Vista_Transaccion(Model model, HttpServletRequest request,
            @RequestParam(name = "success", required = false) String success,
            @RequestParam(name = "success2", required = false) String success2) {

        if (request.getSession().getAttribute("usuario") != null) {

            if (success != null) {
                model.addAttribute("success", success);
            }
            if (success2 != null) {
                model.addAttribute("success2", success2);
            }

            return "Transaccion/transaccion";
        } else {
            return "redirect:/login";
        }
    }
   

    @PostMapping(value = "/form_transaccion")
    public String Form_Transaccion(Model model, HttpServletRequest request,
            @RequestParam(name = "id_postulante", required = false) Long id_postulante, RedirectAttributes flash) {
        if (request.getSession().getAttribute("usuario") != null) {

            if (postulanteService.findOne(id_postulante) != null) {

                model.addAttribute("postulante", postulanteService.findOne(id_postulante));
                model.addAttribute("transaccion", new Transaccion());
                model.addAttribute("nacionalidades", nacionalidadService.findAll());
                model.addAttribute("colegios", colegioService.findAll());
                model.addAttribute("tipoPostulantes", tipoPostulanteService.findAll());
                model.addAttribute("requisitos", requisitoService.findAll());
                model.addAttribute("carreras", carreraService.findAll());
                model.addAttribute("facultades", facultadService.findAll());
                model.addAttribute("procesos", procesoService.findAll());
                model.addAttribute("ventanillas", ventanillaService.findAll());

                return "Transaccion/habilitacion";
            } else {

                flash.addAttribute("success2", "Postulante No Se Encuentra Registrado!");

                return "redirect:/transaccion";
            }

        } else {
            return "redirect:/login";
        }
    }

    @PostMapping(value = "/form_habilitacion")
    public String Form_Habilitacion(Model model, HttpServletRequest request,@Validated Transaccion transaccion,
            @RequestParam(name = "id_carrera", required = false) Long id_carrera,
            @RequestParam(name = "id_postulante", required = false) Long id_postulante,
            @RequestParam(name = "id_facultad",required = false)Long id_facultad,
            @RequestParam(name = "id_proceso",required = false)Long id_proceso,
            @RequestParam(name = "id_requisito",required = false)Long[] id_requisito,
            @RequestParam(name = "id_ventanilla",required = false)Long id_ventanilla, RedirectAttributes flash) {
        if (request.getSession().getAttribute("usuario") != null) {

            Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");

            transaccion.setCarrera(carreraService.findOne(id_carrera));
            transaccion.setFacultad(facultadService.findOne(id_facultad));
            transaccion.setProceso(procesoService.findOne(id_proceso));
            transaccion.setVentanilla(ventanillaService.findOne(id_ventanilla));
            transaccion.setPostulante(postulanteService.findOne(id_postulante));
            transaccion.setUsuario(usuario);
            transaccion.setFecha_regstro(new Date());
            transaccion.setEstado_transaccion("A");
            transaccionService.save(transaccion);
            for (int i = 0; i < id_requisito.length; i++) {
                Detalle_Requisito detalle_Requisito = new Detalle_Requisito();
                detalle_Requisito.setRequisito(requisitoService.findOne(id_requisito[i]));
                detalle_Requisito.setEstado_detalle_requisito("A");
                detalle_Requisito.setFecha_registro(new Date());
                detalle_Requisito.setPostulante(postulanteService.findOne(id_postulante));
                detalleRequisitoService.save(detalle_Requisito);
            }
           
            flash.addAttribute("success", "Habilitacion Exitosa!");

            return "redirect:/transaccion";
        } else {
            return "redirect:/login";
        }
    }
}
