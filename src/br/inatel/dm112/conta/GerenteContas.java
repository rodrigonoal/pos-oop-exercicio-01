package br.inatel.dm112.conta;

import java.util.HashMap;

public class GerenteContas {
    private HashMap<Integer, Atualizacao> contas = new HashMap<>();

    public void atualizarTodasContas() {
        contas.forEach((hash, conta) -> {
            try {
                conta.atualizarSaldo();
            } catch (SaldoInsuficienteException e) {
                System.out.printf("A conta %d não possui saldo para atualização.%n", hash);
            }
        });
    }

    public void adicionar(Atualizacao a) {
        this.contas.put(a.getNumero(), a);
    }

    public void removerConta(int numero) {
        this.contas.remove(numero);
    }

}
