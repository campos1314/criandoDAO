package org.example;

import DAOs.IPessoaDAO;
import DAOs.PessoaDAO;
import Modules.Pessoa;

public class Main {
    public static void main(String[] args) {
        Pessoa ps = new Pessoa("Anani", "65996451154", "0000000000");

        IPessoaDAO p = new PessoaDAO();

        //p.insert(ps);

        //var x = p.findByName(ps.getNome());
        //System.out.println(x.toString());

        //var listinha = p.findAll();
        //System.out.println(listinha.toString());

        //var achandoPeloCPF = p.findByCPF("00000000000");
        //System.out.println(achandoPeloCPF.toString());
        //achandoPeloCPF.setNome("Anani Lemes Barbosa");

        //var y = p.delete(achandoPeloCPF);
        //System.out.println(p.findAll().toString());

        //var x = p.update(achandoPeloCPF);
    }
}
