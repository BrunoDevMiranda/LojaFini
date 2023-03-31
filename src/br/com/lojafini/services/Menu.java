package br.com.lojafini.services;

import br.com.lojafini.data.model.*;
import br.com.lojafini.util.PdfText;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class Menu {
    private String arquivoPDF = "document/Relatorio.pdf";
    private Document documentoPDF;
    public static final String QUANTIDADE_DE_GOMA_ATUAL = "Quantidade de Goma Atual:";
    public static final String QUANTIDADE_DE_CORANTE_ATUAL = "Quantidade de Corante Atual:";
    public static final String QUANTIDADE_DE_AÇUCA_ATUAL = "Quantidade de Açuca Atual:";

    Ingrediente ingrediente1 = new Ingrediente("Goma", 100);
    Ingrediente ingrediente2 = new Ingrediente("Corante azul", 80);
    Ingrediente ingrediente3 = new Ingrediente("Açuca Crystal", 50);
    ArrayList<Inventario> inventarios = new ArrayList<>();
    ArrayList<Cliente> clienteList = new ArrayList<>();
    ArrayList<Vendedor> vendedorsList = new ArrayList<>();
    ArrayList<Produto> produtoList = new ArrayList<>();
    ArrayList<Venda> vendaList = new ArrayList<>();
    public Menu() {
        this.documentoPDF = new Document();
        try {
            PdfWriter.getInstance(this.documentoPDF, new FileOutputStream(arquivoPDF));
            this.documentoPDF.open();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
    }

    public void menu() throws DocumentException {
        Scanner scanner = new Scanner(in);
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
                    clienteList.add(new Cliente(1, "Bruno", "123.359.963-55", "Bonsucesso", "26/07/1987"));
                    clienteList.add(new Cliente(2, "João", "123.359.963-55", "Bonsucesso", "11/05/2011"));
                    out.println("------|-CLIENTE-|-------");
                    for (int i = 0; i < clienteList.size(); i++) {
                        out.println(clienteList.get(i).toString());
                    }

                }
                case 2 -> {
                    out.println("-------------------------------------VENDEDOR---------------------------------------------------------------");
                    vendedorsList.add(new Vendedor(1, "Gustavo", "888.666.777-11", "Jd Primavera", "05/02/2018"));
                    for (int i = 0; i < vendedorsList.size(); i++) {
                        out.println(vendedorsList.get(i).toString());
                    }
                }
                case 3 -> {
                    out.println("--------------------------------------------PRODUTO---------------------------------------------------------");
                    produtoList.add(new Produto(1, "Dentadura Vovó", 4.60));
                    produtoList.add(new Produto(2, "Tubes Fini", 8.15));

                    for (int i = 0; i < produtoList.size(); i++) {
                        out.println(produtoList.get(i).toString());
                    }
                }
                case 4 -> {
                    inventarios.add(new Inventario(1, "TubeFini", 30));
                    inventarios.add(new Inventario(2, "Dentadura vovó", 30));

                    produtoList.add(new Produto(1, "Dentadura Vovó", 4.60));
                    produtoList.add(new Produto(2, "Tubes Fini", 8.15));

                    vendedorsList.add(new Vendedor(1, "Gustavo", "888.666.777-11", "Jd Primavera", "05/02/2018"));

                    clienteList.add(new Cliente(1, "Bruno", "123.359.963-55", "Bonsucesso", "26/07/1987"));
                    clienteList.add(new Cliente(2, "João", "123.359.963-55", "Bonsucesso", "11/05/2011"));


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
                                if ((tubeCriado + inventarios.get(0).getQntEstoqueInicial() >= qntTubes)) {

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

                    double ard1 = Math.round(vendaList.get(0).getTotal() * 100) / 100;
                    double ard2 = Math.round(vendaList.get(1).getTotal() * 100) / 100;

                    out.println("-----------DETALHES DA COMPRA------------------");
                    out.println("Nota Fiscal: " + vendaList.get(0).getNotaFiscal());
                    out.println("Data da Compra: " + vendaList.get(0).getData());
                    out.println("Nome do Cliente: " + vendaList.get(0).getNomeCliente());
                    out.println("Nome do Vendedor: " + vendaList.get(0).getNomeVendedor());
                    out.println("Produto 1: " + vendaList.get(0).getNomeProduto() + "....................R$ " + vendaList.get(0).getValor());
                    out.println("Quantidade: " + vendaList.get(0).getQuantidades() + "..............................R$ " + ard1);
                    out.println("Produto 2: " + vendaList.get(1).getNomeProduto() + ".........................R$ " + vendaList.get(1).getValor());
                    out.println("Quantidade: " + vendaList.get(1).getQuantidades() + "..............................R$ " + ard2);
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
                    gerarPdf();
                    imprimir();
                }
            }
        } while (escolha != 0);
    }

    public void gerarPdf() throws DocumentException {
        Paragraph paragraphTitle = new Paragraph();
        Paragraph paragraphTitle2 = new Paragraph();
        paragraphTitle.setAlignment(Element.ALIGN_CENTER);
        paragraphTitle2.setAlignment(Element.ALIGN_CENTER);
        paragraphTitle.add(new Chunk("LOJA FINISSIMO", new Font(Font.HELVETICA, 32)));
        paragraphTitle2.add(new Chunk("CNPJ : 12.345.678/0001-00", new Font(Font.HELVETICA, 18)));

        this.documentoPDF.add(paragraphTitle);
        this.documentoPDF.add(new Paragraph(" "));
        this.documentoPDF.add(paragraphTitle2);
        this.documentoPDF.add(new Paragraph());

        Paragraph paragraphData = new Paragraph();
        Paragraph paragraphNumeroVenda = new Paragraph();
        paragraphData.setAlignment((Element.ALIGN_CENTER));
        paragraphNumeroVenda.setAlignment((Element.ALIGN_CENTER));
        paragraphData.add(new Chunk("Data da Venda: " + vendaList.get(0).getData(), new Font(Font.HELVETICA, 14)));
        paragraphNumeroVenda.add(new Chunk("Numero Nota Fiscal: " + vendaList.get(0).getNotaFiscal(), new Font(Font.HELVETICA, 14)));
        this.documentoPDF.add(paragraphData);
        this.documentoPDF.add(paragraphNumeroVenda);

        this.documentoPDF.add(new Paragraph(" "));
        this.documentoPDF.add(new Paragraph(" "));

        Paragraph paragraphClient1 = new Paragraph();
        Paragraph paragraphClient2 = new Paragraph();
        paragraphClient1.setAlignment((Element.ALIGN_CENTER));
        paragraphClient2.setAlignment((Element.ALIGN_CENTER));
        paragraphClient1.add(new Chunk("Cliente: " + vendaList.get(0).getNomeCliente(), new Font(Font.BOLD, 16)));
        paragraphClient2.add(new Chunk("CPF " + clienteList.get(0).getCpf() + ", Endereço " +
                clienteList.get(0).getEndereco() + "Data de Nascimento: " + clienteList.get(0).getNascimento()));
        this.documentoPDF.add(paragraphClient1);
        this.documentoPDF.add(paragraphClient2);

        Paragraph paragraphVendedor1 = new Paragraph();
        Paragraph paragraphVendedor2 = new Paragraph();
        paragraphVendedor1.setAlignment(Element.ALIGN_CENTER);
        paragraphVendedor2.setAlignment(Element.ALIGN_CENTER);
        paragraphVendedor1.add(new Chunk("Vendedor: " + vendedorsList.get(0).getNome(), new Font(Font.BOLD, 16)));
        paragraphVendedor2.add(new Chunk("CPF: " + vendedorsList.get(0).getCpf()));
        Paragraph paragraphSessao = new Paragraph("________________________________________________________________________");
        paragraphSessao.setAlignment((Element.ALIGN_CENTER));
        this.documentoPDF.add(paragraphSessao);
        this.documentoPDF.add(new Paragraph(" "));

        this.documentoPDF.add(paragraphVendedor1);
        this.documentoPDF.add(paragraphVendedor2);
        this.documentoPDF.add(paragraphSessao);
        this.documentoPDF.add(new Paragraph(" "));

        double ard1 = Math.round(vendaList.get(0).getTotal() * 100) / 100;
        double ard2 = Math.round(vendaList.get(1).getTotal() * 100) / 100;
        double subtotal = ard1 + ard2;

        Paragraph paragraphCorpo = new Paragraph();
        Paragraph paragraphCorpoitens1 = new Paragraph();
        Paragraph paragraphCorpoitens11 = new Paragraph();
        Paragraph paragraphCorpoitens2 = new Paragraph();
        Paragraph paragraphCorpoitens22 = new Paragraph();
        Paragraph paragraphCorpoitensTotal = new Paragraph();
        paragraphCorpo.setAlignment(Element.ALIGN_CENTER);
        paragraphCorpo.add("Produto");
        paragraphCorpoitens1.add("Item 1: " + produtoList.get(0).getNome() + ":....................................................................................: R$ " + vendaList.get(0).getValor());
        this.documentoPDF.add(new Paragraph(" "));
        paragraphCorpoitens11.add("Quantidade " + vendaList.get(0).getQuantidades() + "..................................................................................................... :R$" + ard1);
        paragraphCorpoitens2.add("Item 2: " + produtoList.get(1).getNome() + "................................................................................................" + vendaList.get(1).getValor());
        this.documentoPDF.add(new Paragraph(" "));
        paragraphCorpoitens22.add("Quantidade " + vendaList.get(1).getQuantidades() + ".................................................................................................... R$ " + ard2);
        this.documentoPDF.add(paragraphCorpo);
        this.documentoPDF.add(paragraphCorpoitens1);
        this.documentoPDF.add(new Paragraph(" "));
        this.documentoPDF.add(paragraphCorpoitens11);
        this.documentoPDF.add(new Paragraph(" "));
        this.documentoPDF.add(paragraphCorpoitens2);
        this.documentoPDF.add(new Paragraph(" "));
        this.documentoPDF.add(paragraphCorpoitens22);
        this.documentoPDF.add(new Paragraph(" "));
        this.documentoPDF.add(new Paragraph(" "));
        this.documentoPDF.add(new Paragraph(" "));

        paragraphCorpoitensTotal.add("Sub total:  ..................................................................................: R$ " + subtotal);
        this.documentoPDF.add(paragraphCorpoitensTotal);
        Paragraph paragraphSessao4 = new Paragraph("________________________________________________________________________");

        this.documentoPDF.add(new Paragraph(" "));
        this.documentoPDF.add(new Paragraph(" "));
        this.documentoPDF.add(new Paragraph(" "));
        this.documentoPDF.add(new Paragraph(" "));
        this.documentoPDF.add(new Paragraph(" "));
        this.documentoPDF.add(new Paragraph(" "));
        this.documentoPDF.add(new Paragraph(" "));
        this.documentoPDF.add(new Paragraph(" "));
        this.documentoPDF.add(new Paragraph(" "));
        this.documentoPDF.add(new Paragraph(" "));
        this.documentoPDF.add(new Paragraph(" "));
        this.documentoPDF.add(new Paragraph(" "));
        this.documentoPDF.add(new Paragraph(" "));
        this.documentoPDF.add(new Paragraph(" "));

        Paragraph paragraphSessao5 = new Paragraph("________________________________");
        paragraphSessao5.setAlignment((Element.ALIGN_CENTER));
        this.documentoPDF.add(paragraphSessao4);

        Paragraph paragraphSign = new Paragraph();
        paragraphSign.setAlignment((Element.ALIGN_CENTER));
        paragraphSign.add(new Chunk("Assinatura"));
        this.documentoPDF.add(paragraphSign);
    }

    public void imprimir() {
        if (this.documentoPDF != null && this.documentoPDF.isOpen()) {
            this.documentoPDF.close();

        }
    }
}

