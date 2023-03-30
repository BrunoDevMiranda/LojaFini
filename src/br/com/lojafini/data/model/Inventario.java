package br.com.lojafini.data.model;

import java.util.PrimitiveIterator;

public class Inventario {
     private Integer ID;
     private String nome;
     private int qntEstoqueInicial;
     private int qntEstoqueAtual;

    public Inventario() {
    }

    public Inventario(Integer ID, String nome, int qntEstoqueInicial) {
        this.ID = ID;
        this.nome = nome;
        this.qntEstoqueInicial = qntEstoqueInicial;
        this.qntEstoqueAtual = qntEstoqueInicial;
    }

    @Override
    public String toString() {
        return "Inventario{" +
                "ID: " + ID +
                ", nome: '" + nome + '\'' +
                ", qntEstoqueInicial: " + qntEstoqueInicial +
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

    public int getQntEstoqueInicial() {
        return qntEstoqueInicial;
    }

    public void setQntEstoqueInicial(int qntEstoqueInicial) {
        this.qntEstoqueInicial = qntEstoqueInicial;
    }

    public int getQntEstoqueAtual() {
        return qntEstoqueAtual;
    }

    public void setQntEstoqueAtual(int qntEstoqueAtual) {
        this.qntEstoqueAtual = qntEstoqueAtual;
    }
}
