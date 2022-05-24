package edu.step.employeeManager.config;

import edu.step.employeeManager.exceptions.EntityNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;


@ControllerAdvice
public class GlobalExceptionHandler {

  private final Logger logger = LogManager.getLogger();

  @ExceptionHandler(EntityNotFoundException.class)
  public ResponseEntity<ApiCallError<String>> handleNotFoundException(HttpServletRequest request, EntityNotFoundException ex) {
    logger.error("NotFoundException {}\n", request.getRequestURI(), ex);

    return ResponseEntity
      .status(HttpStatus.NOT_FOUND)
      .body(new ApiCallError<>("Not found exception", Collections.singletonList(ex.getMessage())));
  }

}


class ApiCallError<T> {

  private String message;
  private List<T> details;

  public ApiCallError() {
  }

  public ApiCallError(String message, List<T> details) {
    this.message = message;
    this.details = details;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public List<T> getDetails() {
    return details;
  }

  public void setDetails(List<T> details) {
    this.details = details;
  }
}
