package br.com.alura.desafioBuscadorViaCep.busca;

import java.util.Scanner;

public class Menu {

    public String getUserCep(){
        Scanner read = new Scanner(System.in);
        System.out.println("------------------------------\n" +
                            "Digite um CEP para busca:");

        String search = read.nextLine();

        read.close();

        return search;

    }
}
