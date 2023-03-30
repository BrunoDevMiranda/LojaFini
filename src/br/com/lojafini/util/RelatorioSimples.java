package br.com.lojafini.util;


import br.com.lojafini.data.model.Cliente;
import br.com.lojafini.data.model.Produto;
import br.com.lojafini.data.model.Vendedor;
import br.com.lojafini.services.Venda;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class RelatorioSimples implements Relatorio {

    private String arquivoPDF = "document/Relatorio.pdf";
    private Document documentoPDF;


    public RelatorioSimples() {
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

    @Override
    public void gerarCabecalho() throws DocumentException {
        //Cliente
        ArrayList<Cliente> clienteList = new ArrayList<>();
        clienteList.add(new Cliente(1, "Bruno", "123.359.963-55", "Bonsucesso", "26/07/1987"));
        clienteList.add(new Cliente(2, "João", "123.359.963-55", "Bonsucesso", "11/05/2011"));

        //Vendedor

        ArrayList<Vendedor> vendedorsList = new ArrayList<>();
        vendedorsList.add(new Vendedor(1, "Gustavo", "888.666.777-11", "Jd Primavera", "05/02/2018"));

        //Produto

        ArrayList<Produto> produtoList = new ArrayList<>();
        produtoList.add(new Produto(1, "Dentadura Vovó", 4.60));
        produtoList.add(new Produto(2, "Tubes Fini", 8.15));

        //Venda

        ArrayList<Venda> vendaList = new ArrayList<>();
        Venda venda1 = new Venda(1, 1598, "21/03/2023", produtoList.get(0).getPreco(), clienteList.get(0).getNome(), vendedorsList.get(0).getNome(), produtoList.get(0).getNome(),
                20, (20 * produtoList.get(0).getPreco()));
        vendaList.add(venda1);

        Venda venda2 = new Venda(2, 1598, "21/03/2023", produtoList.get(1).getPreco(), clienteList.get(0).getNome(), vendedorsList.get(0).getNome(), produtoList.get(1).getNome(),
                17, (17 * produtoList.get(1).getPreco()));
        vendaList.add(venda2);



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




        double subtotal = venda2.getTotal() + venda1.getTotal();


        Paragraph paragraphCorpo = new Paragraph();
        Paragraph paragraphCorpoitens1 = new Paragraph();
        Paragraph paragraphCorpoitens11 = new Paragraph();
        Paragraph paragraphCorpoitens2 = new Paragraph();
        Paragraph paragraphCorpoitens22 = new Paragraph();
        Paragraph paragraphCorpoitensTotal = new Paragraph();
        paragraphCorpo.setAlignment(Element.ALIGN_CENTER);
        paragraphCorpo.add("Produto");
        paragraphCorpoitens1.add("Item 1: " + produtoList.get(0).getNome() + ": - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -: R$ " + venda1.getValor());
        paragraphCorpoitens11.add("Quantidade " + venda1.getQuantidades() + ": - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - : R$ " + venda1.getTotal());
        paragraphCorpoitens2.add("Item 2: " + produtoList.get(1).getNome() + ": - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - : R$ " + venda2.getValor());
        paragraphCorpoitens22.add("Quantidade " + venda2.getQuantidades() + ": - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - : R$ " + venda2.getTotal());
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


        paragraphCorpoitensTotal.add("Sub total: - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - : R$ " + subtotal);
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

    @Override
    public void gerarCorpo() throws DocumentException {


    }

    @Override
    public void gerarRodape() {

        Paragraph paragraph = new Paragraph();


    }

    @Override
    public void imprimir() {

        if (this.documentoPDF != null && this.documentoPDF.isOpen()) {
            this.documentoPDF.close();

        }
    }
}
