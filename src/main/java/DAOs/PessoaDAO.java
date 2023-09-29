package DAOs;

import Modules.Pessoa;
import org.example.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO implements IPessoaDAO{

    // variavel que recebe a conexão com o banco de dados
    ConexaoFactory conn = new ConexaoFactory();
    Connection conexao = conn.getConnection();



    @Override
    public List<Pessoa> findAll() {
        List<Pessoa> pessoas = new ArrayList<>();
        try {
            String sql = "SELECT id, nome, CPF, telefone FROM usuarios";
            PreparedStatement statement = conexao.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                var pessoa = new Pessoa();
                pessoa.setId(resultSet.getInt("id"));
                pessoa.setNome(resultSet.getString("nome"));
                pessoa.setCPF(resultSet.getString("CPF"));
                pessoa.setTelefone(resultSet.getString("telefone"));
                pessoas.add(pessoa);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pessoas;
    }

}
