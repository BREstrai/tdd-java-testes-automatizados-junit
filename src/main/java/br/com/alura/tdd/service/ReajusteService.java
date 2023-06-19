package br.com.alura.tdd.service;

import java.math.BigDecimal;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

/**
 * Created by Bruno Rudinei Estrai on 19-06-2023
 */
public class ReajusteService {

    public void concederReajuste(Funcionario funcionario, Desempenho desempenho) {

        BigDecimal percentual = desempenho.percentualReajuste();
        BigDecimal reajuste = funcionario.getSalario().multiply(percentual);
        funcionario.reajusteSalario(reajuste);

    }
}

