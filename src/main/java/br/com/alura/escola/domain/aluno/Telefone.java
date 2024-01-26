package br.com.alura.escola.domain.aluno;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Telefone {
  /*
    VALUE OBJECT class: pois não possui um identificador único para o objeto
  */

  @Pattern(regexp = "[1-9]{2}", message = "ddd inválido")
  private String ddd;
  @Pattern(regexp = "[1-9][0-9]{7,8}", message = "número inválido")
  private String numero;

}
