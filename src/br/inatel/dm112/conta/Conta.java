package br.inatel.dm112.conta;

import java.util.Objects;

public abstract class Conta implements Atualizacao {

    private final int numero;
    private final String cliente;
    private float saldo = 0f;

    public Conta(int numero, String cliente) {
        this.numero = numero;
        this.cliente = cliente;
    }

    public void sacar(float valor) throws SaldoInsuficienteException {
        if (this.saldo < valor) {
            throw new SaldoInsuficienteException("Erro: Saldo insuficiente.");
        } else {
            this.saldo -= valor;
        }
    }

    public void depositar(float valor) {
        this.saldo += valor;
    }

    public void transferirPara(Conta c, float valor) throws SaldoInsuficienteException {
        this.sacar(valor);
        c.depositar(valor);
    }

    public float getSaldo() {
        return this.saldo;
    }

    @Override
    public int getNumero() {
        return this.numero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Conta)) return false;
        Conta conta = (Conta) o;
        return numero == conta.numero && Float.compare(conta.saldo, saldo) == 0 && Objects.equals(cliente, conta.cliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero, cliente, saldo);
    }
}