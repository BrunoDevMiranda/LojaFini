package br.com.lojafini.data.model;

public class Ingrediente {
    private String nome;
    private float pesoLiquidoInicial;
    private float pesoLiquidoAtual;

    public Ingrediente(String nome, float pesoLiquidoInicial) {
        this.nome = nome;
        this.pesoLiquidoInicial = pesoLiquidoInicial;
        this.pesoLiquidoAtual = pesoLiquidoInicial;
    }
    public float getPesoLiquidoAtual() {
        return pesoLiquidoAtual;
    }

    public void setPesoLiquidoAtual(float pesoLiquidoAtual) {
        this.pesoLiquidoAtual = pesoLiquidoAtual;
    }
}
