package br.com.alura.desafioBuscadorViaCep.busca;

import br.com.alura.desafioBuscadorViaCep.exception.InvalidCepException;
import br.com.alura.desafioBuscadorViaCep.exception.InvalidCepFormatException;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CepSearch {

    String viaCepUrl = "http://viacep.com.br/ws/";
    String viaCepUrlComplement = "/json/";

    public Address getCep(String cepNumber){

        String cep = cepNumber.replace("-", "")
                .replace(".","")
                .replace(" ","");

        if (!isValid(cep)){
            throw new InvalidCepFormatException();
        }

        URI url = URI.create(viaCepUrl + cep + viaCepUrlComplement);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            Address address = new Gson().fromJson(response.body(), Address.class);

            if (address.cep() == null){
                throw new InvalidCepException();
            }

            return address;

        } catch (Exception e) {
            throw new RuntimeException("Não foi possível fazer a busca.");
        }
    }

    public static boolean isValid (String cep){
        if (cep.length() != 8){
            return false;
        }
        try {
            Integer.parseInt(cep);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }
}
