package gm.contactos.servicio;
import gm.contactos.modelo.Contacto;
import java.util.List;

public interface IContactoServicio {
    public List<Contacto> listarContactos();
    public Contacto buscarContactoId(Integer idContacto);
    public void guardarContacto(Contacto contacto);
    public void eliminarContacto(Contacto contacto);
}
