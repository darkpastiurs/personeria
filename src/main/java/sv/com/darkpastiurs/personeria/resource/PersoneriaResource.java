package sv.com.darkpastiurs.personeria.resource;

import io.quarkus.hibernate.reactive.panache.common.WithTransaction;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.core.UriInfo;
import org.jboss.resteasy.reactive.RestResponse;
import sv.com.darkpastiurs.personeria.model.Persona;
import sv.com.darkpastiurs.personeria.service.PersonaService;

import java.util.List;

@Path("/persona")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class PersoneriaResource {

    @Inject
    PersonaService personaService;

    @GET
    public Uni<RestResponse<List<Persona>>> getAll() {
        return personaService.listAll().onItem().transform(RestResponse::ok).onItem().ifNull().continueWith(RestResponse.noContent());
    }

    @POST
    @WithTransaction
    public Uni<RestResponse<Object>> create(Persona persona, @Context UriInfo uriInfo) {
        return personaService.persistAndFlush(persona)
                .onItem().transform(insertedPersona -> RestResponse.created(UriBuilder.fromUri(uriInfo.getAbsolutePath()).path("/{id}").build(insertedPersona.getId())))
                .onFailure().recoverWithItem(RestResponse.serverError());
    }
}
