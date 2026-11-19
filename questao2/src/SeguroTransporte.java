public final class SeguroTransporte extends ServicoAdicional {
    public SeguroTransporte(Fatura fatura) { super(fatura); }
    @Override protected String descricao() { return "Seguro de transporte"; }
    @Override protected double custo() { return getValorVenda() * 0.015; }
}
