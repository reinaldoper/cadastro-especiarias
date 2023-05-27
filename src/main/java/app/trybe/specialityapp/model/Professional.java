package app.trybe.specialityapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Professional {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String name;
  private String speciality;

  /**
   * Construtor.
   */

  public Professional() {}

  /**
   * Construtor.
   */

  public Professional(Integer id, String name, String speciality) {
    super();
    this.id = id;
    this.name = name;
    this.speciality = speciality;
  }

  /**
   * Método classe.
   */
  public Integer getId() {
    return id;
  }

  /**
   * Método classe.
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * Método classe.
   */
  public String getName() {
    return name;
  }

  /**
   * Método classe.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Método classe.
   */
  public String getSpeciality() {
    return speciality;
  }

  /**
   * Método classe.
   */
  public void setSpeciality(String speciality) {
    this.speciality = speciality;
  }
}


