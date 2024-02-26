package br.com.alura.escola.infra.aluno;

import br.com.alura.escola.domain.aluno.Aluno;
import br.com.alura.escola.domain.aluno.AlunoRepository;
import br.com.alura.escola.domain.aluno.CPF;
import br.com.alura.escola.domain.exception.AlunoNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class AlunoRepositoryH2 implements AlunoRepository {


    private List<Aluno> matriculados = new ArrayList<>();

    @Override
    public void register(Aluno aluno) {
        this.matriculados.add(aluno);
    }

    @Override
    public Aluno findByCpf(CPF cpf) {
        return this.matriculados.stream()
                .filter(a -> a.getCpf().getNumero().equals(cpf.getNumero()))
                .findFirst()
                .orElseThrow(() -> new AlunoNotFoundException(cpf));
    }

    @Override
    public List<Aluno> findAll() {
        return this.matriculados;
    }


}
