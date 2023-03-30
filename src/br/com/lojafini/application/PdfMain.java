package br.com.lojafini.application;

import br.com.lojafini.data.model.Cliente;
import br.com.lojafini.util.PdfText;
import br.com.lojafini.util.Relatorio;
import br.com.lojafini.util.RelatorioSimples;
import com.lowagie.text.DocumentException;

import java.util.Scanner;

public class PdfMain {
    public static void main(String[] args) throws DocumentException {
        Scanner scanner = new Scanner(System.in);

       new PdfText("Nota Fiscasl de venda");
        Relatorio relatorioSimples = new RelatorioSimples();
        relatorioSimples.gerarCabecalho();
        relatorioSimples.gerarCorpo();
        relatorioSimples.imprimir();
    }

}