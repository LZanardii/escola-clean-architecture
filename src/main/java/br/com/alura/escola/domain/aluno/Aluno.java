package br.com.alura.escola.domain.aluno;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
public class Aluno  {
  /*
    Entity class: diferente da Entity class de uma JPA, a entity class para o CLEAN ARCHITECTURE é
    considerada uma classe espelho da vida real e deve possuir um atributo de identificador único.
  */

  private CPF cpf;

  @NonNull
  private String name;

  private Email email;

  private String password;

  private List<Telefone> telephoneList = new ArrayList<>();

  public void addTelephone(String ddd, String numero){
    this.telephoneList.add(new Telefone(ddd, numero));
  }

  public void addTelephone(Telefone telefone){
    this.telephoneList.add(telefone);
  }
}
