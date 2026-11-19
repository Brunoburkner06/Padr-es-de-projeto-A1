import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class RegistroAuditoria {
    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss.SSS");
    private final LocalDateTime dataHora;
    private final String ambiente;
    private final String provedor;
    private final String resultado;
    private final String motivo;

    public RegistroAuditoria(String ambiente, String provedor, String resultado, String motivo) {
        this.dataHora = LocalDateTime.now();
        this.ambiente = ambiente;
        this.provedor = provedor;
        this.resultado = resultado;
        this.motivo = motivo;
    }
    @Override public String toString() {
        return dataHora.format(FORMATO) + " | " + ambiente + " | " + provedor
                + " | " + resultado + (motivo.isEmpty() ? "" : " | " + motivo);
    }
}
