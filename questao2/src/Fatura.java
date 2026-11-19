import java.util.List;

public interface Fatura {
    String getNomeLote();
    double getValorVenda();
    double getTotal();
    List<String> getItensAdicionais();
    default void imprimir() {
        System.out.println("\n=== FATURA DO COMPRADOR ===");
        System.out.println("Lote: " + getNomeLote());
        System.out.printf("Valor de venda: R$ %.2f%n", getValorVenda());
        for (String item : getItensAdicionais()) System.out.println(item);
        System.out.printf("Total a pagar: R$ %.2f%n", getTotal());
    }
}
