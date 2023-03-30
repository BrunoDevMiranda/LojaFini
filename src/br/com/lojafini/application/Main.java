package br.com.lojafini.application;

import br.com.lojafini.data.model.*;
import br.com.lojafini.services.EntrarSistema;
import br.com.lojafini.services.Venda;
import br.com.lojafini.util.PdfText;
import br.com.lojafini.util.Relatorio;
import br.com.lojafini.util.RelatorioSimples;
import com.lowagie.text.DocumentException;


import java.util.ArrayList;


import java.util.Scanner;

import static java.lang.System.*;


public class Main {

    public static final String QUANTIDADE_DE_GOMA_ATUAL = "Quantidade de Goma Atual:";
    public static final String QUANTIDADE_DE_CORANTE_ATUAL = "Quantidade de Corante Atual:";
    public static final String QUANTIDADE_DE_AÇUCA_ATUAL = "Quantidade de Açuca Atual:";

    public static void main(String[] args) throws DocumentException {


        //        TABELA DE INGREDIENTE PARA FAZER UM TERMINADO DOÇE
        //        1 TUBE Fini : 0,80 DE GOMA, 0,15 DE CORANTE, 1,0 AÇUCA
        //        1 DENTADURA VOVO : 1,2 GOMA , 0,85 CORANTE, 0,90 AÇUCA


        Ingrediente ingrediente1 = new Ingrediente("Goma", 100);
        Ingrediente ingrediente2 = new Ingrediente("Corante azul", 80);
        Ingrediente ingrediente3 = new Ingrediente("Açuca Crystal", 50);



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
        produtoList.add(new Produto(1, "Dentadura Vovó", 4.60));
        produtoList.add(new Produto(2, "Tubes Fini", 8.15));

        ArrayList<Venda> vendaList = new ArrayList<>();


//
        Scanner scanner = new Scanner(in);
        EntrarSistema user = new EntrarSistema();

        int tentativas = 3;
        while (tentativas > 0) {

            out.println("Digite seu usúario");
            String userName = scanner.nextLine();
            out.println("Digite seu Senha");
            String senha = scanner.nextLine();
            out.println("Tentativa: " + (4 - tentativas) + " :");

            if (userName.equals(user.getUsuario()) && senha.equals(user.getSenha())) {
                out.println("||-BEM VINDO AO SISTEMA-||");
                out.println("||-NAVEGAÇÃO DO MENU-||");
                int escolha;
                do {
                    out.println("|---ESCOLHA A OPÇÃO DESEJADA---| ");
                    out.println("- - - - - - - - - - -");
                    out.println("[1]-|-CLIENTES CADASTRADOS-| ");
                    out.println("[2]-|-VENDEDORES CADASTRADOS-| ");
                    out.println("[3]-|-PRODUTOS-| ");
                    out.println("[4]-|-VENDA-| ");
                    out.println("[5]-|-IMPRIMIR-| ");
                    out.println("[0]-|-SAIR-| ");
                    escolha = scanner.nextInt();
                    switch (escolha) {
                        case 1 -> {
                            out.println("------|-CLIENTE-|-------");
                            for (int i = 0; i < clienteList.size(); i++) {
                                out.println(clienteList.get(i).toString());
                            }
                        }
                        case 2 -> {
                            out.println("-------------------------------------VENDEDOR---------------------------------------------------------------");
                            for (int i = 0; i < vendedorsList.size(); i++) {
                                out.println(vendedorsList.get(i).toString());
                            }
                        }
                        case 3 -> {
                            out.println("--------------------------------------------PRODUTO---------------------------------------------------------");
                            for (int i = 0; i < produtoList.size(); i++) {
                                out.println(produtoList.get(i).toString());
                            }
                        }
                        case 4 -> {
                            for (int i = 0; i < inventarios.size(); i++) {
                                out.println("Quantidade em Estoque: " + inventarios.get(i).toString());
                            }
                            out.println("Quantos TubeFini deseja comprar?");
                            int qntTubes = scanner.nextInt();
                            if (inventarios.get(0).getQntEstoqueInicial() >= qntTubes) {
                                Venda venda1 = new Venda(1, 1598, "21/03/2023", produtoList.get(0).getPreco(), clienteList.get(0).getNome(), vendedorsList.get(0).getNome(), produtoList.get(0).getNome(),
                                        qntTubes, (qntTubes * produtoList.get(0).getPreco()));
                                vendaList.add(venda1);

                                out.println("--------------------------------------------------------------------------------------------------------");
                                inventarios.get(0).setQntEstoqueAtual(inventarios.get(0).getQntEstoqueInicial() - vendaList.get(0).getQuantidades());
                                out.println("Quantidade em Estoque Tube Atualizado: " + inventarios.get(0).getQntEstoqueAtual());
                                out.println("--------------------------------------------------------------------------------------------------------");


                            } else {
                                out.println("Quantidade não Disponivel");

                                out.println("Quantidade em Estoque: " + inventarios.get(0).getQntEstoqueInicial());

                                out.println("Deseja fabricar mais? , Sim[1] ou Não[2]");

                                int escolhas = scanner.nextInt();
                                int tubeCriado = 0;
                                switch (escolhas) {
                                    case 1:

                                        out.println(QUANTIDADE_DE_GOMA_ATUAL + ingrediente1.getPesoLiquidoAtual());
                                        out.println(QUANTIDADE_DE_CORANTE_ATUAL + ingrediente2.getPesoLiquidoAtual());
                                        out.println(QUANTIDADE_DE_AÇUCA_ATUAL + ingrediente3.getPesoLiquidoAtual());


                                        //        TABELA DE INGREDIENTE PARA FAZER UM TERMINADO DOÇE
                                        //        1 TUBE Fini : 0,80 DE GOMA, 0,15 DE CORANTE, 1,0 AÇUCA
                                        //        1 DENTADURA VOVO : 1,2 GOMA , 0,85 CORANTE, 0,90 AÇUCA
                                        float quantUsada1 = 0.80F;
                                        float quantUsada2 = 0.15F;
                                        float quantUsada3 = 1.0F;

                                        out.println("----------------------------------Tubo Criado--------------------------------------------");
                                        while (inventarios.get(0).getQntEstoqueInicial() + tubeCriado < qntTubes) {

                                            out.println("Tube criado :" + tubeCriado);


                                            ingrediente1.setPesoLiquidoAtual(ingrediente1.getPesoLiquidoAtual() - (quantUsada1));
                                            ingrediente2.setPesoLiquidoAtual(ingrediente2.getPesoLiquidoAtual() - (quantUsada2));
                                            ingrediente3.setPesoLiquidoAtual(ingrediente3.getPesoLiquidoAtual() - (quantUsada3));

                                            tubeCriado++;


                                        }
                                        if (((tubeCriado + inventarios.get(0).getQntEstoqueInicial() >= qntTubes))) {

                                            Venda venda1 = new Venda(1, 1598, "21/03/2023", produtoList.get(0).getPreco(), clienteList.get(0).getNome(), vendedorsList.get(0).getNome(), produtoList.get(0).getNome(),
                                                    qntTubes, (qntTubes * produtoList.get(0).getPreco()));

                                            vendaList.add(venda1);

                                        }


                                        break;
                                    default:
                                        throw new IllegalStateException("Unexpected value: " + escolhas);
                                }
                            }
                            out.println("Quantas Dentadura deseja comprar?");
                            int qntDentadura = scanner.nextInt();
                            if (inventarios.get(1).getQntEstoqueInicial() >= qntDentadura) {
                                Venda venda2 = new Venda(2, 1598, "21/03/2023", produtoList.get(1).getPreco(), clienteList.get(0).getNome(), vendedorsList.get(0).getNome(), produtoList.get(1).getNome(),
                                        qntDentadura, (qntDentadura * produtoList.get(1).getPreco()));
                                vendaList.add(venda2);
                                out.println("--------------------------------------------------------------------------------------------------------");
                                inventarios.get(1).setQntEstoqueAtual(inventarios.get(1).getQntEstoqueInicial() - vendaList.get(1).getQuantidades());
                                out.println("Quantidade em Estoque Dentadura Atualizado: " + inventarios.get(1).getQntEstoqueAtual());
                                out.println("--------------------------------------------------------------------------------------------------------");


                            } else {
                                out.println("Quantidade não Disponivel");

                                out.println("Quantidade em Estoque: " + inventarios.get(0).getQntEstoqueInicial());

                                out.println("Deseja fabricar mais? , Sim[1] ou Não[2]");

                                int option = scanner.nextInt();
                                int dentCriado = 0;
                                if (option == 1) {
                                    out.println(QUANTIDADE_DE_GOMA_ATUAL + ingrediente1.getPesoLiquidoAtual());
                                    out.println(QUANTIDADE_DE_CORANTE_ATUAL + ingrediente2.getPesoLiquidoAtual());
                                    out.println(QUANTIDADE_DE_AÇUCA_ATUAL + ingrediente3.getPesoLiquidoAtual());


                                    // TABELA DE INGREDIENTE PARA FAZER UM TERMINADO DOÇE
                                    // 1 TUBE Fini : 0,80 DE GOMA, 0,15 DE CORANTE, 1,0 AÇUCA
                                    // 1 DENTADURA VOVO : 1,2 GOMA , 0,85 CORANTE, 0,90 AÇUCA
                                    float quantUsada1 = 1.2F;
                                    float quantUsada2 = 0.85F;
                                    float quantUsada3 = 0.9F;

                                    out.println("----------------------------------Dentadura Criada--------------------------------------------");
                                    while (inventarios.get(1).getQntEstoqueInicial() + dentCriado < qntDentadura) {

                                        out.println("Dentadura criada :" + dentCriado);

                                        ingrediente1.setPesoLiquidoAtual(ingrediente1.getPesoLiquidoAtual() - (quantUsada1));
                                        ingrediente2.setPesoLiquidoAtual(ingrediente2.getPesoLiquidoAtual() - (quantUsada2));
                                        ingrediente3.setPesoLiquidoAtual(ingrediente3.getPesoLiquidoAtual() - (quantUsada3));
                                        dentCriado++;
                                    }
                                }
                                if ((((dentCriado + inventarios.get(1).getQntEstoqueInicial()) >= qntDentadura))) {

                                    Venda venda2 = new Venda(2, 1598, "21/03/2023", produtoList.get(1).getPreco(), clienteList.get(0).getNome(), vendedorsList.get(0).getNome(), produtoList.get(1).getNome(),
                                            qntDentadura, (qntDentadura * produtoList.get(1).getPreco()));

                                    vendaList.add(venda2);


                                }

                            }
                            out.println("-----------DETALHES DA COMPRA------------------");
                            out.println("Nota Fiscal: " + vendaList.get(0).getNotaFiscal());
                            out.println("Data da Compra: " + vendaList.get(0).getData());
                            out.println("Nome do Cliente: " + vendaList.get(0).getNomeCliente());
                            out.println("Nome do Vendedor: " + vendaList.get(0).getNomeVendedor());
                            out.println("Produto 1: " + vendaList.get(0).getNomeProduto() + "....................R$ " + vendaList.get(0).getValor());
                            out.println("Quantidade: " + vendaList.get(0).getQuantidades() + "..............................R$ " + vendaList.get(0).getTotal());
                            out.println("Produto 2: " + vendaList.get(1).getNomeProduto() + ".........................R$ " + vendaList.get(1).getValor());
                            out.println("Quantidade: " + vendaList.get(1).getQuantidades() + "..............................R$ " + vendaList.get(1).getTotal());
                            double subTotal = vendaList.get(0).getTotal() + vendaList.get(1).getTotal();
                            out.println("-");
                            out.println("SubTotal: .................................R$ " + subTotal);
                            out.println("----------------------------------Estoque de Material Atualizado--------------------------------------------");
                            out.println(QUANTIDADE_DE_GOMA_ATUAL + ingrediente1.getPesoLiquidoAtual());
                            out.println(QUANTIDADE_DE_CORANTE_ATUAL + ingrediente2.getPesoLiquidoAtual());
                            out.println(QUANTIDADE_DE_AÇUCA_ATUAL + ingrediente3.getPesoLiquidoAtual());
                        }
                        case 5 -> {
                            new PdfText("Nota Fiscasl de venda");
                            Relatorio relatorioSimples = new RelatorioSimples();
                            relatorioSimples.gerarCabecalho();
                            relatorioSimples.gerarCorpo();
                            relatorioSimples.imprimir();
                        }
                        default -> throw new IllegalStateException("Unexpected value: " + escolha);
                    }

                }
                while (escolha != 0);
                return;


            } else {

                out.println("Usuario ou Senha errada tente novamente!");
            }

            tentativas--;


        }
        out.println("Acesso Bloqueado procure o Administrador");


    }
}








