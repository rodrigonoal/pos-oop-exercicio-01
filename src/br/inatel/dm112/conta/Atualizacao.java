package br.inatel.dm112.conta;

public interface Atualizacao {
    void atualizarSaldo() throws SaldoInsuficienteException;

    int getNumero();

}
