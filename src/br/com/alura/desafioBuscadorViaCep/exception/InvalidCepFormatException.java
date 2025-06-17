package br.com.alura.desafioBuscadorViaCep.exception;

public class InvalidCepFormatException extends RuntimeException {
    private String message = "Formato inválido.";

    @Override
    public String getMessage() {
        return message;
    }
}
