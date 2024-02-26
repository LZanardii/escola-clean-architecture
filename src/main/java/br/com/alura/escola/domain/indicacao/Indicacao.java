package br.com.alura.escola.domain.indicacao;

import br.com.alura.escola.domain.aluno.Aluno;
import lombok.*;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Builder
@Getter
@Setter
public class Indicacao {

    @NonNull
    private Aluno indicado;

    @NonNull
    private Aluno indicante;

    @NonNull
    private LocalDateTime dataIndicacao;

}

