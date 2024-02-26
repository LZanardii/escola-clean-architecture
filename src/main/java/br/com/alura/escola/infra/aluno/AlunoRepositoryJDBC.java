package br.com.alura.escola.infra.aluno;

import br.com.alura.escola.domain.aluno.*;
import br.com.alura.escola.domain.exception.AlunoNotFoundException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoRepositoryJDBC implements AlunoRepository {

    private final Connection connection;

    public AlunoRepositoryJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void register(Aluno aluno) {
        try {
            String sql = "INSERT INTO ALUNO VALUES (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, aluno.getCpf().getNumero());
            ps.setString(2, aluno.getName());
            ps.setString(3, aluno.getEmail().getEndereco());
            ps.execute();

            sql = "INSERT INTO TELEFONES VALUES (?, ?)";
            ps = connection.prepareStatement(sql);

            for (Telefone telefone : aluno.getTelephoneList()) {
                ps.setString(1, telefone.getDdd());
                ps.setString(2, telefone.getNumero());
                ps.execute();
            }

        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public Aluno findByCpf(CPF cpf) {
        try {
            String sql = "SELECT id, nome, email FROM ALUNO WHERE cpf = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cpf.getNumero());

            ResultSet rs = ps.executeQuery();
            boolean encontrou = rs.next();
            if (!encontrou) {
                throw new AlunoNotFoundException(cpf);
            }

            String name = rs.getString("name");
            Email email = new Email(rs.getString("email"));
            Aluno encontrado = Aluno.builder()
                    .cpf(cpf)
                    .name(name)
                    .email(email)
                    .build();

            long id = rs.getLong("id");
            sql = "SELECT ddd, numero FROM TELEFONE WHERE aluno_id = ?";
            ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                String numero = rs.getString("numero");
                String ddd = rs.getString("ddd");
                encontrado.addTelephone(ddd, numero);
            }

            return encontrado;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Aluno> findAll() {
        try {
            String sql = "SELECT id, cpf, nome, email FROM ALUNO";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Aluno> alunos = new ArrayList<>();
            while (rs.next()) {
                CPF cpf = new CPF(rs.getString("cpf"));
                String name = rs.getString("name");
                Email email = new Email(rs.getString("email"));
                Aluno aluno = Aluno.builder()
                        .cpf(cpf)
                        .name(name)
                        .email(email)
                        .build();

                Long id = rs.getLong("id");
                sql = "SELECT ddd, numero FROM TELEFONE WHERE aluno_id = ?";
                PreparedStatement psTelefone = connection.prepareStatement(sql);
                psTelefone.setLong(1, id);
                ResultSet rsTelefone = psTelefone.executeQuery();
                while (rsTelefone.next()) {
                    String numero = rsTelefone.getString("numero");
                    String ddd = rsTelefone.getString("ddd");
                    aluno.addTelephone(ddd, numero);
                }

                alunos.add(aluno);
            }

            return alunos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
