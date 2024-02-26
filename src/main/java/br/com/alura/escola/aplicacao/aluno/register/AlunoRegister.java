package br.com.alura.escola.aplicacao.aluno.register;

import br.com.alura.escola.domain.aluno.AlunoRepository;

public class AlunoRegister {

    private final AlunoRepository repository;


    public AlunoRegister(AlunoRepository repository) {
        this.repository = repository;
    }

    public void execute(AlunoDto alunoDto) {
        repository.register(alunoDto.toAluno());
    }
}
