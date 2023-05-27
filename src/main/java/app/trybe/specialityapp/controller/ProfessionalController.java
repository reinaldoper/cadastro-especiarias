package app.trybe.specialityapp.controller;

import app.trybe.specialityapp.commons.ApplicationError;
import app.trybe.specialityapp.model.Professional;
import app.trybe.specialityapp.service.ProfessionalService;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
@Path("/professional")
public class ProfessionalController {

  @Autowired
  private ProfessionalService service;

  /**
   * Método classe.
   */
  @GET
  @Path("/all")
  @Produces("application/json")
  public Response getAllProfessionals() {

    List<Professional> professionals = service.getAllProfessionals();

    if (professionals.isEmpty()) {
      ApplicationError applicationError =
          new ApplicationError(Response.Status.NOT_FOUND, "Nenhum registro foi encontrado!");
      return Response.status(applicationError.getStatus()).entity(applicationError.getMessage())
          .build();
    }
    return Response.ok(professionals).build();
  }
}
