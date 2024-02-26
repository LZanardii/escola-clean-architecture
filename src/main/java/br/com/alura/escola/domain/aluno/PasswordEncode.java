package br.com.alura.escola.domain.aluno;

public interface PasswordEncode {

    String encodePassword(String senha);

    boolean validatePassword(String EncodedPassword, String passowrd);
}
