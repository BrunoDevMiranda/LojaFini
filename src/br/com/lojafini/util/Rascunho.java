package br.com.lojafini.util;

import br.com.lojafini.data.model.*;
import br.com.lojafini.services.Fabrica;
import br.com.lojafini.services.Venda;

import java.util.ArrayList;
import java.util.Scanner;

public class Rascunho {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //        TABELA DE INGREDIENTE PARA FAZER UM TERMINADO DOÇE
        //        1 TUBE Fini : 0,80 DE GOMA, 0,15 DE CORANTE, 1,0 AÇUCA
        //        1 DENTADURA VOVO : 1,2 GOMA , 0,85 CORANTE, 0,90 AÇUCA


        Ingrediente ingrediente1 = new Ingrediente("Goma", 100);
        Ingrediente ingrediente2 = new Ingrediente("Corante azul", 80);
        Ingrediente ingrediente3 = new Ingrediente("Açuca Crystal", 50);

        System.out.println("Quantidade de Goma Atual:" + ingrediente1.getPesoLiquidoAtual());
        System.out.println("Quantidade de Corante Atual:" + ingrediente2.getPesoLiquidoAtual());
        System.out.println("Quantidade de Açuca Atual:" + ingrediente3.getPesoLiquidoAtual());

        ArrayList<Inventario> inventarios = new ArrayList<>();
        inventarios.add(new Inventario(1, "TubeFini", 30));
        inventarios.add(new Inventario(2, "Dentadura vovó", 30));


        ArrayList<Cliente> clienteList = new ArrayList<>();
        clienteList.add(new Cliente(1, "Bruno", "123.359.963-55", "Bonsucesso", "26/07/1987"));
        clienteList.add(new Cliente(2, "João", "128.955.231-45", "Ramos", "11/05/2011"));

        ArrayList<Vendedor> vendedorsList = new ArrayList<>();
        vendedorsList.add(new Vendedor(1, "Gustavo", "888.666.777-11", "Jd Primavera", "05/02/2018"));
        vendedorsList.add(new Vendedor(2, "Karol", "818.566.111-11", "J`P'A", "29/03/1990"));

        ArrayList<Produto> produtoList = new ArrayList<>();
        produtoList.add(new Produto(2, "Dentadura Vovó", 4.60));
        produtoList.add(new Produto(1, "Tubes Fini", 8.15));

        ArrayList<Venda> vendaList = new ArrayList<>();


        for (int i = 0; i < inventarios.size(); i++) {
            System.out.println("Quantidade em Estoque: " + inventarios.get(i).toString());
        }

        System.out.println("Quantos TubeFini deseja comprar?");
        int qntTubes = scanner.nextInt();

        if (inventarios.get(0).getQntEstoqueInicial() >= qntTubes) {
            Venda venda1 = new Venda(1, 1598, "21/03/2023", produtoList.get(0).getPreco(), clienteList.get(0).getNome(), vendedorsList.get(0).getNome(), produtoList.get(0).getNome(),
                    qntTubes, (qntTubes * produtoList.get(0).getPreco()));
            vendaList.add(venda1);

            System.out.println("--------------------------------------------------------------------------------------------------------");
            inventarios.get(0).setQntEstoqueAtual(inventarios.get(0).getQntEstoqueInicial() - vendaList.get(0).getQuantidades());
            System.out.println("Quantidade em Estoque Tube Atualizado: " + inventarios.get(0).getQntEstoqueAtual());
            System.out.println("--------------------------------------------------------------------------------------------------------");


        } else {
            System.out.println("Quantidade não Disponivel");

            System.out.println("Quantidade em Estoque: " + inventarios.get(0).getQntEstoqueInicial());

            System.out.println("Deseja fabricar mais? , Sim[1] ou Não[2]");

            int escolhas = scanner.nextInt();
            int tubeCriado = 0;
            switch (escolhas) {
                case 1:

                    System.out.println("Quantidade de Goma Atual:" + ingrediente1.getPesoLiquidoAtual());
                    System.out.println("Quantidade de Corante Atual:" + ingrediente2.getPesoLiquidoAtual());
                    System.out.println("Quantidade de Açuca Atual:" + ingrediente3.getPesoLiquidoAtual());


                    //        TABELA DE INGREDIENTE PARA FAZER UM TERMINADO DOÇE
                    //        1 TUBE Fini : 0,80 DE GOMA, 0,15 DE CORANTE, 1,0 AÇUCA
                    //        1 DENTADURA VOVO : 1,2 GOMA , 0,85 CORANTE, 0,90 AÇUCA
                    float quantUsada1 = 0.80F;
                    float quantUsada2 = 0.15F;
                    float quantUsada3 = 1.0F;

                    System.out.println("----------------------------------Tubo Criado--------------------------------------------");
                    while (inventarios.get(0).getQntEstoqueInicial() + tubeCriado < qntTubes) {

                        System.out.println("Tube criado :" + tubeCriado);


                        ingrediente1.setPesoLiquidoAtual(ingrediente1.getPesoLiquidoAtual() - (quantUsada1));
                        ingrediente2.setPesoLiquidoAtual(ingrediente2.getPesoLiquidoAtual() - (quantUsada2));
                        ingrediente3.setPesoLiquidoAtual(ingrediente3.getPesoLiquidoAtual() - (quantUsada3));

                        tubeCriado++;



                    } if (((tubeCriado + inventarios.get(0).getQntEstoqueInicial() >= qntTubes))) {

                    Venda venda1 = new Venda(1, 1598, "21/03/2023", produtoList.get(0).getPreco(), clienteList.get(0).getNome(), vendedorsList.get(0).getNome(), produtoList.get(0).getNome(),
                            qntTubes, (qntTubes * produtoList.get(0).getPreco()));

                    vendaList.add(venda1);

                }



            }
        }


