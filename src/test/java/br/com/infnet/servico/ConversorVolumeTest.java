package br.com.infnet.servico;

import br.com.infnet.servico.conversor.ConversorVolume;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class ConversorVolumeTest {

    @InjectMocks
    private ConversorVolume conversorVolume;

    @Test
    @DisplayName("Converter Litros para Mililitros")
    void converterLitroParaMililitro() {
        double litro = 5;
        double resultado = conversorVolume.LitroParaMililitro(litro);
        assertEquals(5000, resultado);
    }

    @Test
    @DisplayName("Converter Litros para Metros Cúbicos")
    void converterLitroParaMetroCubico() {
        double litro = 15;
        double resultado = conversorVolume.LitroParaMetroCubico(litro);
        assertEquals(0.015, resultado);
    }

    @Test
    @DisplayName("Converter Mililitros para Litros")
    void converterMililitroParaLitro() {
        double mililitro = 1530;
        double resultado = conversorVolume.MililitroParaLitro(mililitro);
        assertEquals(1.53, resultado);
    }

    @Test
    @DisplayName("Converter Mililitros para Metros Cúbicos")
    void converterMililitroParaMetroCubico() {
        double mililitro = 500;
        double resultado = conversorVolume.MililitroParaMetroCubico(mililitro);
        assertEquals(0.0005, resultado);
    }

    @Test
    @DisplayName("Converter Metros Cúbicos para Mililitros")
    void converterMetroCubicoParaMililitros() {
        double metroCubico = 150;
        double resultado = conversorVolume.MetroCubicoParaMililitros(metroCubico);
        assertEquals(1.5e+8, resultado);
    }

    @Test
    @DisplayName("Converter Metros Cúbicos para Litros")
    void converterMetroCubicoParaLitros() {
        double metroCubico = 230;
        double resultado = conversorVolume.MetroCubicoParaLitros(metroCubico);
        assertEquals(230000, resultado);
    }

    @Test
    @DisplayName("O resultado da conversão de Litros para Mililitros deve ser diferente")
    void converterLitroParaMililitroResultadoDiferente() {
        double litro = 8;
        double resultado = conversorVolume.LitroParaMililitro(litro);
        assertNotEquals(8001, resultado);
    }

    @Test
    @DisplayName("O resultado da conversão de Mililitros para Metros Cúbicos deve ser diferente")
    void converterMililitroParaMetroCubicoResultadoDiferente() {
        double mililitro = 70000;
        double resultado = conversorVolume.MililitroParaMetroCubico(mililitro);
        assertNotEquals(0.08, resultado);
    }

    @Test
    @DisplayName("O resultado da conversão de Metros Cúbicos para Litros deve ser diferente")
    void converterMetroCubicoParaLitrosResultadoDiferente() {
        double metroCubico = 231;
        double resultado = conversorVolume.MetroCubicoParaLitros(metroCubico);
        assertNotEquals(230000, resultado);
    }

}
