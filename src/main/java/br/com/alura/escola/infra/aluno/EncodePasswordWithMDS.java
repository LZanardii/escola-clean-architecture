package br.com.alura.escola.infra.aluno;

import br.com.alura.escola.domain.aluno.PasswordEncode;

public class EncodePasswordWithMDS implements PasswordEncode {
    @Override
    public String encodePassword(String senha) {
        return null;
    }

    @Override
    public boolean validatePassword(String EncodedPassword, String passowrd) {
        return false;
    }
}
