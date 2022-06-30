package com.gugawag.testes.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContaTeste {

    Conta c1;
    Conta c2;

    @BeforeEach
    private void configuraConta() {
        c1 = new Conta();
        c1.setNumero("10");
        c2 = new Conta();
        c2.setNumero("20");

    }


    @Test
    public void deveAlterarNumeroContaNumeroValido() {
        // Config
        String numeroContaValido = "10";

        // executa
        c1.setNumero(numeroContaValido);

        // teste
        Assertions.assertEquals(numeroContaValido, c1.getNumero());
    }


    @Test
    public void deveComecarContaComSaldoZero() {
        // config
        Conta contaNova = new Conta();

        // teste
        Assertions.assertEquals(0.0, contaNova.getSaldo());
    }



    @Test
    public void naoDeveDebitarValorMaiorSaldo() {
        // config
        c1.creditar(100.0);

        // executar

        Assertions.assertThrows(SaldoNegativoInvalidoException.class,
                () -> c1.debitar(200.0));
    }

    @Test
    public void deveDebitarValorIgualSaldo() {
        // config
        c1.creditar(100.0);

        // executar
        try {
            c1.debitar(100.0);
        } catch (SaldoNegativoInvalidoException e) {
            Assertions.fail();
        }

        // teste
        Assertions.assertEquals(0.0, c1.getSaldo());
    }

    @Test
    public void naoDeveCreditarValorNegativo() {

        // executar
        c1.creditar(-100.0);

        // teste
        Assertions.assertEquals(0.0, c1.getSaldo());
    }

    @Test
    public void naoDeveTransferirValorMaiorQue100()  {
        try{
            c1.creditar(400);
            c1.transferir(500,"20");
            

        }catch (SaldoSuperiorInvalidoException |SaldoNegativoInvalidoException e){
            Assertions.fail();
        }


    }

}
