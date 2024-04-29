package sv.com.dkps;

import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PersonaService implements PanacheRepository<Persona> {

}
