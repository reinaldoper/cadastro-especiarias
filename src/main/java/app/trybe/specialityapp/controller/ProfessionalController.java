package app.trybe.specialityapp.controller;

import app.trybe.specialityapp.commons.ApplicationError;
import app.trybe.specialityapp.model.Professional;
import app.trybe.specialityapp.service.ProfessionalService;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@Controller
@Path("professional")
public class ProfessionalController {

  @Autowired
  private ProfessionalService service;

  /**
   * Método classe.
   */

  public ProfessionalController(ProfessionalService professionalService) {
    this.service = professionalService;
  }

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

  /**
   * Método classe.
   */
  @POST
  @Path("/add")
  @Produces("application/json")
  public Response insert(Professional professional) {
    if (professional.getId() != null && professional.getId() != 0) {
      ApplicationError error = new ApplicationError(Response.Status.BAD_REQUEST,
          "Não é permitido inserir novos registros com ID explícito");
      return Response.status(error.getStatus()).entity(error).build();
    }
    this.service.addProfessional(professional);
    return Response.status(201).entity("Inserido").build();
  }

}
