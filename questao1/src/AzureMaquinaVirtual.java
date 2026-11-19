public final class AzureMaquinaVirtual implements MaquinaVirtual {
    private final String identificador;
    public AzureMaquinaVirtual(int sequencia) {
        this.identificador = "vm-" + sequencia;
    }
    @Override public String getIdentificador() { return identificador; }
    @Override public double getCustoPorHora() { return 0.12; }
}
