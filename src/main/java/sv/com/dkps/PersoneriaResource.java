package sv.com.dkps;

import io.quarkus.hibernate.reactive.panache.common.WithTransaction;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/personeria")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class PersoneriaResource {

    @Inject
    PersonaService personaService;

    @GET
    public Uni<List<Persona>> getAll() {
        return personaService.findAll().list();
    }

    @POST
    @WithTransaction
    public Uni<Persona> create(Persona persona) {
        return personaService.persistAndFlush(persona);
    }
}
