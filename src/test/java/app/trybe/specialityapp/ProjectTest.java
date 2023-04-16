package app.trybe.specialityapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Testa todos os cenários envvolvendo tecnologias e configurações presentes no projeto
 */
public class ProjectTest {

  private final String RESOURCES_TEST_FOLDER = "./src/main/resources";

  @Test
  @DisplayName("1 - Verifica se o projeto é maven.")
  public void testIfProjectContainsDependyManager() {

    try {

      File pom = new File("pom.xml");

      Assertions.assertTrue(pom.exists());

    } catch (Exception error) {
      Assertions.assertFalse(true);
    }

  }

  @Test
  @DisplayName("2 - Verifica se o arquivo application.yml existe.")
  public void testIfResourcesFileExists() {

    try {

      File applicationYaml = new File(RESOURCES_TEST_FOLDER + "/application.yml");

      Assertions.assertTrue(applicationYaml.exists());

    } catch (Exception error) {
      Assertions.assertFalse(true);
    }

  }

  @Test
  @DisplayName("3 - Verifica se o projeto é spring.")
  public void testIfProjectIsSpring() {

    try {

      File pom = new File("pom.xml");
      BufferedReader reader = new BufferedReader(new FileReader(pom));

      boolean isValid = reader.lines()
          .filter(value -> value.contains("<groupId>org.springframework.boot</groupId>"))
          .findFirst().isPresent();

      Assertions.assertTrue(isValid);

    } catch (Exception error) {
      error.printStackTrace();
      Assertions.assertFalse(true);
    }

  }

  @Test
  @DisplayName("4 - Verifica se o projeto é war.")
  public void testIfProjectPackagingWar() {

    try {

      File pom = new File("pom.xml");
      BufferedReader reader = new BufferedReader(new FileReader(pom));

      boolean isValid = reader.lines().filter(value -> value.contains("<packaging>war</packaging>"))
          .findFirst().isPresent();

      Assertions.assertTrue(isValid);

    } catch (Exception error) {
      error.printStackTrace();
      Assertions.assertFalse(true);
    }

  }

  @Test
  @DisplayName("5 - Verifica se possui dependencia do JAX-RS.")
  public void testIfProjectContainsJerseyDependecy() {

    try {

      File pom = new File("pom.xml");
      BufferedReader reader = new BufferedReader(new FileReader(pom));

      boolean isValid = reader.lines().filter(value -> value.contains("spring-boot-starter-jersey"))
          .findFirst().isPresent();

      Assertions.assertTrue(isValid);

    } catch (Exception error) {
      error.printStackTrace();
      Assertions.assertFalse(true);
    }

  }

  @Test
  @DisplayName("6 - Verifica se possui a dependencia do JPA.")
  public void testIfProjectContainsJPADependecy() {

    try {

      File pom = new File("pom.xml");
      BufferedReader reader = new BufferedReader(new FileReader(pom));

      boolean isValid = reader.lines()
          .filter(value -> value.contains("spring-boot-starter-data-jpa")).findFirst().isPresent();

      Assertions.assertTrue(isValid);

    } catch (Exception error) {
      error.printStackTrace();
      Assertions.assertFalse(true);
    }

  }

  @Test
  @DisplayName("7 - Verifica se possui dependencia do H2 Database.")
  public void testIfProjectContainsH2Dependecy() {

    try {

      File pom = new File("pom.xml");
      BufferedReader reader = new BufferedReader(new FileReader(pom));

      boolean isValid =
          reader.lines().filter(value -> value.contains("com.h2database")).findFirst().isPresent();

      Assertions.assertTrue(isValid);

    } catch (Exception error) {
      error.printStackTrace();
      Assertions.assertFalse(true);
    }

  }

  @Test
  @DisplayName("8 - Verifica se o bloco da porta foi configurado.")
  public void testIfResourcesFileContainsPort() {

    try {

      File applicationYaml = new File(RESOURCES_TEST_FOLDER + "/application.yml");

      BufferedReader reader = new BufferedReader(new FileReader(applicationYaml));

      boolean isValid =
          reader.lines().filter(value -> value.contains("port: 8080")).findFirst().isPresent();

      Assertions.assertTrue(isValid);

    } catch (Exception error) {
      error.printStackTrace();
      Assertions.assertFalse(true);
    }

  }

  @Test
  @DisplayName("9 - Verifica se o bloco datasource existe.")
  public void testIfResourcesFileContainsDatasource() {

    try {

      File applicationYaml = new File(RESOURCES_TEST_FOLDER + "/application.yml");

      BufferedReader reader = new BufferedReader(new FileReader(applicationYaml));

      boolean isValid =
          reader.lines().filter(value -> value.contains("datasource:")).findFirst().isPresent();

      Assertions.assertTrue(isValid);

    } catch (Exception error) {
      error.printStackTrace();
      Assertions.assertFalse(true);
    }

  }

  @Test
  @DisplayName("10 - Verifica se a configuração de logging foi adicionada.")
  public void testIfResourcesFileContainsLogging() {

    try {

      File applicationYaml = new File(RESOURCES_TEST_FOLDER + "/application.yml");

      BufferedReader reader = new BufferedReader(new FileReader(applicationYaml));

      boolean isValid =
          reader.lines().filter(value -> value.contains("logging:")).findFirst().isPresent();

      Assertions.assertTrue(isValid);

    } catch (Exception error) {
      error.printStackTrace();
      Assertions.assertFalse(true);
    }

  }

}
