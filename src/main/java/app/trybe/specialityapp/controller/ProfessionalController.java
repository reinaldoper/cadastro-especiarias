package app.trybe.specialityapp.controller;

import app.trybe.specialityapp.model.Professional;
import app.trybe.specialityapp.service.ProfessionalService;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;


@Controller
@Path("/api/professional")
public class ProfessionalController {

  @Autowired
  private ProfessionalService service;

  /**
   * Método classe.
   */
  @GET
  @Path("/all")
  @Produces("application/json")
  public ResponseEntity<List<Professional>> getAllProfessionals() {

    List<Professional> professionals = service.getAllProfessionals();

    return ResponseEntity.ok().body(professionals);
  }
}
