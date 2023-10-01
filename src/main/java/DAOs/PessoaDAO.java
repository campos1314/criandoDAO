package DAOs;

import Modules.Pessoa;
import ch.qos.logback.classic.Logger;
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
    public boolean insert(Pessoa p) {
        try {
            String sql = "INSERT INTO pessoa (nome, telefone, CPF) VALUES (?, ?, ?)";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, p.getNome());
            statement.setString(2, p.getTelefone());
            statement.setString(3, p.getCPF());

            int rowsInserted = statement.executeUpdate();

            return rowsInserted > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir pessoa no banco de dados.", e);
        }
    }

    @Override
    public boolean update(Pessoa p){
        try{
            String sql = "UPDATE pessoa SET nome = ?, telefone = ?, CPF = ? WHERE id = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, p.getNome());
            statement.setString(2, p.getTelefone());
            statement.setString(3, p.getCPF());
            statement.setInt(4, p.getId());

            statement.executeUpdate();
            statement.close();
            return true;

        }catch (SQLException e){
            throw  new RuntimeException("Erro ao fazer o update pessoa no banco de dados.", e);
        }
    }
    @Override
    public boolean delete(Pessoa p){
        try{
            String sql = "DELETE FROM pessoa WHERE id = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, p.getId());

            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;

        }catch (SQLException e){
            throw  new RuntimeException("Erro ao deletar pessoa no banco de dados.", e);

        }
    }
    @Override
    public List<Integer> findByName(String nome) {
        List<Integer> ids = new ArrayList<>();
        try {
            String sql = "SELECT id FROM pessoa WHERE nome = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, nome);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                ids.add(id);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ids;
    }
    @Override
    public Pessoa findByCPF(String CPF){
        Pessoa p = null;
        try{
            String sql = "SELECT * FROM pessoa WHERE CPF = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, CPF);
            ResultSet resultSet = stmt.executeQuery();

            if(resultSet.next()){
                p = new Pessoa();
                p.setId(resultSet.getInt("id"));
                p.setNome(resultSet.getString("nome"));
                p.setTelefone(resultSet.getString("telefone"));
                p.setCPF(resultSet.getString("CPF"));
            }
            resultSet.close();
            stmt.close();

        }catch(SQLException e){
            e.printStackTrace();

        }
        return p;
    }
    @Override
    public List<Pessoa> findAll() {
        List<Pessoa> pessoas = new ArrayList<>();
        try {
            String sql = "SELECT id, nome, CPF, telefone FROM pessoa";
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
