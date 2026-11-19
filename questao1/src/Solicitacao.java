public final class Solicitacao {
    private final String nome;
    private final String provedor;
    private final int quantidadeMaquinas;
    private final int gbArmazenamento;

    public Solicitacao(String nome, String provedor, int quantidadeMaquinas, int gbArmazenamento) {
        if (nome == null || nome.isBlank() || provedor == null || provedor.isBlank() || quantidadeMaquinas < 0 || gbArmazenamento < 0) {
            throw new IllegalArgumentException("Solicitacao invalida");
        }
        this.nome = nome;
        this.provedor = provedor;
        this.quantidadeMaquinas = quantidadeMaquinas;
        this.gbArmazenamento = gbArmazenamento;
    }
    public String getNome() { return nome; }
    public String getProvedor() { return provedor; }
    public int getQuantidadeMaquinas() { return quantidadeMaquinas; }
    public int getGbArmazenamento() { return gbArmazenamento; }
}
