import java.util.ArrayList;
import java.util.List;

public final class Lote {
    private final String nome;
    private final String categoria;
    private final double precoInicial;
    private final double precoReserva;
    private double lanceAtual;
    private boolean aberto = true;
    private boolean vendido;
    private RegraComissao regraComissao;
    private final List<Lance> lances = new ArrayList<>();
    private final List<ObservadorLance> observadores = new ArrayList<>();

    public Lote(String nome, String categoria, double precoInicial, double precoReserva, RegraComissao regra) {
        if (nome == null || nome.isBlank() || categoria == null || categoria.isBlank()
                || precoInicial <= 0 || precoReserva < 0 || regra == null) {
            throw new IllegalArgumentException("Dados do lote invalidos");
        }
        this.nome = nome;
        this.categoria = categoria;
        this.precoInicial = precoInicial;
        this.precoReserva = precoReserva;
        this.lanceAtual = precoInicial;
        this.regraComissao = regra;
    }
    public String getNome() { return nome; }
    public String getCategoria() { return categoria; }
    public double getPrecoInicial() { return precoInicial; }
    public double getLanceAtual() { return lanceAtual; }
    public int getTotalLances() { return lances.size(); }
    public boolean isVendido() { return vendido; }
    public void acompanhar(ObservadorLance observador) {
        if (!observadores.contains(observador)) observadores.add(observador);
    }
    public void deixarDeAcompanhar(ObservadorLance observador) { observadores.remove(observador); }
    public void trocarRegraComissao(RegraComissao novaRegra) {
        if (!aberto || novaRegra == null) throw new IllegalStateException("Nao e possivel trocar a regra");
        this.regraComissao = novaRegra;
    }
    public boolean darLance(Participante participante, double valor) {
        if (!aberto) {
            System.out.println("Lance recusado: lote " + nome + " ja esta encerrado.");
            return false;
        }
        double minimo = lanceAtual * 1.05;
        if (!Double.isFinite(valor) || valor < minimo) {
            System.out.printf("Lance recusado em %s: R$ %.2f; minimo exigido: R$ %.2f%n", nome, valor, minimo);
            return false;
        }
        Lance lance = new Lance(participante, valor);
        lanceAtual = valor;
        lances.add(lance);
        System.out.printf("Lance aceito em %s: %s ofereceu R$ %.2f%n", nome, participante.getNome(), valor);

        for (ObservadorLance observador : new ArrayList<>(observadores)) observador.atualizar(this, lance);
        return true;
    }
    public void encerrar() {
        if (!aberto) throw new IllegalStateException("Lote ja encerrado");
        aberto = false;
        vendido = !lances.isEmpty() && lanceAtual >= precoReserva;
        System.out.println("\nLote " + nome + " encerrado: " + (vendido ? "VENDIDO" : "NAO VENDIDO"));
        if (vendido) imprimirAcertoVendedor();
    }
    public double getValorVenda() {
        if (!vendido) throw new IllegalStateException("Lote nao vendido");
        return lanceAtual;
    }
    public void imprimirAcertoVendedor() {
        double venda = getValorVenda();
        double comissao = regraComissao.calcular(venda);
        System.out.printf("Acerto do vendedor [%s]: venda R$ %.2f | comissao R$ %.2f | liquido R$ %.2f%n",
                nome, venda, comissao, venda - comissao);
    }
}
