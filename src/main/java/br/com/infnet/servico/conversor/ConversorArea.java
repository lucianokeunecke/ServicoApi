package br.com.infnet.servico.conversor;

public class ConversorArea {

    public double HectareParaMetroQuadrado(double hectare) {
        return hectare * 10000;
    }

    public double HectareParaQuilometroQuadrado(double hectare) {
        return hectare / 100;
    }

    public double MetroQuadradoParaHectare(double metroQuadrado) {
        return metroQuadrado / 10000;
    }

    public double MetroQuadradoParaQuilometroQuadrado(double metroQuadrado) {
        return metroQuadrado / 1e+6;
    }

    public double QuilometroQuadradoParaHectare(double quilometroQuadrado) {
        return quilometroQuadrado * 100;
    }

    public double QuilometroQuadradoParaMetroQuadrado(double quilometroQuadrado) {
        return quilometroQuadrado * 1e+6;
    }

}
