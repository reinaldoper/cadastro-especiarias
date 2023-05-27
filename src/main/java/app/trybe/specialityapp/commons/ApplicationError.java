package app.trybe.specialityapp.commons;

import javax.ws.rs.core.Response.Status;

public class ApplicationError {

  private Status status;
  private String message;

  public ApplicationError(Status status, String message) {
    this.status = status;
    this.message = message;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

}
