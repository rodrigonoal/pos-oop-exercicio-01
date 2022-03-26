package br.inatel.dm112.conta;

public class ContaPoupanca extends Conta {

    private final float taxaDeJuros;

    public ContaPoupanca(int numero, String cliente, float taxaDeJuros) {
        super(numero, cliente);
        this.taxaDeJuros = taxaDeJuros;
    }

    @Override
    public void atualizarSaldo() throws SaldoInsuficienteException {
        super.depositar(this.getSaldo() * taxaDeJuros);
    }
}
