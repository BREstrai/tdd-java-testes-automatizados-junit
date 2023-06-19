package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {

    @Test
    void bonusDeveriaSerZeroParaFuncionarioComSalarioAlto() {
        BonusService bonusService = new BonusService();
        assertThrows(IllegalArgumentException.class,
                () -> bonusService.calcularBonus(
                        new Funcionario("Bruno", LocalDate.now(), new BigDecimal(("25000")))));
    }

    @Test
    void bonusDeveriaSer10PorcentoDoSalario() {
        BonusService bonusService = new BonusService();
        BigDecimal bonus = bonusService.calcularBonus(
                new Funcionario("Bruno", LocalDate.now(), new BigDecimal(("250"))));

        assertEquals(new BigDecimal("25.00"), bonus);
    }

    @Test
    void bonusDe10PorcentoParaSalarioDeExaamente10000() {
        BonusService bonusService = new BonusService();
        BigDecimal bonus = bonusService.calcularBonus(
                new Funcionario("Bruno", LocalDate.now(), new BigDecimal(("10000"))));

        assertEquals(new BigDecimal("1000.00"), bonus);
    }
}