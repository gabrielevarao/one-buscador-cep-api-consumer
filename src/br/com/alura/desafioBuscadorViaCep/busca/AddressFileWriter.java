package br.com.alura.desafioBuscadorViaCep.busca;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class AddressFileWriter {

    public void writeAddressJsonFile(Address address) throws IOException {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            FileWriter writer = new FileWriter(address.cep() + ".txt");
            writer.write(gson.toJson(address));
            writer.close();

            System.out.println("Arquivo JSON com os dados do CEP " + address.cep() + " criado com sucesso!");
    }
}
