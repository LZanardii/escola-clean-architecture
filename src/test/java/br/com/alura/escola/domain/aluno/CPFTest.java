package br.com.alura.escola.domain.aluno;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CPFTest {

  private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
  private final Validator validator = factory.getValidator();

  @Test
  public void testValidCPF() {
    CPF validEmail = new CPF("633.590.410-11");
    assertTrue(validator.validate(validEmail).isEmpty());
  }
  @Test
  public void testValidCPF_withoutPonctuation() {
    CPF validEmail = new CPF("63359041011");
    assertTrue(validator.validate(validEmail).isEmpty());
  }

  @Test
  public void testInvalidCPF() {
    CPF invalidEmail = new CPF("00000000000");
    Set<ConstraintViolation<CPF>> violations = validator.validate(invalidEmail);
    assertEquals("número do registro de contribuinte individual brasileiro (CPF) inválido", violations.stream().findFirst().orElseThrow().getMessage());
  }

  @Test
  public void testNullCPF() {
    CPF nullEmail = new CPF(null);
    Set<ConstraintViolation<CPF>> violations = validator.validate(nullEmail);
    assertEquals("não deve ser nulo", violations.stream().findFirst().orElseThrow().getMessage());
  }
}
