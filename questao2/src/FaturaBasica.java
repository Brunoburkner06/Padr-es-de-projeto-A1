import java.util.Collections;
import java.util.List;

public final class FaturaBasica implements Fatura {
    private final String nomeLote;
    private final double valorVenda;
    public FaturaBasica(Lote lote) {
        this.nomeLote = lote.getNome();
        this.valorVenda = lote.getValorVenda();
    }
    @Override public String getNomeLote() { return nomeLote; }
    @Override public double getValorVenda() { return valorVenda; }
    @Override public double getTotal() { return valorVenda; }
    @Override public List<String> getItensAdicionais() { return Collections.emptyList(); }
}
