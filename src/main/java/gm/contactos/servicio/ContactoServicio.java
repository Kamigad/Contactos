package gm.contactos.servicio;
import gm.contactos.modelo.Contacto;
import gm.contactos.repositorio.ContactosRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class ContactoServicio implements IContactoServicio{

    private final ContactosRepositorio contactosRepositorio;

    public ContactoServicio(ContactosRepositorio contactosRepositorio) {
        this.contactosRepositorio = contactosRepositorio;
    }
    
    @Override
    public List<Contacto> listarContactos() {
        return contactosRepositorio.findAll();
    }

    @Override
    public Contacto buscarContactoId(Integer idContacto) {
        return contactosRepositorio.findById(idContacto).orElse(null);
    }

    @Override
    public void guardarContacto(Contacto contacto) {
        contactosRepositorio.save(contacto);
    }

    @Override
    public void eliminarContacto(Contacto contacto) {
        contactosRepositorio.delete(contacto);
    }
}