package br.com.alura.escola.domain.aluno;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Builder
@Getter
@Setter
public class Aluno  {
  /*
    Entity class: diferente da Entity class de uma JPA, a entity class para o CLEAN ARCHITECTURE é
    considerada uma classe espelho da vida real e deve possuir um atributo de identificador único.
  */

  @NonNull
  private CPF cpf;

  @NonNull
  private String nome;

  @NonNull
  private Email email;

  private List<Telefone> telefoneList = new ArrayList<>();

  public void adicionarTelefone(String ddd, String numero){
    this.telefoneList.add(new Telefone(ddd, numero));
  }

  public void adicionarTelefone(Telefone telefone){
    this.telefoneList.add(telefone);
  }
}
