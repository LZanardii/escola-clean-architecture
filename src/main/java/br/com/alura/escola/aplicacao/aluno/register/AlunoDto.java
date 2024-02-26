package br.com.alura.escola.aplicacao.aluno.register;

import br.com.alura.escola.domain.aluno.Aluno;
import br.com.alura.escola.domain.aluno.CPF;
import br.com.alura.escola.domain.aluno.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AlunoDto {

    private String cpf;
    private String name;
    private String email;

    public Aluno toAluno() {
        return Aluno.builder()
                .cpf(new CPF(cpf))
                .name(this.name)
                .email(new Email(this.email))
                .build();
    }

}
