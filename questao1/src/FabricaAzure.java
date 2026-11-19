import java.util.concurrent.atomic.AtomicInteger;

public final class FabricaAzure implements FabricaNuvem {
    private static final AtomicInteger MAQUINAS = new AtomicInteger();
    private static final AtomicInteger ARMAZENAMENTOS = new AtomicInteger();
    private static final AtomicInteger FILAS = new AtomicInteger();

    @Override public double estimarCustoMensal(int maquinas, int gb) {
        return maquinas * 0.12 * 730 + gb * 0.02 + 0.5;
    }
    @Override public String getProvedor() { return "Azure"; }
    @Override public MaquinaVirtual criarMaquinaVirtual() {
        return new AzureMaquinaVirtual(MAQUINAS.incrementAndGet());
    }
    @Override public Armazenamento criarArmazenamento() {
        return new AzureArmazenamento(ARMAZENAMENTOS.incrementAndGet());
    }
    @Override public FilaMensagens criarFila() {
        return new AzureFila(FILAS.incrementAndGet());
    }
}
