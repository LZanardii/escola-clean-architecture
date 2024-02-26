package br.com.alura.escola.infra.indicacao;

import br.com.alura.escola.aplicacao.indicacao.SendEmailIndicacao;
import br.com.alura.escola.domain.aluno.Aluno;

public class SendEmailIndicacaoWithJavaMail implements SendEmailIndicacao {

    @Override
    public void send(Aluno indicado) {
        // logica de envio de email com a lib Java Mail
    }
}
