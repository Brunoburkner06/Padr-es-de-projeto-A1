import java.util.concurrent.atomic.AtomicInteger;

public final class FabricaAws implements FabricaNuvem {
    private static final AtomicInteger MAQUINAS = new AtomicInteger();
    private static final AtomicInteger ARMAZENAMENTOS = new AtomicInteger();
    private static final AtomicInteger FILAS = new AtomicInteger();

    @Override public double estimarCustoMensal(int maquinas, int gb) {
        return maquinas * 0.1 * 730 + gb * 0.023 + 0.4;
    }
    @Override public String getProvedor() { return "Aws"; }
    @Override public MaquinaVirtual criarMaquinaVirtual() {
        return new AwsMaquinaVirtual(MAQUINAS.incrementAndGet());
    }
    @Override public Armazenamento criarArmazenamento() {
        return new AwsArmazenamento(ARMAZENAMENTOS.incrementAndGet());
    }
    @Override public FilaMensagens criarFila() {
        return new AwsFila(FILAS.incrementAndGet());
    }
}
