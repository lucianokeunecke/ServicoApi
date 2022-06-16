package br.com.infnet.servico.conversor;

public class ConversorVolume {

    public double LitroParaMililitro(double litro) {
        return litro * 1000;
    }

    public double LitroParaMetroCubico(double litro) {
        return litro / 1000;
    }

    public double MililitroParaLitro(double mililitro) {
        return mililitro / 1000;
    }

    public double MililitroParaMetroCubico(double mililitro) {
        return mililitro / 1e+6;
    }

    public double MetroCubicoParaMililitros(double metroCubico) {
        return metroCubico * 1e+6;
    }

    public double MetroCubicoParaLitros(double metroCubico) {
        return metroCubico * 1000;
    }

}