        System.out.println("Quantas Dentadura deseja comprar?");
        int qntDentadura = scanner.nextInt();
        if (inventarios.get(1).getQntEstoqueInicial() >= qntDentadura) {
            Venda venda2 = new Venda(2, 1598, "21/03/2023", produtoList.get(1).getPreco(), clienteList.get(0).getNome(), vendedorsList.get(0).getNome(), produtoList.get(1).getNome(),
                    qntDentadura, (qntDentadura * produtoList.get(1).getPreco()));
            vendaList.add(venda2);
            System.out.println("--------------------------------------------------------------------------------------------------------");
            inventarios.get(1).setQntEstoqueAtual(inventarios.get(1).getQntEstoqueInicial() - vendaList.get(1).getQuantidades());
            System.out.println("Quantidade em Estoque Dentadura Atualizado: " + inventarios.get(1).getQntEstoqueAtual());
            System.out.println("--------------------------------------------------------------------------------------------------------");


        } else {
            System.out.println("Quantidade não Disponivel");

            System.out.println("Quantidade em Estoque: " + inventarios.get(0).getQntEstoqueInicial());

            System.out.println("Deseja fabricar mais? , Sim[1] ou Não[2]");

            int option = scanner.nextInt();
            int dentCriado = 0;
            switch (option) {
                case 1:

                    System.out.println("Quantidade de Goma Atual:" + ingrediente1.getPesoLiquidoAtual());
                    System.out.println("Quantidade de Corante Atual:" + ingrediente2.getPesoLiquidoAtual());
                    System.out.println("Quantidade de Açuca Atual:" + ingrediente3.getPesoLiquidoAtual());


                    // TABELA DE INGREDIENTE PARA FAZER UM TERMINADO DOÇE
                    // 1 TUBE Fini : 0,80 DE GOMA, 0,15 DE CORANTE, 1,0 AÇUCA
                    // 1 DENTADURA VOVO : 1,2 GOMA , 0,85 CORANTE, 0,90 AÇUCA
                    float quantUsada1 = 1.2F;
                    float quantUsada2 = 0.85F;
                    float quantUsada3 = 0.9F;

                    System.out.println("----------------------------------Dentadura Criada--------------------------------------------");
                    while (inventarios.get(1).getQntEstoqueInicial() + dentCriado < qntDentadura) {

                        System.out.println("Dentadura criada :" + dentCriado);

                        ingrediente1.setPesoLiquidoAtual(ingrediente1.getPesoLiquidoAtual() - (quantUsada1));
                        ingrediente2.setPesoLiquidoAtual(ingrediente2.getPesoLiquidoAtual() - (quantUsada2));
                        ingrediente3.setPesoLiquidoAtual(ingrediente3.getPesoLiquidoAtual() - (quantUsada3));
                        dentCriado++;
                        }


                    }if (((dentCriado + inventarios.get(1).getQntEstoqueInicial() >= qntDentadura))) {

                    Venda venda2 = new Venda(2, 1598, "21/03/2023", produtoList.get(1).getPreco(), clienteList.get(0).getNome(), vendedorsList.get(0).getNome(), produtoList.get(1).getNome(),
                            qntDentadura, (qntDentadura * produtoList.get(1).getPreco()));

                    vendaList.add(venda2);


            }

        }


        System.out.println("-----------DETALHES DA COMPRA------------------");
        System.out.println("Nota Fiscal: " + vendaList.get(0).getNotaFiscal());
        System.out.println("Data da Compra: " + vendaList.get(0).getData());
        System.out.println("Nome do Cliente: " + vendaList.get(0).getNomeCliente());
        System.out.println("Nome do Vendedor: " + vendaList.get(0).getNomeVendedor());

        System.out.println("Produto 1: " + vendaList.get(0).getNomeProduto() + "....................R$ " + vendaList.get(0).getValor());
        System.out.println("Quantidade: " + vendaList.get(0).getQuantidades() + "..............................R$ " + vendaList.get(0).getTotal());

        System.out.println("Produto 2: " + vendaList.get(1).getNomeProduto() + ".........................R$ " + vendaList.get(1).getValor());
        System.out.println("Quantidade: " + vendaList.get(1).getQuantidades() + "..............................R$ " + vendaList.get(1).getTotal());

        double subTotal = vendaList.get(0).getTotal() + vendaList.get(1).getTotal();
        System.out.println("");

        System.out.println("SubTotal: .................................R$ " + subTotal);


        System.out.println("----------------------------------Estoque de Material Atualizado--------------------------------------------");


        System.out.println("Quantidade de Goma Atual:" + ingrediente1.getPesoLiquidoAtual());
        System.out.println("Quantidade de Corante Atual:" + ingrediente2.getPesoLiquidoAtual());
        System.out.println("Quantidade de Açuca Atual:" + ingrediente3.getPesoLiquidoAtual());


    }

}
