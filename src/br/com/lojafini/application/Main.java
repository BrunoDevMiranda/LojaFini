package br.com.lojafini.application;

import br.com.lojafini.services.EntrarSistema;
import br.com.lojafini.services.Menu;
import com.lowagie.text.DocumentException;

import java.util.Scanner;

import static java.lang.System.*;

public class Main {
    public static void main(String[] args) throws DocumentException {
        Scanner scanner = new Scanner(in);
        EntrarSistema user = new EntrarSistema();
        Menu menu = new Menu();
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
                menu.menu();
                return;
            } else {
                out.println("Usuario ou Senha errada tente novamente!");
            }
            tentativas--;
        }
        out.println("Acesso Bloqueado procure o Administrador");
    }
}








