package com.gugawag.testes.modelo;

public class Conta {

    public Conta() {
        this.saldo = 0.0;
    }

    private String numero;
//    private Cliente cliente;
    private Double saldo;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void creditar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
        }
    }

    public void debitar(double valor) throws SaldoNegativoInvalidoException {

        if (valor > this.saldo) {
            throw new SaldoNegativoInvalidoException();
        }

        if (valor > 0) {
            this.saldo -= valor;
        }
    }

    public void transferir(double valor, String contaDestino) throws SaldoNegativoInvalidoException, SaldoSuperiorInvalidoException {
        if(valor > this.getSaldo()){
            throw  new SaldoSuperiorInvalidoException();
        }
        if(this.getSaldo() <= 0){
            throw  new SaldoNegativoInvalidoException();
        }
        this.debitar(valor);

    }

}
