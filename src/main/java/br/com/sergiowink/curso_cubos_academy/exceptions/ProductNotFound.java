package br.com.sergiowink.curso_cubos_academy.exceptions;

public class ProductNotFound extends RuntimeException{
    public ProductNotFound() {
        super("Produto não encontrado");
    }
}
