package br.com.infnet.servico;

import br.com.infnet.servico.conversor.ConversorArea;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class ConversorAreaTest {

    @InjectMocks
    private ConversorArea conversorArea;

    @Test
    @DisplayName("Converter Hectare para Metro Quadrado")
    void converterHectareParaMetroQuadrado() {
        double hectare = 7;
        double resultado = conversorArea.HectareParaMetroQuadrado(hectare);
        assertEquals(70000, resultado);
    }

    @Test
    @DisplayName("Converter Hectare para Quilômetro Quadrado")
    void converterHectareParaQuilometroQuadrado() {
        double hectare = 135;
        double resultado = conversorArea.HectareParaQuilometroQuadrado(hectare);
        assertEquals(1.35, resultado);
    }

    @Test
    @DisplayName("Converter Metro Quadrado para Hectare")
    void converterMetroQuadradoParaHectare() {
        double metroQuadrado = 35000;
        double resultado = conversorArea.MetroQuadradoParaHectare(metroQuadrado);
        assertEquals(3.5, resultado);
    }

    @Test
    @DisplayName("Converter Metro Quadrado para Quilômetro Quadrado")
    void converterMetroQuadradoParaQuilometroQuadrado() {
        double metroQuadrado = 45000;
        double resultado = conversorArea.MetroQuadradoParaQuilometroQuadrado(metroQuadrado);
        assertEquals(0.045, resultado);
    }

    @Test
    @DisplayName("Converter Quilômetro Quadrado para Hectare")
    void converterQuilometroQuadradoParaHectare() {
        double quilometroQuadrado = 33;
        double resultado = conversorArea.QuilometroQuadradoParaHectare(quilometroQuadrado);
        assertEquals(3300, resultado);
    }

    @Test
    @DisplayName("Converter Quilômetro Quadrado para Metro Quadrado")
    void converterQuilometroQuadradoParaMetroQuadrado() {
        double quilometroQuadrado = 11;
        double resultado = conversorArea.QuilometroQuadradoParaMetroQuadrado(quilometroQuadrado);
        assertEquals(1,1e+7, resultado);
    }

    @Test
    @DisplayName("O resultado da conversão de Hectare para Metro Quadrado deve ser diferente")
    void converterHectareParaMetroQuadradoResultadoDiferente() {
        double hectare = 24;
        double resultado = conversorArea.HectareParaMetroQuadrado(hectare);
        assertNotEquals(240001, resultado);
    }

    @Test
    @DisplayName("O resultado da conversão de Metro Quadrado para Quilômetro Quadrado deve ser diferente")
    void converterMetroQuadradoParaQuilometroQuadradoResultadoDiferente() {
        double metroQuadrado = 51365;
        double resultado = conversorArea.MetroQuadradoParaQuilometroQuadrado(metroQuadrado);
        assertNotEquals(0.051364, resultado);
    }

    @Test
    @DisplayName("O resultado da conversão de Quilômetro Quadrado para Hectare deve ser diferente")
    void converterQuilometroQuadradoParaHectareResultadoDiferente() {
        double quilometroQuadrado = 61;
        double resultado = conversorArea.QuilometroQuadradoParaHectare(quilometroQuadrado);
        assertNotEquals(6101, resultado);
    }

}
