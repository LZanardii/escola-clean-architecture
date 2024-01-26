package br.com.alura.escola.domain.aluno;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CPF {
   /*
    VALUE OBJECT class: pois não possui um identificador único para o objeto
  */

  @NotNull
  @org.hibernate.validator.constraints.br.CPF
  private String cpf;
}
