package br.com.lojafini.data.model;



public class Inventario {
    private Integer ID;
    private String nome;
    private int qntEstoqueInicial;
    private int qntEstoqueAtual;

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
