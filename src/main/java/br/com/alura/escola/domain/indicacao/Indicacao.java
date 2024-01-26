package br.com.alura.escola.domain.indicacao;

import br.com.alura.escola.domain.aluno.Aluno;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class Indicacao {
   /*
    VALUE OBJECT class: pois não possui um identificador único para o objeto
  */

  private Aluno indicador;
  private Aluno indicado;
  private LocalDateTime dataIndicacao;
}
