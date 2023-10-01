package Modules;

import java.util.Objects;

public class Pessoa {
    private int id;
    private String nome;
    private String telefone;
    private String CPF;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pessoa pessoa = (Pessoa) o;

        if (id != pessoa.id) return false;
        if (!Objects.equals(nome, pessoa.nome)) return false;
        if (!Objects.equals(telefone, pessoa.telefone)) return false;
        return Objects.equals(CPF, pessoa.CPF);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (telefone != null ? telefone.hashCode() : 0);
        result = 31 * result + (CPF != null ? CPF.hashCode() : 0);
        return result;
    }

    public Pessoa(){

    }
    public Pessoa(String nome, String telefone, String CPF){
        this.CPF = CPF;
        this.nome = nome;
        this.telefone = telefone;
    }
    public Pessoa(int id, String nome, String telefone, String CPF){
        this.id = id;
        this.CPF = CPF;
        this.nome = nome;
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", CPF='" + CPF + '\'' +
                '}';
    }
}
