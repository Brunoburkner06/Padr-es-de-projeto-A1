public final class AwsMaquinaVirtual implements MaquinaVirtual {
    private final String identificador;
    public AwsMaquinaVirtual(int sequencia) {
        this.identificador = "i-" + sequencia;
    }
    @Override public String getIdentificador() { return identificador; }
    @Override public double getCustoPorHora() { return 0.1; }
}
