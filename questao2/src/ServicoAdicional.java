import java.util.ArrayList;
import java.util.List;

public abstract class ServicoAdicional implements Fatura {
    protected final Fatura fatura;
    protected ServicoAdicional(Fatura fatura) { this.fatura = fatura; }
    protected abstract String descricao();
    protected abstract double custo();
    @Override public String getNomeLote() { return fatura.getNomeLote(); }
    @Override public double getValorVenda() { return fatura.getValorVenda(); }
    @Override public double getTotal() { return fatura.getTotal() + custo(); }
    @Override public List<String> getItensAdicionais() {
        List<String> itens = new ArrayList<>(fatura.getItensAdicionais());
        itens.add(String.format("%s: R$ %.2f", descricao(), custo()));
        return itens;
    }
}
