package br.com.lojafini.util;

import com.lowagie.text.DocumentException;

public interface Relatorio {
    public void gerarCabecalho() throws DocumentException;

    public void gerarCorpo() throws DocumentException;
    public void gerarRodape();
    public void imprimir();
}
