package br.com.lojafini.data.model;

public class Ingrediente {
    private String nome;
    private float pesoLiquidoInicial;
    private float pesoLiquidoAtual;


    public Ingrediente() {
    }

    public Ingrediente(String nome, float pesoLiquidoInicial) {
        this.nome = nome;
        this.pesoLiquidoInicial = pesoLiquidoInicial;
        this.pesoLiquidoAtual = pesoLiquidoInicial;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPesoLiquidoInicial() {
        return pesoLiquidoInicial;
    }

    public void setPesoLiquidoInicial(float pesoLiquidoInicial) {
        this.pesoLiquidoInicial = pesoLiquidoInicial;
    }

    public float getPesoLiquidoAtual() {
        return pesoLiquidoAtual;
    }

    public void setPesoLiquidoAtual(float pesoLiquidoAtual) {
        this.pesoLiquidoAtual = pesoLiquidoAtual;
    }
}
