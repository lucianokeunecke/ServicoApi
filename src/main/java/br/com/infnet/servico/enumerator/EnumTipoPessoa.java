package br.com.infnet.servico.enumerator;

public enum EnumTipoPessoa {
    PESSOA_FISICA((byte) 1),
    PESSOA_JURIFICA((byte) 2);

    private final byte valor;

    EnumTipoPessoa(byte valorOpcao) {
        valor = valorOpcao;
    }

    public byte getValor() {
        return valor;
    }
}
