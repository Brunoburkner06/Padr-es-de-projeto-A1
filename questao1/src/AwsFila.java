public final class AwsFila implements FilaMensagens {
    private final String identificador;
    public AwsFila(int sequencia) {
        this.identificador = "sqs-" + sequencia;
    }
    @Override public String getIdentificador() { return identificador; }
    @Override public double getCustoMensal() { return 0.4; }
}
