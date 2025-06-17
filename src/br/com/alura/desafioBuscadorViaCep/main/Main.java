package br.com.alura.desafioBuscadorViaCep.main;

import java.io.IOException;

import br.com.alura.desafioBuscadorViaCep.busca.AddressFileWriter;
import br.com.alura.desafioBuscadorViaCep.busca.CepSearch;
import br.com.alura.desafioBuscadorViaCep.busca.Menu;
import br.com.alura.desafioBuscadorViaCep.exception.InvalidCepException;
import br.com.alura.desafioBuscadorViaCep.exception.InvalidCepFormatException;

public class Main {
    public static void main(String[] args) throws IOException {

        AddressFileWriter address = new AddressFileWriter();
        CepSearch cep = new CepSearch();
        Menu menu = new Menu();

        try {
            address.writeAddressJsonFile(cep.getCep(menu.getUserCep()));
        } catch (InvalidCepFormatException e){
            System.out.println(e.getMessage());
        } catch (InvalidCepException e){
            System.out.println(e.getMessage());
        }
    }
}
