package br.com.lojafini.data.model;

public abstract class Pessoa {

    private Integer ID; //index
    private String nome;
    private String cpf;
    private String endereco;
    private String nascimento;
    public Pessoa(Integer Id, String nome, String cpf, String endereco, String nascimento) {
        this.ID = Id;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.nascimento = nascimento;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "ID: " + ID +
                ", nome: '" + nome + '\'' +
                ", cpf: '" + cpf + '\'' +
                ", endereco: '" + endereco + '\'' +
                ", nascimento: '" + nascimento + '\'' +
                '}';
    }

    public Integer getId() {
        return ID;
    }

    public void setId(Integer Id) {
        this.ID = Id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public void print() {
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Endereço: " + endereco);
        System.out.println("Data Nascimento: " + nascimento);
    }
}
