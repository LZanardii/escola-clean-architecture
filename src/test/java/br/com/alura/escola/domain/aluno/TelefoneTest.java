package br.com.alura.escola.domain.aluno;

import br.com.alura.escola.domain.aluno.Telefone;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TelefoneTest {

  private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
  private final Validator validator = factory.getValidator();

  @Test
  public void testValidTelefone() {
    Telefone validEmail = new Telefone("51", "992767370");
    assertTrue(validator.validate(validEmail).isEmpty());
  }

  @Test
  public void testInvalidTelefone_DDD_Numero() {
    Telefone invalidEmail = new Telefone("01", "5213254");
    Set<ConstraintViolation<Telefone>> violations = validator.validate(invalidEmail);
    assertEquals(2, violations.size());
  }
}
