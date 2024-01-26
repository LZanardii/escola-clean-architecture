package br.com.alura.escola.domain.aluno;

import br.com.alura.escola.domain.aluno.Email;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmailTest {

  private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
  private final Validator validator = factory.getValidator();

  @Test
  public void testValidEmail() {
    Email validEmail = new Email("test@example.com");
    assertTrue(validator.validate(validEmail).isEmpty());
  }

  @Test
  public void testInvalidEmail() {
    Email invalidEmail = new Email("invalid-email");
    Set<ConstraintViolation<Email>> violations = validator.validate(invalidEmail);
    assertEquals("deve ser um endereço de e-mail bem formado", violations.stream().findFirst().orElseThrow().getMessage());
  }

  @Test
  public void testNullEmail() {
    Email nullEmail = new Email(null);
    Set<ConstraintViolation<Email>> violations = validator.validate(nullEmail);
    assertEquals("não deve ser nulo", violations.stream().findFirst().orElseThrow().getMessage());
  }
}
