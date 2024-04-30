package sv.com.darkpastiurs.personeria.service;

import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import sv.com.darkpastiurs.personeria.model.Persona;

@ApplicationScoped
public class PersonaService implements PanacheRepository<Persona> {

}
