public final class AzureArmazenamento implements Armazenamento {
    private final String identificador;
    public AzureArmazenamento(int sequencia) {
        this.identificador = "blob://" + sequencia;
    }
    @Override public String getIdentificador() { return identificador; }
    @Override public double getCustoPorGbMes() { return 0.02; }
}
