package gm.contactos.repositorio;

import gm.contactos.modelo.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactosRepositorio extends JpaRepository<Contacto, Integer> {
}
