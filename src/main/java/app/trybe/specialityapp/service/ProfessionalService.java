package app.trybe.specialityapp.service;

import app.trybe.specialityapp.model.Professional;
import app.trybe.specialityapp.repository.ProfessionalRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Classe ProfessionalService.
 * 
 */

@Service
public class ProfessionalService {

  @Autowired
  private ProfessionalRepository repository;

  /**
   * Método classe.
   */
  public List<Professional> getAllProfessionals() {
    return repository.findAll();
  }
}
