package br.com.alura.escola.domain.aluno;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Email {
  /*
    VALUE OBJECT class: pois não possui um identificador único para o objeto
  */

  @NotNull
  @jakarta.validation.constraints.Email
  private String email;
}
