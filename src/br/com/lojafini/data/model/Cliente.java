package br.com.lojafini.data.model;

public class Cliente extends Pessoa{

    public Cliente(Integer ID, String nome, String cpf, String endereco, String nascimento) {
        super(ID, nome, cpf, endereco, nascimento);
    }
}
