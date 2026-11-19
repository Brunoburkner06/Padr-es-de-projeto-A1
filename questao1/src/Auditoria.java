import java.util.ArrayList;
import java.util.List;

public final class Auditoria {
    private static final Auditoria INSTANCIA = new Auditoria();
    private final List<RegistroAuditoria> registros = new ArrayList<>();
    private Auditoria() { }
    public static Auditoria getInstancia() { return INSTANCIA; }
    public synchronized void registrar(String ambiente, String provedor, String resultado, String motivo) {
        registros.add(new RegistroAuditoria(ambiente, provedor, resultado, motivo));
    }
    public synchronized List<RegistroAuditoria> consultarHistorico() {
        return new ArrayList<>(registros);
    }
    public void imprimirHistorico() {
        System.out.println("\n=== HISTORICO DE AUDITORIA ===");
        for (RegistroAuditoria registro : consultarHistorico()) {
            System.out.println(registro);
        }
    }
}
