package br.com.alura.escola.domain.aluno;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.validation.annotation.Validated;

@AllArgsConstructor
@Getter
@Setter
public class CPF {
   /*
    VALUE OBJECT class: pois não possui um identificador único para o objeto
  */

  @NotNull
  private @Valid String numero;
}
