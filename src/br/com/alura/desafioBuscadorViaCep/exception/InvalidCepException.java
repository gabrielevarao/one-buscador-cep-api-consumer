package br.com.alura.desafioBuscadorViaCep.exception;

public class InvalidCepException extends RuntimeException {
    private String message = "CEP não encontrado.";

    public String getMessage() {
        return message;
    }
}
