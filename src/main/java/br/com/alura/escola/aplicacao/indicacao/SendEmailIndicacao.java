package br.com.alura.escola.aplicacao.indicacao;

import br.com.alura.escola.domain.aluno.Aluno;

public interface SendEmailIndicacao {

    void send(Aluno indicado);
}
