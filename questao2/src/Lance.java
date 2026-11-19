import java.time.LocalDateTime;

public final class Lance {
    private final Participante participante;
    private final double valor;
    private final LocalDateTime dataHora;
    public Lance(Participante participante, double valor) {
        this.participante = participante;
        this.valor = valor;
        this.dataHora = LocalDateTime.now();
    }
    public Participante getParticipante() { return participante; }
    public double getValor() { return valor; }
    public LocalDateTime getDataHora() { return dataHora; }
}
