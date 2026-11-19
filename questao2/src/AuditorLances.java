import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

// Concrete Observer (auditor).
public final class AuditorLances implements ObservadorLance {
    private final List<String> registros = new ArrayList<>();
    @Override public void atualizar(Lote lote, Lance lance) {
        String registro = lance.getDataHora().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))
                + " | " + lote.getNome() + " | " + lance.getParticipante().getNome()
                + String.format(" | R$ %.2f", lance.getValor());
        registros.add(registro);
        System.out.println("[Auditor] " + registro);
    }
    public void imprimirRegistros() {
        System.out.println("\n=== REGISTROS DO AUDITOR ===");
        for (String registro : registros) System.out.println(registro);
    }
}
