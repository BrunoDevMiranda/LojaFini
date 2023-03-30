package br.com.lojafini.services;



public class Venda {
    private Integer ID;
    private int notaFiscal;
    private String data;
    private double valor;
    private String nomeCliente;
    private String nomeVendedor;
    private String nomeProduto;


    private int quantidades;
    private double total;




    public Venda() {

    }

    public Venda(Integer ID, int notaFiscal, String data, double valor, String nomeCliente, String nomeVendedor, String nomeProduto, int quantidades, double total) {
        this.ID = ID;
        this.notaFiscal = notaFiscal;
        this.data = data;
        this.valor = valor;
        this.nomeCliente = nomeCliente;
        this.nomeVendedor = nomeVendedor;
        this.nomeProduto = nomeProduto;
        this.quantidades = quantidades;
        this.total = total;
    }

    public void print(){
        System.out.println("Nota Fiscal: "+ notaFiscal);
        System.out.println("Data da Vendsa: "+ data);
        System.out.println("Valor: "+ valor);
        System.out.println("Cliente: "+ nomeCliente);
        System.out.println("Vendedor: "+ nomeVendedor);
        System.out.println("Quantidade: "+ quantidades);
        System.out.println("Total: "+ total);

    }

    @Override
    public String toString() {
        return "Venda: " +
                "ID :" + ID +
                ", " +
                "  NotaFiscal :" + notaFiscal +
                ", Data :'" + data + '\'' +
                ", Valor: " + valor +
                ", Cliente: '" + nomeCliente + '\'' +
                ", Vendedor: '" + nomeVendedor + '\'' +
                ", Produto: '" + nomeProduto + '\'' +
                ", Quantidades: " + quantidades +
                ", Total: " + total +
                '}';
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public int getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(int notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getNomeVendedor() {
        return nomeVendedor;
    }

    public void setNomeVendedor(String nomeVendedor) {
        this.nomeVendedor = nomeVendedor;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getQuantidades() {
        return quantidades;
    }

    public void setQuantidades(int quantidades) {
        this.quantidades = quantidades;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}




