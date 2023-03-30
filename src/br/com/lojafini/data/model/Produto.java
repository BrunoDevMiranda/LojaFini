package br.com.lojafini.data.model;


import java.util.ArrayList;
import java.util.List;

public class Produto {

    private Integer ID;
    private String nome;
    private Double preco;



    public Produto() {
    }

    public Produto(Integer ID, String nome, Double preco) {
        this.ID = ID;
        this.nome = nome;
        this.preco = preco;

    }

    public void print(){
        System.out.println("Nome: "+ nome);
        System.out.println("Preço unitario: "+ preco);
    }

    @Override
    public String toString() {
        return "Produto{" +
                "ID: " + ID +
                ", nome :'" + nome + '\'' +
                ", preco :" + preco +
                '}';
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
