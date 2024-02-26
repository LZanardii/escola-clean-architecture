package br.com.alura.escola.domain.exception;

import br.com.alura.escola.domain.aluno.CPF;

public class AlunoNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public AlunoNotFoundException(CPF cpf) {
        super("Aluno nao encontrado com CPF: " + cpf.getNumero());
    }
}
