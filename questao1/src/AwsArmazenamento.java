public final class AwsArmazenamento implements Armazenamento {
    private final String identificador;
    public AwsArmazenamento(int sequencia) {
        this.identificador = "s3://" + sequencia;
    }
    @Override public String getIdentificador() { return identificador; }
    @Override public double getCustoPorGbMes() { return 0.023; }
}
