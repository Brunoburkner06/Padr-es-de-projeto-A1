public final class AzureFila implements FilaMensagens {
    private final String identificador;
    public AzureFila(int sequencia) {
        this.identificador = "sb-" + sequencia;
    }
    @Override public String getIdentificador() { return identificador; }
    @Override public double getCustoMensal() { return 0.5; }
}
