public final class Participante implements ObservadorLance {
    private final String nome;
    public Participante(String nome) { this.nome = nome; }
    public String getNome() { return nome; }
    @Override public void atualizar(Lote lote, Lance lance) {
        if (lance.getParticipante() != this) {
            System.out.printf("[Aviso para %s] %s: novo lance de R$ %.2f%n", nome,
                    lote.getNome(), lance.getValor());
        }
    }
}
