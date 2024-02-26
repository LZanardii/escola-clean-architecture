package br.com.alura.escola.domain.aluno;

import java.util.List;

public interface AlunoRepository {

    void register(Aluno aluno);
    Aluno findByCpf(CPF cpf);
    List<Aluno> findAll();
}
