package br.com.alura.escola.aplicacao.aluno.register;

import br.com.alura.escola.domain.aluno.Aluno;
import br.com.alura.escola.domain.aluno.CPF;
import br.com.alura.escola.infra.aluno.AlunoRepositoryH2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlunoRegisterTest {


    @Test
    void shouldRegister(){

        String cpf = "";

        AlunoRepositoryH2 repositoryH2 = new AlunoRepositoryH2();

        AlunoRegister register = new AlunoRegister(repositoryH2);

        register.execute(new AlunoDto("05046035073", "Leonardo", "email@teste.com"));

        Aluno registeredAluno = repositoryH2.findByCpf(new CPF("05046035073"));

        assertEquals("05046035073", registeredAluno.getCpf().getNumero());
        assertEquals("Leonardo", registeredAluno.getName());
        assertEquals("email@teste.com", registeredAluno.getEmail().getEndereco());

    }
}
