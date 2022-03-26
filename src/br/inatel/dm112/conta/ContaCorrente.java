package br.inatel.dm112.conta;

public class ContaCorrente extends Conta {

    private final float manutencaoMensal;

    public ContaCorrente(int numero, String cliente, float manutencaoMensal) {
        super(numero, cliente);
        this.manutencaoMensal = manutencaoMensal;
    }

    @Override
    public void atualizarSaldo() throws SaldoInsuficienteException {
        super.sacar(manutencaoMensal);
    }
}
