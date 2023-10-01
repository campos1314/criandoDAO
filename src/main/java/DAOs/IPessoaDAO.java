package DAOs;

import Modules.Pessoa;

import java.util.List;

public interface IPessoaDAO {
    List<Integer> findByName(String Nome);
    Pessoa findByCPF(String CPF);
    List<Pessoa> findAll();

    boolean insert(Pessoa p);
    boolean update(Pessoa p);
    boolean delete(Pessoa p);
}

