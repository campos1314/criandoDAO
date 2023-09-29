package DAOs;

import Modules.Pessoa;

import java.util.List;

public interface IPessoaDAO {
    Pessoa findById(int id);
    List<Pessoa> findAll();

    boolean insert(Pessoa p);
    boolean update(Pessoa p);
    boolean delete(int id);
}

