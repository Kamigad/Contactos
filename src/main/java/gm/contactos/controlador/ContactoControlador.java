package gm.contactos.controlador;

import gm.contactos.modelo.Contacto;
import gm.contactos.servicio.IContactoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ContactoControlador {

    private static final Logger logger = LoggerFactory.getLogger(ContactoControlador.class);

    private final IContactoServicio contactoServicio;

    public ContactoControlador(IContactoServicio contactoServicio){
        this.contactoServicio = contactoServicio;
    }

    @GetMapping("/")
    public String iniciar(Model modelo){
        List<Contacto> contactos = contactoServicio.listarContactos();
        contactos.forEach((contacto) -> logger.info(contacto.toString()));
        modelo.addAttribute("contactos", contactos);
        return "index"; //index.html
    }

    @GetMapping("/agregar")
    public String mostrarAgregar(Model modelo){
        modelo.addAttribute("contactoForma", new Contacto());
        return "agregar"; //agregar.index
    }

    @PostMapping("/agregar")
    public String agregarContacto(@ModelAttribute("contactoForma") Contacto contacto){
        logger.info("Se agrego el nuevo contacto: " + contacto.toString());
        contactoServicio.guardarContacto(contacto);
        return "redirect:/"; // redirigimos al controlador el path "/"
    }

    @GetMapping("/editar/{id}")
    public String mostrarEditar(@PathVariable(value = "id") Integer idContacto, Model modelo){
        Contacto contacto = contactoServicio.buscarContactoId(idContacto);
        logger.info("Contacto a editar (mostrar): " + contacto);
        modelo.addAttribute("contactoEditar",contacto);
        return "editar"; //editar.html
    }

    @PostMapping("/editar")
    public String editarContacto(@ModelAttribute("contactoEditar") Contacto contacto){
        logger.info("Contacto a editar(editado): " + contacto.toString());
        contactoServicio.guardarContacto(contacto);
        return "redirect:/"; // redirigimos al controlador el path "/"
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarContacto(@PathVariable(value = "id") Integer idContacto){
        Contacto contacto = contactoServicio.buscarContactoId(idContacto);
        contactoServicio.eliminarContacto(contacto);
        logger.info("Contacto eliminado: " + contacto.toString());
        return "redirect:/"; // redirigimos al controlador el path "/"
    }
}